package com.simple.framework.springioc.utils;

/**
 * 项目名称:simple-springioc-framework 描述: 创建人:ryw 创建时间:2018/10/15
 */
public class StringUtils {

    public static String lowerFirstCase(String simpleName) {
        char[] chars = simpleName.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }

}
