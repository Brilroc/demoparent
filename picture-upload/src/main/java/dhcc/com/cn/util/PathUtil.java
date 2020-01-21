/**
 * 
 */
package dhcc.com.cn.util;

/**
 * @author dhcc.com.cn
 * create date: 2019年9月20日 上午11:48:49
 */
public class PathUtil {
	public static PathUtil pathUtil = new PathUtil();
	public static String getPath() {
		//获取项目绝对路径
		String classpath = pathUtil.getClass().getResource("/").getPath().replaceFirst("/", "");
		String webappRoot = classpath.replaceAll("target/classes/", "");
		System.out.println("webappRoot: "+webappRoot);
		return webappRoot;
	}
	
}
