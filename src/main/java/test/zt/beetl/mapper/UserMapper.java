package test.zt.beetl.mapper;


import org.beetl.sql.mapper.BaseMapper;
import org.beetl.sql.mapper.annotation.SqlResource;
import test.zt.beetl.entity.User;

import java.util.List;

/**
 * @author zangtao
 * @date 2020/1/2 12:21
 */
@SqlResource("user")
public interface UserMapper extends BaseMapper<User> {

    /**
     * demo
     *
     * @param name
     * @param age
     * @return
     */
     List<User> selectUser(String name, Integer age);
}
