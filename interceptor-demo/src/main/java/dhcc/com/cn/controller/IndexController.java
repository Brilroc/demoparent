package dhcc.com.cn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 过滤器过滤所有路径，并记录日志文件
 */
@Controller
public class IndexController {
    public final static Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping("/layout")
    public String test(Model model){
        model.addAttribute("name", "dayu");
        return "layoutContent";
    }

    /*拦截器拦截路径，需要传参name=haha*/
    @RequestMapping("/inter")
    @ResponseBody
    public String inter(){
        return "hello world";
    }

    @RequestMapping("/log")
    @ResponseBody
    public String log(){
        logger.trace("日志输出： trace level");
        logger.debug("日志输出： debug level");
        logger.info("日志输出： info level");
        logger.warn("日志输出： warn level");
        logger.error("日志输出： error level");
        return "hello world";
    }

    @RequestMapping("/static")
    public String abc(){
        return "redirect:abc.html"; //请求重定向或locaolhost:8080/abc.html直接访问静态资源
    }

}