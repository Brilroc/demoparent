package dhcc.com.cn.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import dhcc.com.cn.entity.User;
import dhcc.com.cn.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    public List<User> getAll(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("age", 20);
        List<User> users = userMapper.selectList(queryWrapper);
        return users;
    }

    @Override
    public void insertUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public void deleteById(Long id) {
        userMapper.deleteById(id);
    }

    @Override
    public void updateById(User user) {
        userMapper.updateById(user);
    }
}
