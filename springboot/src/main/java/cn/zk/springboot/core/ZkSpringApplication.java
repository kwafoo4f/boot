package cn.zk.springboot.core;


import cn.zk.springboot.web.WebServer;
import org.apache.catalina.*;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.core.StandardEngine;
import org.apache.catalina.core.StandardHost;
import org.apache.catalina.startup.Tomcat;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.Map;

/**
 * 启动入口
 */
public class ZkSpringApplication {

    public static void run(Class<?> clz) {

        // 获取Spring容器
        AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
        // 加载bean
        webApplicationContext.register(clz);
        webApplicationContext.refresh();


        // 启动tomcat
        //startTomcat(applicationContext);

        // 优化版本由用户提供web容器类型
        Map<String, WebServer> webServerMap = webApplicationContext.getBeansOfType(WebServer.class);
        if (!CollectionUtils.isEmpty(webServerMap)) {
            WebServer webServer = webServerMap.values().stream().findFirst().get();
            webServer.start(webApplicationContext);
        }

    }

    private static void startTomcat(AnnotationConfigWebApplicationContext applicationContext) {
        Tomcat tomcat = new Tomcat();
        Server server = tomcat.getServer();
        Service service = server.findService("Tomcat");

        Connector connector = new Connector();
        connector.setPort(8080);

        Engine engine = new StandardEngine();
        engine.setDefaultHost("localhost");

        Host host = new StandardHost();
        host.setName("localhost");
        String contextPath = "";
        Context context = new StandardContext();
        context.setPath(contextPath);
        context.addLifecycleListener(new Tomcat.FixContextListener());

        host.addChild(context);
        engine.addChild(host);

        service.setContainer(engine);
        service.addConnector(connector);

        tomcat.addServlet(contextPath, "dispatcher", new
                DispatcherServlet(applicationContext));

        context.addServletMappingDecoded("/*", "dispatcher");

        try {
            tomcat.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }

}
