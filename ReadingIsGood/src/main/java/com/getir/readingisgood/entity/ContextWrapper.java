package com.getir.readingisgood.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class ContextWrapper {
    private static ApplicationContext context;

    @Autowired
    public ContextWrapper(ApplicationContext ac) {
        setContext(ac);
    }

    public static ApplicationContext getContext() {
        return context;
    }

    public static void setContext(ApplicationContext context) {
        ContextWrapper.context = context;
    }
}