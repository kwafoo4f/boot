package cn.zk.springboot.core.nanotation;

import cn.zk.springboot.core.ZkConditionOnClassHandler;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value={TYPE,METHOD})
@Conditional(ZkConditionOnClassHandler.class)// 条件判断逻辑由ZkConditionOnClassHandler实现
public @interface ZkConditionOnClass {

    /**
     * 类的全限定名
     * @return
     */
    String value();

}
