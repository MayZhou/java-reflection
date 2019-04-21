package com.mayzhou.learn.reflection.annotation;

import java.lang.annotation.*;

/**
 * @Auther: MayZhou
 * @Date: 19/4/8 04:28
 * @Description:
 * @copyright:
 * @version:
 */
@Target({ElementType.METHOD,ElementType.CONSTRUCTOR})
@Inherited

@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Greeting {
    public enum FontColor {
        BLUE,
        RED,
        GREEN
    };

    String name();

    FontColor fontColor() default FontColor.RED;
}
