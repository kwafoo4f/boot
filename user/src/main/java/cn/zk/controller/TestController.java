package cn.zk.controller;

import cn.zk.bean.Mybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private Mybatis mybatis;


    @GetMapping
    public String getTest() {
        return mybatis.seyMybatis();
    }


}
