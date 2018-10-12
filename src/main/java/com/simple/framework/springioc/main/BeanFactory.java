package com.simple.framework.springioc.main;

/**
 * 项目名称:simple-springioc-framework 描述: 创建人:ryw 创建时间:2018/10/11
 */
public interface BeanFactory {

    //核心方法getBean
    Object getBean(String name);
}
