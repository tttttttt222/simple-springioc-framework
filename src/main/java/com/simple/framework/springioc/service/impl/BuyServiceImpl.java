package com.simple.framework.springioc.service.impl;

import com.simple.framework.springioc.annotation.Autowired;
import com.simple.framework.springioc.annotation.Service;
import com.simple.framework.springioc.entity.Person;
import com.simple.framework.springioc.service.BuyService;

/**
 * 项目名称:simple-springioc-framework 描述: 创建人:ryw 创建时间:2018/10/12
 */
@Service("buyService")
public class BuyServiceImpl implements BuyService {

    @Autowired
    private Person person;

    public String doBuy() {
        System.out.println(person.getTeacher().getStudent().getName() + "....");
        return person.getTeacher().getStudent().getName();
    }



}
