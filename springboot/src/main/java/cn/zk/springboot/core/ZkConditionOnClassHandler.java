package cn.zk.springboot.core;

import cn.zk.springboot.core.nanotation.ZkConditionOnClass;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * 使用classloader加载类，来判断类是否存在
 */
public class ZkConditionOnClassHandler implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext,
                           AnnotatedTypeMetadata annotatedTypeMetadata) {
        // 获取注解的属性
        Map<String, Object> zkConditionOnClass = annotatedTypeMetadata.getAnnotationAttributes(ZkConditionOnClass.class.getName());
        String className = (String) zkConditionOnClass.get("value");

        System.out.println("ZkConditionOnClassHandler==>"+className);
        try {
            // 使用classloader加载类
            Class<?> aClass = conditionContext.getClassLoader().loadClass(className);
            System.out.println("ZkConditionOnClassHandler==>存在："+aClass.getName());
            return true;
        } catch (ClassNotFoundException e) {
            // 类不存在
            System.err.println("ZkConditionOnClassHandler==>不存在："+className);
            return false;
        }

    }
}
