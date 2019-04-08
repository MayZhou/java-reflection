package com.mayzhou.learn.reflection.annotation;

/**
 * @Auther: MayZhou
 * @Date: 19/4/8 04:14
 * @Description:
 * @copyright:
 * @version: 编译检查：通过代码里的标识的元数据让编译器实现基本的编译检查
 */
public class OverrideDemoTest {

    @Override
    public String toString() {
        return "测试注解";
    }
    @Deprecated
    public static void DeprecatdeMethod(){

    }

    @SuppressWarnings({"uncheched","deprecation"})
    public void add(){

    }
}
