package com.rouvsen.bean;

import com.rouvsen.dto.BeanDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanConfig {

    @Bean(initMethod = "initialBeanMethod", destroyMethod = "destroyBeanMethod")
    @Scope("singleton") //Project boyunca var olur (pr. run ==> pr. kill), other scopes: request, session, prototype
    public BeanDto getBeanDto() {
        return BeanDto
                .builder()
                    .beanId(0L)
                    .beanName("bean Name")
                    .beanData("bean Data")
                .build();
    }
}