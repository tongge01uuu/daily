package com.we.contract.architect.interceptor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;

import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * Created by yukai on 2017-8-30.
 */
@Component
public class EncodingPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String name)
            throws BeansException {
        if (bean instanceof AnnotationMethodHandlerAdapter) {
            HttpMessageConverter<?>[] convs = ((AnnotationMethodHandlerAdapter) bean).getMessageConverters();
            for (HttpMessageConverter<?> conv: convs) {
                if (conv instanceof StringHttpMessageConverter) {
                    ((StringHttpMessageConverter) conv).setSupportedMediaTypes(
                            Arrays.asList(new MediaType("text", "html",
                                    Charset.forName("UTF-8"))));
                }
            }
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String name)
            throws BeansException {
        return bean;
    }
}
