/**
 * 
 */
package dhcc.com.cn.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import dhcc.com.cn.util.ImageClip;
import dhcc.com.cn.util.PathUtil;
import dhcc.com.cn.util.ReduceImg;
import dhcc.com.cn.util.UploadUtil;
import dhcc.com.cn.vo.Result;

/**
 * @author dhcc.com.cn
 * create date: 2019年9月20日 上午10:26:02
 */
@Service
public class ImageClipService {

	
//	@Autowired
//	private ImageClipMapper imageClipMapper;
	
	public Result uploadPic(MultipartFile picUploadFile) {
		Result result=new UploadUtil().uploadPic(picUploadFile);
		String srcImg = PathUtil.getPath()+"src/main/resources/static/"+result.getData();
		//压缩后替换原文件
		ReduceImg.reduceImg(srcImg, srcImg, 500, 300, null);
		return result;
	}

	public void cutImage(String srcImg, String destImg, int x, int y, int width, int height) {
		String imgUrl = new ImageClip().cutImage(srcImg, destImg, x, y, width, height);	
		System.out.println("裁剪后imgUrl:"+imgUrl);
		String[] strs=imgUrl.split("resources");
		imgUrl = strs[1].substring(1);
		//将图片路径存入数据库
		//imageClipMapper.updateImgUrl(imgUrl);

		
	}

}
