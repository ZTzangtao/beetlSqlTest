# beetlSqlTest
大赋-高性能sql

demo:
┏━━━━━ Debug [user.$selectAll] ━━━
┣ SQL：	 select * from `user`
┣ 参数：	 []
┣ 位置：	 test.zt.beetl.service.impl.UserServiceImpl.getUserByName(UserServiceImpl.java:35)
┣ 时间：	 45ms
┣ 结果：	 [1]
┗━━━━━ Debug [user.$selectAll] ━━━

┏━━━━━ Debug [user.selectUser] ━━━
┣ SQL：	 select id, name, age from user where 1 = 1 and name like ?
┣ 参数：	 [%z%]
┣ 位置：	 test.zt.beetl.service.impl.UserServiceImpl.getUserByName(UserServiceImpl.java:34)
┣ 时间：	 74ms
┣ 结果：	 [1]
┗━━━━━ Debug [user.selectUser] ━━━


