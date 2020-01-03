package test.zt.beetl.dao;

import org.beetl.sql.core.annotatoin.SqlResource;
import org.beetl.sql.core.mapper.BaseMapper;
import test.zt.beetl.entity.User;

/**
 * @author zangtao
 * @date 2020/1/2 12:21
 */
@SqlResource("user/user")
public interface UserDao extends BaseMapper<User> {


}
