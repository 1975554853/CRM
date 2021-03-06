package com.spring.auth;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;

public class SystemUtil {

    public static String USER_MODULES = "userModules";
    public static final String STATIC_NO_PERMISSION_PATH =

            ".*/((toLog)|(per)).*";


    public static String getMethodOfPermission(HandlerMethod handler) {
        String permissionName = handler.getMethodAnnotation(RequestMapping.class).name();

        if("".equals(permissionName))
            return null;

        String permissionNameURL = handler.getMethodAnnotation(RequestMapping.class).value()[0];
        String permissionModuleURL = handler.getBeanType().getAnnotation(RequestMapping.class).value()[0];
        return (permissionModuleURL + ":" + permissionNameURL).replace("/","");

    }
}
