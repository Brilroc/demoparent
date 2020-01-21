package dhcc.com.cn.config;

import dhcc.com.cn.filters.TestFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by wangpenghui on 2019/12/10
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean registFilter() {
        FilterRegistrationBean filterReg = new FilterRegistrationBean();
        filterReg.setFilter(new TestFilter());
        filterReg.addUrlPatterns("/*"); //过滤所有访问路径
        filterReg.setName("TestFilter");
        filterReg.setOrder(1);  //设置filter执行顺序
        return filterReg;
    }
}
