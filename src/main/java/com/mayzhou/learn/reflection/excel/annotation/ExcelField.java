package com.mayzhou.learn.reflection.excel.annotation;

/**
 * @Auther: MayZhou
 * @Date: 19/4/21 13:56
 * @Description:
 * @copyright:
 * @version:
 */
public @interface ExcelField {
    String value() default "";

    String title();

    int type() default 0;

    int align() default 0;

    int sort() default 0;

    String dictType() default "";

    Class<?> fieldType() default Class.class;

    int[] groups() default {};
}
