package com.example.springcustomannotationsample.service;

import com.example.springcustomannotationsample.service.annotation.DataAccess;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

@Slf4j
public class DataAccessFieldCallback implements ReflectionUtils.FieldCallback {

    private ConfigurableListableBeanFactory configurableBeanFactory;
    private Object bean;

    public DataAccessFieldCallback(ConfigurableListableBeanFactory configurableListableBeanFactory, Object bean) {
        this.configurableBeanFactory = configurableListableBeanFactory;
        this.bean = bean;
    }

    private static int AUTOWIRE_MODE = AutowireCapableBeanFactory.AUTOWIRE_BY_NAME;
    private static String ERROR_ENTITY_VALUE_NOT_SAME = "";
    private static String WARN_NON_GENERIC_VALUE = "";
    private static String ERROR_CREATE_INSTANCE = "";

    @Override
    public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
        if (field == null){
            return;
        }

        ReflectionUtils.makeAccessible(field);
        //返回注入字段的范型类型，这里应该返回User
        Type fieldGenericType = field.getGenericType();
        //返回当前字段的类型，这里应该返回GenericDAO
        Class<?> generic = field.getType();
        //返回带有DataAccess注解的类的值
        Class<?> classValue = field.getDeclaredAnnotation(DataAccess.class).entity();
        if (genericTypeIsValid(classValue, fieldGenericType)){
            String beanName = classValue.getSimpleName() + generic.getSimpleName();
            Object beanInstance = getBeanInstance(beanName, generic, classValue);
            field.set(bean, beanInstance);
        }
    }

    private Object getBeanInstance(String beanName, Class<?> genericClass, Class<?> paramClass) {
        Object daoInstance = null;
        if (!configurableBeanFactory.containsBean(beanName)) {
            log.warn("Creating new DataAccess bean named '{}'.", beanName);

            Object toRegister = null;
            try {
                Constructor<?> ctr = genericClass.getConstructor(Class.class);
                toRegister = ctr.newInstance(paramClass);
            } catch (Exception e) {
                log.error(ERROR_CREATE_INSTANCE, genericClass.getTypeName(), e);
                throw new RuntimeException(e);
            }

            daoInstance = configurableBeanFactory.initializeBean(toRegister, beanName);
            configurableBeanFactory.autowireBeanProperties(daoInstance, AUTOWIRE_MODE, true);
            configurableBeanFactory.registerSingleton(beanName, daoInstance);
            log.info("Bean named '{}' created successfully.", beanName);
        } else {
            daoInstance = configurableBeanFactory.getBean(beanName);
            log.info(
                    "Bean named '{}' already exists used as current bean reference.", beanName);
        }
        return daoInstance;
    }


    private boolean genericTypeIsValid(Class<?> clazz, Type field){
        if (field instanceof ParameterizedType){
            ParameterizedType parameterizedType = (ParameterizedType) field;
            Type type = parameterizedType.getActualTypeArguments()[0];
            return type.equals(clazz);
        }else{
            log.warn(WARN_NON_GENERIC_VALUE);
            return true;
        }
    }
}
