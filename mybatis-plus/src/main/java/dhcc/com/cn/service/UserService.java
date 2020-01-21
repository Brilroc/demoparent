package dhcc.com.cn.service;

import dhcc.com.cn.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    void insertUser(User user);

    void deleteById(Long id);

    void updateById(User user);
}
