package com.mayzhou.learn.reflection.main;

import com.mayzhou.learn.reflection.entity.ObjectAnalyzer;

import java.util.ArrayList;

/**
 * @Auther: MayZhou
 * @Date: 19/3/30 08:31
 * @Description:
 * @copyright:
 * @version:
 */
public class ObjectAnalyzerTest {

    public static void main(String[] args) {
        ArrayList<Integer> squares = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            squares.add(i * i);
        }
        System.out.println(new ObjectAnalyzer().toString(squares));
    }
}
