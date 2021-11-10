package test.zt.beetl.entity;


import lombok.Data;
import org.beetl.sql.annotation.entity.AutoID;
import org.beetl.sql.annotation.entity.Table;


/**
 * @author zangtao
 * @date 2020/1/2 10:01
 */

@Table(name="user")
@Data
public class User {
    @AutoID
    private Integer id;
    private String name;
    private Integer age;

   
}
