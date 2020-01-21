package dhcc.com.cn.util;

import dhcc.com.cn.entity.Column;
import dhcc.com.cn.entity.Table;
import dhcc.com.cn.enums.ColName;
import dhcc.com.cn.model.ClassType;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by wangpenghui on 2019/11/19
 */
public class CreateExcel {

    public void createExcel(Table[] tables, String path){
        //创建excel文件对象
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFCellStyle style = wb.createCellStyle();
        //样式左对齐
        style.setAlignment(HorizontalAlignment.LEFT);
        HSSFFont font = wb.createFont();
        font.setBold(false);
        font.setFontName("宋体");
        style.setFont(font);
        for(int i=0; i<tables.length;  i++){
            //创建sheet对象
            HSSFSheet sheet = wb.createSheet();
            Column[] cols = tables[i].getCols();
            String tableName = tables[i].getTableName();
            wb.setSheetName(i, tableName);
            for(int r=0; r<cols.length; r++){
                //创建行对象；
                HSSFRow row = sheet.createRow(r);
                for(int c=0; c<=5; c++){
                    if(r == 0){
                        //创建单元格对象,第一行填充
                        Cell cell = row.createCell(c);
                        cell.setCellValue(ColName.getValueByNum(c));
                        cell.setCellStyle(style);
                    }else{
                        //创建单元格对象
                        Cell cell = row.createCell(c);
                        cell.setCellStyle(style);
                        if(getFieldByNum(cols[r-1], c) != null){
                            switch (getFieldByNum(cols[r-1], c).getClass().getName()){ //判断对象属性类型
                                case ClassType.STRING :
                                    cell.setCellValue((String) getFieldByNum(cols[r-1], c));
                                    break;
                                case ClassType.INTEGER :
                                    cell.setCellValue((Integer) getFieldByNum(cols[r-1], c));
                                    break;
                                case ClassType.BOOLEAN :
                                    cell.setCellValue((Boolean) getFieldByNum(cols[r-1], c));
                                    break;
                            }
                        }else {
                            cell.setCellValue("");
                        }
                    }
                }
            }
        }
        try {
            FileOutputStream output = new FileOutputStream(path);
            wb.write(output);
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 遍历返回colunm对象属性值
     * @param column
     * @param num
     * @param <T>
     * @return 返回泛型
     */
    public <T>T getFieldByNum(Column column, int num){
        switch (num){
            case 0:
                return (T)column.getName();
            case 1:
                return (T)column.getCode();
            case 2:
                return (T)column.getType();
            case 3:
                return (T)(Integer)column.getLength();
            case 4:
                return (T)column.getDefaultValue();
            case 5:
                return (T)(Boolean)column.isPK();
            default:
                return null;
        }
    }
}
