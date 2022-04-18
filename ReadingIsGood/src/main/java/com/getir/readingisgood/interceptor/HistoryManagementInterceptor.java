package com.getir.readingisgood.interceptor;

import com.getir.readingisgood.anotations.Historical;
import com.getir.readingisgood.entity.BaseHistoryEntity;
import com.getir.readingisgood.entity.ChangeEntry;
import com.getir.readingisgood.entity.ContextWrapper;
import com.getir.readingisgood.service.base.AbstractEntityService;
import com.sun.istack.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class HistoryManagementInterceptor extends EmptyInterceptor {

    private static final Logger LOGGER = Logger.getLogger(HistoryManagementInterceptor.class);
    @Override
    public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) {
        saveHistory(entity, (Long) id, currentState, previousState, propertyNames);
        return super.onFlushDirty(entity, id, currentState, previousState, propertyNames, types);
    }

    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        saveHistory(entity, (Long) id, state, null, propertyNames);
        return super.onSave(entity, id, state, propertyNames, types);
    }

    private void saveHistory(Object entity, Long id, Object[] currentState, Object[] previousState, String[] propertyNames) {
        if (isHistoricalEntity(entity)) {
            String historyServiceBeanName = getHistoryServiceName(entity);
            AbstractEntityService historyService = (AbstractEntityService) ContextWrapper.getContext().getBean(historyServiceBeanName);
            BaseHistoryEntity historyEntityInstance = (BaseHistoryEntity) historyService.getHistoryEntityInstance();
            historyEntityInstance.setMainEntityId(id);

            if (previousState != null) {
                List<ChangeEntry> changeEntries = prepareChangeList(currentState, previousState, propertyNames);
                changeEntries.forEach(changeEntry -> {
                    BaseHistoryEntity baseHistoryEntity = (BaseHistoryEntity) historyEntityInstance.clone();
                    baseHistoryEntity.setChangeEntry(changeEntry);
                    historyService.save(baseHistoryEntity);
                });
            } else {
                historyService.save(historyEntityInstance);
            }

            log.info("[saveHistory] History saved successfully. History: {}", historyEntityInstance.toString());
        }
    }

    private List<ChangeEntry> prepareChangeList(Object[] currentState, Object[] previousState, String[] propertyNames) {
        List<ChangeEntry> changeEntries = new ArrayList<>();

        for (int i = 0; i < propertyNames.length; i++) {
            boolean createHistory = false;
            if (currentState[i] != null || previousState[i] == null) {
                if(currentState[i] != null && !currentState[i].equals(previousState[i])) {
                    createHistory = true;
                }
            } else {
                createHistory = true;
            }
            if (createHistory) {
                ChangeEntry changeEntry = new ChangeEntry();
                changeEntry.setFieldName(propertyNames[i]);
                changeEntry.setOldValue(previousState[i] != null ? previousState[i].toString() : null);
                changeEntry.setNewValue(currentState[i] != null ? currentState[i].toString() : null);
                changeEntries.add(changeEntry);
            }
        }
        return changeEntries;
    }

    private boolean isHistoricalEntity(Object entity) {
        Annotation[] annotations = entity.getClass().getAnnotations();

        if (Arrays.stream(annotations).anyMatch(annotation -> annotation.annotationType().equals(Historical.class))) {
            return true;
        }
        return false;
    }

    private String getHistoryServiceName(Object entity) {
        Historical historicalAnnotation = entity.getClass().getAnnotation(Historical.class);
        return historicalAnnotation.serviceName();
    }
}