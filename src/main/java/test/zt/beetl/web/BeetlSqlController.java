package test.zt.beetl.web;

import org.beetl.sql.starter.CodeGenController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("user")
    public Response getUserByName(@RequestParam(required = false, value = "name") String name,
                                  @RequestParam(required = false,value = "age") Integer age){
        return userService.getUserByName(name,age);
}

}
