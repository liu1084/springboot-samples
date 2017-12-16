package com.jim.annotation.model.sevice.annotation;

import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;

/**
 * @author: liu jun
 * @date: 17:54 2017/12/15
 * @ver: 1.0
 * @desc:
 */
@Component
public class LogAnnotationBeanPostProcessor implements BeanPostProcessor {
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		ReflectionUtils.doWithMethods(bean.getClass(), new ReflectionUtils.MethodCallback() {
			@Override
			public void doWith(Method method) throws IllegalArgumentException, IllegalAccessException {
				if (null != method.getDeclaredAnnotation(LogAnnotation.class)){
					org.slf4j.Logger logger = LoggerFactory.getLogger(bean.getClass());
					if (logger.isDebugEnabled()){
						logger.debug("annotation-----------");
					}
				}
			}
		});
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {


		return bean;
	}
}
