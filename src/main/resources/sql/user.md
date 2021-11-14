selectUser
===
select id, name, age from user where 1 = 1
    @if(isNotEmpty(name)){
        and name like #{name}
    @}

