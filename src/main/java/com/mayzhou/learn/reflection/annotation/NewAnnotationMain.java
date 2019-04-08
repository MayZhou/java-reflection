package com.mayzhou.learn.reflection.annotation;

/**
 * @Auther: MayZhou
 * @Date: 19/4/8 04:22
 * @Description:
 * @copyright:
 * @version:
 */
public class NewAnnotationMain {
    @NewAnnotation("NewAnnotationMain")
    public static void main(String[] args) {
        sayHelloWithDefaultFontColor();
        sayHelloWithRedFontColor();
    }
    @NewAnnotation("NewAnnotationMethod")
    public static void saying(){

    }
    @Greeting(name = "defaultfontcolor")
    public static void sayHelloWithDefaultFontColor() {
    }
    // 将fontColor改为BLUE
    @Greeting(name="notdefault", fontColor=Greeting.FontColor.BLUE)
    public static void sayHelloWithRedFontColor() {
    }
}
