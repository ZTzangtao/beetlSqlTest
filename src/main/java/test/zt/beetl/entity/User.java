package test.zt.beetl.entity;

import lombok.*;

import java.util.Date;

/**
 * @author zangtao
 * @date 2020/1/2 10:01
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User {
    private Integer id;
    private Integer age;
    private String name;
    private Integer departmentId;
    private Date createDate;
    private Short delFlag;
}
