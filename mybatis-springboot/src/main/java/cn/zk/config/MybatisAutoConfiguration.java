package cn.zk.config;

import cn.zk.bean.Mybatis;
import cn.zk.springboot.autoconfiguration.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisAutoConfiguration implements AutoConfiguration {

    @Bean
    public Mybatis mybatis() {
        System.out.println("mybatis init...");
        return new Mybatis();
    }

}
