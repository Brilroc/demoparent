package dhcc.com.cn.util;

import java.io.File;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import dhcc.com.cn.vo.Result;

public class UploadUtil {
		
		public Result uploadPic(MultipartFile picUploadFile) {
			//获取项目绝对路径
			String webappRoot = PathUtil.getPath();
			Result result=new Result();
			//拿到图片源文件名称,解析后缀是否合法;
			String oldName=picUploadFile.getOriginalFilename();
			//oldName=assaasdfafsadf.jpg
			//解析后缀
			String extName=oldName.substring(oldName.lastIndexOf("."));
			//判断合法,满足后缀是jpg.png,gif其中一个就行,正则表达式
			if(!(extName.matches("^.(png|jpg|gif)$"))){
				result.setStatus("false");
				result.setMsg("上传文件格式不符合要求。");
				System.out.println("上传文件格式不符合要求。");
			}
			String path=webappRoot+"src/main/resources/static/img/upload/";
			try{
				//创建path文件夹
				File _dir=new File(path);
				if(!_dir.exists()){
					_dir.mkdirs();
				}
				//重命名图片
				String fileName=UUID.randomUUID().toString()+extName;
				picUploadFile.transferTo(new File(path+fileName));
				//赋值url地址
				String url="img/upload/"+fileName;
				result.setData(url);
			}catch(Exception e){
				e.printStackTrace();
				result.setStatus("false");
				System.out.println("false");
				return result;
			}
			result.setMsg("上传成功");
			System.out.println(result);
			return result;
		}
		

		//暂未使用此方法
		public String getUploadPath(String fileName,String upload){	
			//根据图片名称,生成路径结构upload/1/2/3/2/1/5..
			String hash = Integer.toHexString(fileName.hashCode());
			while(hash.length()<8){
				hash += "0";
			}
			for (int i = 0; i < hash.length(); i++) {
				upload += "/"+hash.charAt(i);
			}	
			return upload;
		}

}
