package test.zt.beetl.annotatoin;

import test.zt.beetl.base.LogicDeleteType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zangtao
 * @date 2020/1/5 16:14
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogicDelete {

    //当前被注解的字段类型
    LogicDeleteType value() default LogicDeleteType.Short;

    //当字段为Boolean类型时 逻辑删除的取值
    boolean boolValue() default false;

    //当字段为数字类型时的 逻辑删除的取值
    int numValue() default 0;

    //当字段为字符串类型时的 逻辑删除的取值
    String strValue() default "DELETE";

    //当字段为短整型类型时的 逻辑删除的取值
    short shortValue() default 0;
}



