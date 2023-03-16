package com.rouvsen.tutorials.controller;

import com.rouvsen.tutorials.bean.BeanConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/bean")
public class BeanController {

    @Autowired
    BeanConfig beanConfig;


    @GetMapping("/beanDto")
    @ResponseBody
    public String getBeanDto(){
        return beanConfig.getBeanDto() + ".";
    }


//    @Autowired
//    Logger LOG;

//    public BeanController(){ //`There is a problem ==> NullPointerException
//        LOG.info("info method of Logger Object");
//    }
    //because > BeanController Object-i yaratmaq isteyende, Contructor-u cagrilanda LOG.info() deyir
    //ve hele @Autowired olunmayib, gelib catmayib ora, Object menimsedenmeyib, Logger Object-i yoxdur.
    //Olmayan bir seyin info() methodunu cagirmaq olmur (Null). Bes Helli? ==> "@PostConstruct"


//    @PostConstruct //`There is no problem
//    public void init(){
//        LOG.info("info method of Logger Object");
//    }
    //PostConstruct ne edir?
    //@Autowired-i izleyir, ve LOG.info() -ya baxir ki LOG field-ine Logger Object-i menimsedilen kimi => LOG.init() cagrilir

//    public static void main(String[] args) {
//        BeanController beanController = new BeanController();
//        System.out.println(beanController);
//    }

}