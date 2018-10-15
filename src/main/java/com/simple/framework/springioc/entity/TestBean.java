package com.simple.framework.springioc.entity;

import com.simple.framework.springioc.main.BeanFactory;
import com.simple.framework.springioc.main.ClassPathXmlApplicationContext;
import com.simple.framework.springioc.service.BuyService;

/**
 * 项目名称:simple-springioc-framework 描述: 创建人:ryw 创建时间:2018/10/11
 * 转自:https://www.cnblogs.com/fingerboy/p/5425813.html
 */
public class TestBean {

    public static void main(String[] args) {

        BeanFactory bf = new ClassPathXmlApplicationContext("/applicationContext.xml");
//        Person s = (Person) bf.getBean("person");
//        Person s1 = (Person) bf.getBean("person");
//        System.out.println(s == s1);
//        System.out.println(s1);
//        Student stu1 = (Student) bf.getBean("student");
//        Student stu2 = (Student) bf.getBean("student");
//        String name = stu1.getName();
//        System.out.println(name);
//        System.out.println(stu1 == stu2);

        BuyService buyService = (BuyService) bf.getBean("buyService");
        buyService.doBuy();

    }

}
