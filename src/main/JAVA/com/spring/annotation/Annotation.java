package com.spring.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
public @interface Annotation {
    String desc() default "...";
    boolean isWrite() default true;
}
