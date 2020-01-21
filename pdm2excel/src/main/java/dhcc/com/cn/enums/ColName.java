package dhcc.com.cn.enums;

/**
 * Created by wangpenghui on 2019/11/19
 */
public enum ColName {
    NAME(0,"name"),CODE(1,"code"),TYPE(2,"type"),LENGTH(3,"length"),DEFAULT_VALUE(4,"defaultValue"),PK(5,"PK");

    private int num;

    private String value;

    private ColName(int num, String value){
        this.num = num;
        this.value = value;
    }

    public int getNum() {
        return num;
    }

    public String getValue() {
        return value;
    }

    public static String getValueByNum(int num) {
        String res="";
        for(ColName colName:ColName.values()){
            if(num == colName.getNum()){
                res = colName.getValue();
            }
        }
        return res==""? null:res;
    }
}
