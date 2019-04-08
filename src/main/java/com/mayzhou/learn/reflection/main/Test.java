package com.mayzhou.learn.reflection.main;

import com.mayzhou.learn.reflection.entity.Employee;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Date;
import java.util.Scanner;

/**
 * @Auther: MayZhou
 * @Date: 19/3/21 04:58
 * @Description:
 * @copyright:
 * @version:
 */
public class Test {
    public static void main(String[] args) throws Exception {
        Employee employee = new Employee();
        employee.setAge(10);
        employee.setName("mayzhou");

        Class c = employee.getClass();
        employee.getClass().newInstance();
        System.out.println(employee.getClass().newInstance());
        System.out.println(c);
        System.out.println(c.getName());
        System.out.println(employee.getName());
        Date date = new Date();
        Class c2 = date.getClass();
        System.out.println(c2);
        String c2Name = c2.getName();
        System.out.println(c2Name);
        Class c3 = Class.forName(c2Name);
        System.out.println(c3);

        String name;
        if (args.length > 0) {
            name = args[0];
        } else {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter class name (e.g. java.util.Date):");
            name = in.next();
        }
        try {
            Class cl = Class.forName(name);
            Class supercl = cl.getSuperclass();
            String modifiers = Modifier.toString(cl.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.print("class" + name);
            if (supercl != null && supercl != Object.class) {
                System.out.print(" extends " + supercl.getName());
            }
            System.out.print("\n{\n");
            printConstructors(cl);
            System.out.println();
            printMethod(cl);
            System.out.println();
            printFields(cl);
            System.out.println("}");

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        System.exit(0);
    }

    /**
     * Prints all constructors of a class
     *
     * @param cl a class
     */
    public static void printConstructors(Class cl) {
        Constructor[] constructors = cl.getDeclaredConstructors();
        for (Constructor c : constructors) {
            String name = c.getName();
            System.out.print(" ");
            String modifiers = Modifier.toString(c.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(name + " ( ");
            }
            // print parameter start
            Class[] paramTypes = c.getParameterTypes();
            for (int j = 0; j < paramTypes.length; j++) {
                if (j > 0) {
                    System.out.print(" , ");
                    System.out.print(paramTypes[j].getName());
                }
            }
            System.out.print(" ); ");
            // print parameter end
        }
    }

    /**
     * prints all method of a class
     *
     * @param cl a class
     */
    public static void printMethod(Class cl) {
        Method[] methods = cl.getDeclaredMethods();
        for (Method m : methods) {
            Class retType = m.getReturnType();
            String name = m.getName();
            System.out.print(" ");
            //print modifiers ,return type and method name start
            String modifiers = Modifier.toString(m.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            //print modifiers ,return type and method name end
            System.out.print(retType.getName() + " " + name + "(");

            //print parameter types start
            Class[] paramTypes = m.getParameterTypes();
            for (int j = 0; j < paramTypes.length; j++) {
                if (j > 0) {
                    System.out.print(paramTypes[j].getName());
                }
            }
            //print parameter types end

            System.out.print(" );");
        }
    }

    /**
     * Prints all fields of a class
     *
     * @param cl a class
     */
    public static void printFields(Class cl) {
        Field[] fields = cl.getDeclaredFields();
        for (Field f : fields) {
            Class type = f.getType();
            String name = f.getName();
            System.out.print(" ");
            String modifiers = Modifier.toString(f.getModifiers());
            if(modifiers.length()>0 ){
                System.out.print(modifiers + " ");
            }
            System.out.println(type.getName() + " " + name + ";");
        }
    }
}
