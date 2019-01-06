package com.example.gshop;

import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.template.source.ClassPathSourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;


@Configuration
public class JDbConfig {
    @Autowired
    // 等待db1Source启动后注入
    private DataSource ds;

    /**
     * 注入
     * @return JDb (JDb enxtends Db)
     * @throws Exception
     */
    @Bean
    @Primary
    public JDb jdb() throws Exception {
        ActiveRecordPlugin arp = new ActiveRecordPlugin(ds);
        arp.getEngine().setSourceFactory(new ClassPathSourceFactory());
        // 启动Record容器
        arp.start();
        System.out.println("===Jfinal - Db启动成功===");
        // Db初始化
        JDb db = new JDb();
        return db;
    }
}
