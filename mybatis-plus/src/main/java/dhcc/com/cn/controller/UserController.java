package dhcc.com.cn.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import dhcc.com.cn.entity.User;
import dhcc.com.cn.service.UserService;
import dhcc.com.cn.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/getAll")
    @ResponseBody
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("/insertUser")
    @ResponseBody
    public String insertUser(User user){
        userService.insertUser(user);
        return user.toString();
    }

    @GetMapping("/deleteById")
    @ResponseBody
    public String deleteById(Long id){
        userService.deleteById(id);
        return "success";
    }

    @GetMapping("/updateById")
    @ResponseBody
    public String updateById(User user){
        userService.updateById(user);
        return "success";
    }

}
