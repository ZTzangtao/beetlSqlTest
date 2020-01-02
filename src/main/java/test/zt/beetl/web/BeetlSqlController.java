package test.zt.beetl.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.zt.beetl.base.Response;
import test.zt.beetl.entity.User;
import test.zt.beetl.service.UserService;

/**
 * @author zangtao
 * @date 2020/1/2 10:17
 */
@RestController
@RequestMapping("/beetlSql")
public class BeetlSqlController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public Response createUser(@RequestBody User user){
        return userService.createUser(user);
    }

}
