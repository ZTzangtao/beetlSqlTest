package test.zt.beetl.service.impl;

import org.beetl.sql.core.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.zt.beetl.base.Response;
import test.zt.beetl.mapper.UserMapper;
import test.zt.beetl.entity.User;
import test.zt.beetl.service.UserService;

import java.util.List;

/**
 * @author zangtao
 * @date 2020/1/2 12:16
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    SQLManager sqlManager;

    @Autowired
    private UserMapper userMapper;


    @Override
    public Response createUser(User user) {
        return null;
    }

    @Override
    public Response getUserByName(String name,Integer age) {
        List<User> userList = userMapper.selectUser(name, age);
//        List<User> userList =  userMapper.all();
        return Response.success(userList);
    }


}
