package com.getir.readingisgood.service.base;

import com.getir.readingisgood.entity.BaseEntity;
import com.getir.readingisgood.entity.BaseHistoryEntity;
import com.getir.readingisgood.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

@Slf4j
public abstract class AbstractEntityService<T extends BaseEntity, PK extends Serializable> {
    public AbstractEntityService() {
    }

    public abstract JpaRepository<T, PK> getJpaRepository();

    protected T verifySave(T entity) {
        return entity;
    }

    @Transactional
    public T save(T entity) {
        this.verifySave(entity);
        if (this.getJpaRepository() != null) {
            this.getJpaRepository().save(entity);
        }

        return entity;
    }

    public T getHistoryEntityInstance() {
        for (Type actualTypeArgument : ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()) {
            Class entityClass = (Class) actualTypeArgument;
            if (entityClass.getSuperclass() == BaseHistoryEntity.class) {
                try {
                    return (T) entityClass.getDeclaredConstructor().newInstance();
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    log.error("[getHistoryEntityInstance] exception message : " + e.getMessage(), e);
                }
            }
        }

        throw new NotFoundException("Entity not found.");
    }

}