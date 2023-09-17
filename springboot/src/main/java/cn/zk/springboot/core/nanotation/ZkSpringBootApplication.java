package cn.zk.springboot.core.nanotation;

import cn.zk.springboot.autoconfiguration.ZkImportSelect;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value={TYPE})
@Configuration// 交给spring管理
@ComponentScan // 扫描该注解类（启动类）所在包下的bean
@Import(ZkImportSelect.class) // 导入自动配置注入的处理
public @interface ZkSpringBootApplication {
}
