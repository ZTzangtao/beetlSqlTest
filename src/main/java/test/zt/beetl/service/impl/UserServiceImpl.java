package test.zt.beetl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.zt.beetl.base.Response;
import test.zt.beetl.dao.UserDao;
import test.zt.beetl.entity.User;
import test.zt.beetl.service.UserService;

import java.util.Date;

/**
 * @author zangtao
 * @date 2020/1/2 12:16
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public Response createUser(User user) {
        user.setCreateDate(new Date());
        userDao.insertTemplate(user);
        return Response.success("新增成功");
    }
}
