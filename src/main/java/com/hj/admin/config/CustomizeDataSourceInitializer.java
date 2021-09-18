package com.hj.admin.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;

//执行  初始化 数据库脚本
/*
*        initSql: true
*        sqlPath: sql
*/
@Configuration
@ConditionalOnProperty(name = "initSql",havingValue = "true")
public class CustomizeDataSourceInitializer implements InitializingBean {

    @Value("${sqlPath}")
    private String  path;

    @Bean
    public DataSourceInitializer dataSourceInitializer(final DataSource dataSource) {
        final DataSourceInitializer initializer = new DataSourceInitializer();
        // 设置数据源
        initializer.setDataSource(dataSource);
        initializer.setDatabasePopulator(databasePopulator());
        return initializer;
    }

    private DatabasePopulator databasePopulator() {

        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        ClassPathResource classPathResource = new ClassPathResource(path);


        try {

            File file = classPathResource.getFile();

            excutesql(file,classPathResource,populator);

        } catch (IOException e) {
           e.printStackTrace();
        }

        return populator;
    }

    private void excutesql(File file,ClassPathResource classPathResource,ResourceDatabasePopulator populator)
    {
        if (file.isDirectory())
        {
            File[] files = file.listFiles();
            for (File file1 : files) {
                excutesql(file1,classPathResource,populator);
            }

        }
        else {
                if (!file.isDirectory()) {
                    String filename =file.getAbsolutePath(); //classPathResource.getPath() + "/" + file.getName();


                    String[] split = filename.split("classes");



                    filename =split[1].substring(1,split[1].length());


                    Resource resource = new ClassPathResource(filename);

                    System.out.println("==================" + filename + "脚本正在执行==================");


                    populator.addScripts(resource);


                    System.out.println("==================" + filename + "脚本初始化完成==================");
                }else {
                    excutesql(file,classPathResource,populator);
                }


        }

    }


    @Override
    public void afterPropertiesSet() throws Exception {

    }
}