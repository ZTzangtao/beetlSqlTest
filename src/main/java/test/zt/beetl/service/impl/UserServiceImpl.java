package test.zt.beetl.service.impl;

import org.beetl.sql.core.SQLManager;
import org.beetl.sql.core.db.KeyHolder;
import org.beetl.sql.core.query.LambdaQuery;
import org.beetl.sql.core.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import test.zt.beetl.base.Response;
import test.zt.beetl.dao.UserDao;
import test.zt.beetl.entity.User;
import test.zt.beetl.service.UserService;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author zangtao
 * @date 2020/1/2 12:16
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    @Qualifier("aSqlManagerFactoryBean")
    SQLManager sqlManager;


    @Override
    public Response createUser(User user) {
        //名字不能一样
        List<User> userList  = userDao.template(User.builder().name(user.getName()).build());
        if (!CollectionUtils.isEmpty(userList)){
            return Response.error("名字重复");
        }
        user.setCreateDate(new Date());
        KeyHolder keyHolder = userDao.insertReturnKey(user);
        return Response.success("新增成功", keyHolder.getInt());
    }

    @Override
    public Response getUserByName(String name,Integer age) {
            LambdaQuery<User> query = sqlManager.lambdaQuery(User.class);
            List<User> userList = query.andLike(User::getName,"%"+name+"%")
                    .andEq(User::getDelFlag,0)
                    .andEq(User::getAge,Query.filterEmpty(age))
                    .select();
            return Response.success(userList);
        }

    }
