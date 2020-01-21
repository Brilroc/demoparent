package dhcc.com.cn.entity;

/**
 * Created by wangpenghui on 2019/11/18
 */
public class Column {

    private String name;

    private  String type;

    private  String code;

    private  int length;

    private String defaultValue;

    private  boolean PK;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public boolean isPK() {
        return PK;
    }

    public void setPK(boolean PK) {
        this.PK = PK;
    }

    @Override
    public String toString() {
        return "Column{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", code='" + code + '\'' +
                ", length=" + length +
                ", defaultValue='" + defaultValue + '\'' +
                ", PK=" + PK +
                '}';
    }
}
