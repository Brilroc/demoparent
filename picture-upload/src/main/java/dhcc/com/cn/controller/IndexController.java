package dhcc.com.cn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wangpenghui on 2019/11/25
 */
@Controller
public class IndexController {

    @GetMapping("/imageClip")
    public String imageClip(){
        return "ImageClip";
    }
}
