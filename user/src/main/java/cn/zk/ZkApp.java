package cn.zk;


import cn.zk.springboot.core.ZkSpringApplication;
import cn.zk.springboot.core.nanotation.ZkSpringBootApplication;

@ZkSpringBootApplication
public class ZkApp {

    public static void main(String[] args) {
        ZkSpringApplication.run(ZkApp.class);
    }

}
