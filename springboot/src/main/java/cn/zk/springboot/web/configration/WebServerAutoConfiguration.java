package cn.zk.springboot.web.configration;

import cn.zk.springboot.autoconfiguration.AutoConfiguration;
import cn.zk.springboot.core.nanotation.ZkConditionOnClass;
import cn.zk.springboot.web.JettyServer;
import cn.zk.springboot.web.TomcatServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * web服务器自动装配
 */
@Configuration
public class WebServerAutoConfiguration implements AutoConfiguration {

    @Bean
    @ZkConditionOnClass("org.apache.catalina.startup.Tomcat")
    public TomcatServer tomcatServer() {
        System.out.println("WebServerAutoConfiguration:TomcatServer");
        return new TomcatServer();
    }

    @Bean
    @ZkConditionOnClass("org.eclipse.jetty.server.Server")
    public JettyServer jettyServer() {
        System.out.println("WebServerAutoConfiguration:JettyServer");
        return new JettyServer();
    }

}
