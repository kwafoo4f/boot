package cn.zk.springboot.web;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

/**
 * web服务器
 */
public interface WebServer {

    void start(AnnotationConfigWebApplicationContext applicationContext);

}
