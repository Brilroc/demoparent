/**
 * 
 */
package dhcc.com.cn.vo;

/**
 * @author dhcc.com.cn
 * create date: 2019年9月19日 上午9:44:25
 */
public class Result {
	
	private String Status;
	private String Msg;
	private Object data;
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getMsg() {
		return Msg;
	}
	public void setMsg(String msg) {
		Msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Result [Status=" + Status + ", Msg=" + Msg + ", data=" + data + "]";
	}

	
}
