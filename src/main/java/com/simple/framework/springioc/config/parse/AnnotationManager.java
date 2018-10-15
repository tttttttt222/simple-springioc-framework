package com.simple.framework.springioc.config.parse;

import com.simple.framework.springioc.annotation.Service;
import com.simple.framework.springioc.config.Bean;
import com.simple.framework.springioc.utils.StringUtils;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 项目名称:simple-springioc-framework 描述: 创建人:ryw 创建时间:2018/10/12
 */
public class AnnotationManager {

    private Map<String, Bean> map = new HashMap<String, Bean>();


    private List<String> scannerPackageNames = new ArrayList<>();

    public Map<String, Bean> getAnnotationConfig(List<String> scannerlist) {
        for (String scannerPackage : scannerlist) {
            doScanner(scannerPackage);
        }

        addConfigToMap();

        return map;
    }

    private void addConfigToMap() {
        if (scannerPackageNames.isEmpty()) {
            return;
        }

        for (String scannerPackageName : scannerPackageNames) {

            String beanName = "";
            try {
                Class<?> clazz = Class.forName(scannerPackageName);
                //找到所有包下有service的注解
                if (clazz.isAnnotationPresent(Service.class)) {
                    Service service = clazz.getAnnotation(Service.class);
                    beanName = service.value();

                    if ("".equals(beanName.trim())) {
                        beanName = StringUtils.lowerFirstCase(clazz.getSimpleName());
                    }
//                    Class<?>[] interfaces = clazz.getInterfaces();
                    //接口名
//                    for (Class<?> anInterface : interfaces) {
//
//                    }

                    Bean bean = new Bean();
                    bean.setClassName(scannerPackageName);
                    map.put(beanName, bean);

                }

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                throw new RuntimeException("找不到" + scannerPackageName + "该类");
            }


        }
    }



    private void doScanner(String scannerPackage) {
        URL url = this.getClass().getClassLoader().getResource("");
        File classDir = new File(url.getPath() +scannerPackage.replace(".", "\\"));
        for (File file : classDir.listFiles()) {
            if (file.isDirectory()) {
                doScanner(scannerPackage + "." + file.getName());
            } else {
                String className = scannerPackage + "." + file.getName().replace(".class", "");
                scannerPackageNames.add(className);
            }
        }

    }

}
