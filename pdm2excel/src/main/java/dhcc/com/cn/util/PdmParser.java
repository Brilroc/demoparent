package dhcc.com.cn.util;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dhcc.com.cn.entity.Column;
import dhcc.com.cn.entity.Table;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class PdmParser {

    public Table[] parsePdm(String filePath) {
        Table[] tabs = new Table[] {};
        List<Table> voS = new ArrayList<Table>();
        Table vo = null;
        Column[] cols = null;
        File f = new File(filePath);
        SAXReader sr = new SAXReader();
        Document doc = null;
        try {
            doc = sr.read(f);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Iterator itr = doc.selectNodes("//c:Tables//o:Table").iterator();
        while (itr.hasNext()) {
            vo = new Table();
            cols = new Column[] {};
            List<Column> list = new ArrayList<Column>();
            Column col = null;
            Element e_table = (Element) itr.next();
            vo.setTableName(e_table.elementTextTrim("Name"));
            vo.setTableCode(e_table.elementTextTrim("Code"));
            Iterator itr1 = e_table.element("Columns").elements("Column").iterator();
            while (itr1.hasNext()) {
                try {

                    col = new Column();
                    Element e_col = (Element) itr1.next();
                    String pkID = e_col.attributeValue("Id");
                    col.setDefaultValue(e_col.elementTextTrim("DefaultValue"));
                    col.setName(e_col.elementTextTrim("Name"));
                    if(e_col.elementTextTrim("DataType").indexOf("(") >0){
                        col.setType(e_col.elementTextTrim("DataType").substring(0, e_col.elementTextTrim("DataType").indexOf("(")));
                    }else {
                        col.setType(e_col.elementTextTrim("DataType"));
                    }
                    col.setCode(e_col.elementTextTrim("Code"));
                    col.setLength(e_col.elementTextTrim("Length") == null ? 0 : Integer.parseInt(e_col.elementTextTrim("Length")));
                    if(e_table.element("Keys")!=null){
                        String keys_key_id = e_table.element("Keys").element("Key").attributeValue("Id");
                        String keys_column_ref = "";
                        if(e_table.element("Keys").element("Key").element("Key.Columns") != null){
                            keys_column_ref = e_table.element("Keys").element("Key").element("Key.Columns")
                                    .element("Column").attributeValue("Ref");
                        }
                        String keys_primarykey_ref_id = e_table.element("PrimaryKey").element("Key").attributeValue("Ref");

                        if (keys_primarykey_ref_id.equals(keys_key_id) && keys_column_ref.equals(pkID)) {
                            col.setPK(true);
                            vo.setPkField(col.getCode());
                        }

                    }
                    list.add(col);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            vo.setCols(list.toArray(cols));
            voS.add(vo);
        }
        return voS.toArray(tabs);
    }

    public void printTable(Table[] tabs) {
        List<String> list = new ArrayList<String>();
        for (Table tab : tabs) {
            list.add(tab.getTableName());
            System.out.println(tab.getTableName());
            Column[] cols = tab.getCols();
            for(Column col : cols){
                System.out.println(col.toString());
            }
            System.out.println("<======================>");
        }

    }
}
