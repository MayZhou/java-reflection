package com.mayzhou.learn.reflection.excel.util;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

/**
 * @Auther: MayZhou
 * @Date: 19/4/20 17:09
 * @Description:
 * @copyright:
 * @version:
 */
public class ExcelUtil {
    /**
     * 导出Excel
     *
     * @param sheetName sheet名称
     * @param titles    标题组
     * @param values    内容
     * @param wb        HSSFWorkbook对象
     * @return
     */
    public static HSSFWorkbook getHSSFWorkbook(String sheetName, String[] titles, String[][] values, HSSFWorkbook wb) {
        // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
        if (wb == null) {
            wb = new HSSFWorkbook();
        }
        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet(sheetName);
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
        HSSFRow row = sheet.createRow(0);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        HSSFCell cell = null;
        //创建标题
        for(int i=0;i<titles.length;i++){
            cell = row.createCell(i);
            cell.setCellValue(titles[i]);
            cell.setCellStyle(style);
        }
        for (int i = 0; i < values.length; i++) {
            row = sheet.createRow(i + 1);
            for (int j = 0; j < values[i].length; j++) {
                row.createCell(j).setCellValue(values[i][j]);
            }
        }
        return wb;
    }
}
