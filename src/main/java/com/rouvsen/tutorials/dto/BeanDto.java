package com.rouvsen.tutorials.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Log4j2
@Builder
public class BeanDto {
    private Long beanId;
    private String beanName;
    private String beanData;

    public void initialBeanMethod(){ //Bean baslayanda
        log.info("Bean Initial Method, It will be run Before Initial Bean");
        System.out.println("Bean initial olmadan evvel men Run olunacam.");
    }

    public void destroyBeanMethod(){ //Bean olende
        log.info("Bean Destroy Method, It will be run After Destroy Bean");
        System.err.println("Bean destroy olandan sonra men Run olunacam.");
    }
}
