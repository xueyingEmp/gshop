package com.example.gshop.controller;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class CategoryController {
    @GetMapping("/list")
    public Record list(){
        Record r = Db.findFirst("select * from product_category");
        return r;
    }

    @RequestMapping("/add")
    @Transactional
    public void add(){
        Db.update("insert into product_category(category_name,category_type) values('热洗',8)");
        int a = 1/0;
    }
}
