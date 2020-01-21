package dhcc.com.cn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import dhcc.com.cn.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

//@Mapper 有@MapperScan可以不写这个注解
@Repository
public interface UserMapper extends BaseMapper<User> {

}
