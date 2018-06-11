package com.spring.annotation;

import com.spring.auth.token.JSON_WEB_TOKEN;
import com.spring.auth.token.Token;
import com.spring.mapper.UsersMapper;
import com.spring.pojo.Systemlogmessage;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import java.lang.reflect.Method;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class LogAsp {

    @Autowired
    UsersMapper usersMapper;

    @Around("@annotation(com.spring.annotation.Annotation)")
    public Object around(ProceedingJoinPoint joinPoint) {
        Object object=null;
        String str="";
        boolean iswrite=true;
        Object[] o = joinPoint.getArgs();
        String zhiname = joinPoint.getSignature().getName();
        Class clazz=joinPoint.getTarget().getClass();
        Method[] methods=clazz.getMethods();
        for (Method m:methods) {
            if (m.getName().equals(zhiname)) {
                if (m.getParameterTypes().length == o.length) {
                    Annotation annotation = m.getAnnotation(Annotation.class);
                    str=annotation.desc();
                    iswrite=annotation.isWrite();
                }
            }
        }

        Systemlogmessage systemlogmessage=new Systemlogmessage();
        long starttime=System.currentTimeMillis();
        try {
            object=joinPoint.proceed(o);
            systemlogmessage.setSystemLogMessage_Successful("成功");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            systemlogmessage.setSystemLogMessage_Successful("失败");
            systemlogmessage.setSystemLogMessage_Exception(throwable.toString());
        }
        long endtime = System.currentTimeMillis();
        long time = endtime - starttime;
        String argus = "";
        if(iswrite) {
            for (Object ob : o) {
                argus += (ob + ",");
            }
        }else{
            for (Object ob : o) {
                argus += ob.getClass().getTypeName() + ",";
            }
        }

        //时间格式
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        systemlogmessage.setSystemLogMessage_Name("NULL");
        systemlogmessage.setSystemLogMessage_Roles("NULL");
        systemlogmessage.setSystemLogMessag_Method(zhiname);
        systemlogmessage.setSystemLogMessage_Description(str);
        systemlogmessage.setSystemLogMessage_Params(argus);
        systemlogmessage.setSystemLogMessage_StartTime(Date.valueOf(formatter.format(starttime)));
        systemlogmessage.setSystemLogMessage_Time(String.valueOf(time));

        Integer n= usersMapper.insertlogmessage(systemlogmessage);
        System.out.println(n);

        return object;
    }

}
