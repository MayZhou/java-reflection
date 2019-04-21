package com.mayzhou.learn.reflection.excel.annotation.export;

import com.mayzhou.learn.reflection.excel.annotation.ExcelField;

import java.lang.reflect.Field;

/**
 * @Auther: MayZhou
 * @Date: 19/4/22 02:41
 * @Description:
 * @copyright:
 * @version:
 */
public class ExportExcel {
    public ExportExcel(String title, Class<?> cls, int type, int... groups) {
        Field[] fs = cls.getDeclaredFields();
        for (Field f : fs) {
            ExcelField ef = f.getAnnotation(ExcelField.class);
            if (ef !=null && (ef.type() == 0 || ef.type() == type)){

            }
        }
    }
}
