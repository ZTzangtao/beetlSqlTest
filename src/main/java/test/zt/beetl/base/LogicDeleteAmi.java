//package test.zt.beetl.base;
//
//
//import org.beetl.sql.core.BeetlSQLException;
//import org.beetl.sql.core.SQLManager;
//import org.beetl.sql.core.annotatoin.AssignID;
//import org.beetl.sql.core.annotatoin.AutoID;
//import org.beetl.sql.core.annotatoin.SeqID;
//import org.beetl.sql.core.kit.BeanKit;
//import org.beetl.sql.core.mapper.MapperInvoke;
//import test.zt.beetl.annotatoin.LogicDelete;
//
//
//import java.lang.reflect.Field;
//import java.lang.reflect.Method;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Objects;
//import java.util.stream.Collectors;
//
///**
// * @author zangtao
// * @date 2020/1/5 16:24
// */
//@SuppressWarnings("unchecked")
//public class LogicDeleteAmi implements MapperInvoke {
//    @Override
//    public Object call(SQLManager sm, Class entityClass, String sqlId, Method m, Object[] args) {
//        //获取所有的字段
//        List allFields = fields(entityClass);
//        //筛选出 注解了 @LogicDelete 的字段
//        List logicDeleteFields = allFields
//                .stream()
//                .filter(field -> field.isAnnotationPresent(LogicDelete.class))
//                .collect(Collectors.toList());
//        //未找到 @LogicDelete 注解的字段则抛出异常
//        if (logicDeleteFields.size() == 0) {
//            throw new BeetlSQLException(BeetlSQLException.SQL_SCRIPT_ERROR, "实体 " + entityClass.getName() + " 缺少 @LogicDelete 注解的字段");
//        }
//        Object instance;
//        //当前参数 如果不是当前类型（认为是主键），则实例化当前对象，并将当前参数设置到主键字段上
//        if (!entityClass.isAssignableFrom(args[0].getClass())) {
//            Field idField = allFields.stream()
//                    .filter(field -> Objects.equals(field.getName(), "id")
//                            || field.isAnnotationPresent(AutoID.class)
//                            || field.isAnnotationPresent(AssignID.class)
//                            || field.isAnnotationPresent(SeqID.class))
//                    .findFirst()
//                    .orElseThrow(() -> new BeetlSQLException(BeetlSQLException.ID_NOT_FOUND, "实体 " + entityClass.getName() + " 没有找到主键字段"));
//            instance = BeanKit.newInstance(entityClass);
//            BeanKit.setBeanProperty(instance, args[0], idField.getName());
//        } else {
//            //当前参数是当前类型（如联合主键的情况）
//            instance = args[0];
//        }
//
//
//        //根据 @LogicDelete 分别设置逻辑删除所标注的 删除属性的值
//        logicDeleteFields.forEach(field -> {
//            LogicDelete annotation = field.getAnnotation(LogicDelete.class);
//            switch (annotation.value()) {
//                case INT:
//                    BeanKit.setBeanProperty(instance, annotation.numValue(), field.getName());
//                    break;
//                case BOOL:
//                    BeanKit.setBeanProperty(instance, annotation.boolValue(), field.getName());
//                    break;
//                case STR:
//                    BeanKit.setBeanProperty(instance, annotation.strValue(), field.getName());
//                    break;
//            }
//        });
//        //调用内置的 模板更新方法 更新当前实体
//        return sm.updateTemplateById(instance);
//    }
//
//    private List fields(Class cls) {
//        List fields = new ArrayList<>();
//        while (cls != Object.class) {
//            fields.addAll(Arrays.asList(cls.getDeclaredFields()));
//            cls = cls.getSuperclass();
//        }
//        return fields;
//
//    }
//}
