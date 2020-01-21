/**
 * 
 */
package dhcc.com.cn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import dhcc.com.cn.service.ImageClipService;
import dhcc.com.cn.util.PathUtil;
import dhcc.com.cn.vo.Result;

/**
 * @author dhcc.com.cn
 * create date: 2019年9月19日 上午9:59:02
 */
@Controller
public class ImageClipController {

	@Autowired
	private ImageClipService imageClipService;

	// 实现图片上传
	@RequestMapping(value = "/imgUpload" , method=RequestMethod.POST )
	@ResponseBody
	public Result picUpload(@RequestParam(value="file")
			MultipartFile picUploadFile, Model model){
		Result result = imageClipService.uploadPic(picUploadFile);
		//model.addAttribute("imgSrc", result.getData());
		return result;
	}
	
	@RequestMapping(value="/imgClip",method=RequestMethod.POST)
	@ResponseBody
	public Result imageClip(String srcImg, int x, int y, int width, int height) {
		String destImg = PathUtil.getPath()+"src/main/resources/static/img/upload/icon/";
		srcImg = PathUtil.getPath()+"src/main/resources/static/"+srcImg;
		imageClipService.cutImage(srcImg, destImg, x, y, width, height);
		Result result=new Result();
		result.setStatus("1");
		return result;
	}
	

}
