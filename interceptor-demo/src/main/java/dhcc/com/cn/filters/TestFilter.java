package dhcc.com.cn.filters;


import dhcc.com.cn.controller.IndexController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wangpenghui on 2019/12/10
 */
public class TestFilter implements Filter {
    public final static Logger logger = LoggerFactory.getLogger(TestFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long start = System.currentTimeMillis();
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String methodName = req.getMethod();
        logger.info("[filter] request method is : " + methodName);
        String uri = req.getRequestURI();
        logger.info("[filter] request uri is : " + uri);

        filterChain.doFilter(servletRequest, servletResponse);
        logger.info("[filter] execute filter time = " + (System.currentTimeMillis() - start) + "ms");
    }

    @Override
    public void destroy() {

    }
}
