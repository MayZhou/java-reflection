package com.mayzhou.learn.reflection.excel.controller;

import com.mayzhou.learn.reflection.excel.entity.Student;
import com.mayzhou.learn.reflection.excel.util.ExcelUtil;
import com.mayzhou.learn.reflection.excel.util.NameUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Auther: MayZhou
 * @Date: 19/4/21 03:50
 * @Description:
 * @copyright:
 * @version:
 */
public class ReportFormController {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Student student = new Student();

            student.setName(NameUtil.getNames());
            Random random = new Random(System.currentTimeMillis());
            student.setAge(random.nextInt(47));
            student.setClassName("LOL");
            student.setSchoolName("dota");
            student.setSex("男");
            students.add(student);
        }
        //excel标题
        String[] title = {"名称", "性别", "年龄", "学校", "班级"};
        //excel文件名
        String fileName = "学生信息表" + System.currentTimeMillis() + ".xls";
        //sheet名
        String sheetName = "学生信息表";
        String[][] content = new String[students.size()][title.length];
        for (int i = 0; i < students.size(); i++) {
            content[i][0] = students.get(i).getName();
            content[i][1] = students.get(i).getSex();
            content[i][2] = String.valueOf(students.get(i).getAge());
            content[i][3] = students.get(i).getSchoolName();
            content[i][4] = students.get(i).getClassName();
            System.out.println(content[i]);
        }
        HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName,title,content,null);
        File file = new File("D:" +  File.separator +fileName);
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        try {
            OutputStream os = new FileOutputStream(file);
            wb.write(os);
            os.flush();
            os.close();
        } catch (FileNotFoundException f){
            f.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
