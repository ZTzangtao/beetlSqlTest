package test.zt.beetl.service;

import test.zt.beetl.base.Response;
import test.zt.beetl.entity.User;

/**
 * @author zangtao
 * @date 2020/1/2 12:16
 */
public interface UserService {

    /**
     * 创建用户
     *
     * @param user
     * @return
     */
    Response createUser(User user);

    /**
     * 根据name模糊查询
     *
     * @param name
     * @param age
     * @return
     */
    Response getUserByName(String name,Integer age);
}
