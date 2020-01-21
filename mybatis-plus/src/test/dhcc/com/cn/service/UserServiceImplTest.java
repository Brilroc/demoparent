package dhcc.com.cn.service;

import dhcc.com.cn.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Resource
    private UserServiceImpl userServiceImpl;

    @Test
    public void getAll() throws Exception {
        List<User> user =  userServiceImpl.getAll();
        System.out.println(user);
    }

}