package dhcc.com.cn.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import dhcc.com.cn.interceptors.ShowInterceptor;

/**
 * 实现springmvc中拦截器的配置,
 * 需要继承实现webMVC的configureAdaptor的配置适配类
 * @author TEDU
 *
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {
	@Autowired
	private ShowInterceptor showInterceptor;
	//可以覆盖父类中对于interceptor的设置
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//自定义拦截器的加载,registry可以将生成拦截器对象注册
		//匹配一个拦截路径/show/**
		registry.addInterceptor(showInterceptor).
		addPathPatterns("/inter/**");
	}
}













