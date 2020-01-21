package dhcc.com.cn.config;

import dhcc.com.cn.util.PathUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by wangpenghui on 2019/11/26
 */

//添加静态资源虚拟路径映射 图片访问路径
@Configuration
public class MyPicConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //获取项目绝对路径
        String imgUrl = PathUtil.getPath().replace("/", "\\");
        registry.addResourceHandler("/img/upload/**").addResourceLocations("file:"+ imgUrl+"src\\main\\resources\\static\\img\\upload\\");
    }
}