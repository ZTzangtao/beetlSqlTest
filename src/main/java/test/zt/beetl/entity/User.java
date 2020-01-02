package test.zt.beetl.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author zangtao
 * @date 2020/1/2 10:01
 */
@Data
public class User {
    private Integer id;
    private Integer age;
    private String name;
    private Date createDate;

}
