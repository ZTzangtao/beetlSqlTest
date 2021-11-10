package test.zt.beetl.mapper;


import org.beetl.sql.mapper.BaseMapper;
import org.beetl.sql.mapper.annotation.SqlResource;
import org.springframework.stereotype.Repository;
import test.zt.beetl.entity.User;

/**
 * @author zangtao
 * @date 2020/1/2 12:21
 */
@Repository
@SqlResource("user/user")
public interface UserMapper extends BaseMapper<User> {


}
