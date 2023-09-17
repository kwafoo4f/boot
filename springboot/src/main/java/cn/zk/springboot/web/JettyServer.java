package cn.zk.springboot.web;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class JettyServer implements WebServer {
    @Override
    public void start(AnnotationConfigWebApplicationContext applicationContext) {
        System.out.println("JettyServer start");
    }
}
