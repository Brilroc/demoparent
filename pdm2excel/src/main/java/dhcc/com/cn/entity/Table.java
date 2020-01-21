package dhcc.com.cn.entity;

/**
 * Created by wangpenghui on 2019/11/18
 */
public class Table {

    private String tableName;

    private String tableCode;

    private  String PkField;

    private  Column[] cols;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableCode() {
        return tableCode;
    }

    public void setTableCode(String tableCode) {
        this.tableCode = tableCode;
    }

    public String getPkField() {
        return PkField;
    }

    public void setPkField(String PkField) {
        this.PkField = PkField;
    }

    public Column[] getCols() {
        return cols;
    }

    public void setCols(Column[] cols) {
        this.cols = cols;
    }

}
