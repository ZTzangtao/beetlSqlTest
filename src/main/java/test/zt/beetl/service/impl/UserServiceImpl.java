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
//        //名字不能一样
//        List<User> userList  = userDao.template(User.builder().name(user.getName()).build());
//        if (!CollectionUtils.isEmpty(userList)){
//            return Response.error("名字重复");
//        }
////        user.setCreateDate(new Date());
//        KeyHolder keyHolder = userDao.insertReturnKey(user);
//        return Response.success("新增成功", keyHolder.getInt());
        return null;
    }

    @Override
    public Response getUserByName(String name,Integer age) {
//        UserDao mapper = sqlManager.getMapper(UserDao.class);
//        List<User> userList = mapper.all();
//            return Response.success(userList);
        List<User> userList = userMapper.all();
        System.out.println(userList);


            return null;
        }

    }
