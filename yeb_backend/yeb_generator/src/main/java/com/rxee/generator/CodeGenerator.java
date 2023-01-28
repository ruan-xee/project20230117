package com.rxee.generator;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;
import java.util.Scanner;

public class CodeGenerator {
    public static String scanner(String tip){
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + ":");
        System.out.println(help.toString());
        if (scanner.hasNext()){
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)){
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "!");
    }

    /*
    public static void main(String[] args) {
        //数据源配置
        DataSourceConfig dsc = new DataSourceConfig.Builder(
                "jdbc:mysql://localhost:3306/test20230117?serverTimezone=GMT%2b8",
                "root",
                "123456")
                .build();

        //dsc.setDriverName("com.mysql.cj.jdbc.Driver");


        AutoGenerator mpg = new AutoGenerator(dsc);

        //全局配置
        String projectPath = System.getProperty("user.dir");
        GlobalConfig gc = new GlobalConfig.Builder()
                .outputDir(projectPath + "/yeb_generator/src/main/java")
                .author("rxee")
                .enableSwagger()
                .disableOpenDir()
                .build();
        //gc.setBaseResultMap(true);
        //gc.setBaseColumnList(true);
        mpg.global(gc);


        //包配置
        PackageConfig pc = new PackageConfig.Builder()
                .parent("com.rxee")
                .controller("controller")
                .service("service")
                .entity("entity")
                .mapper("mapper")
                .serviceImpl("service.impl")
                .build();
        mpg.packageInfo(pc);


        //
        String templatePath = "/templates/mapper.xml.ftl";


    }

     */


    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/test20221123?serverTimezone=GMT%2b8",
                        "root",
                        "123456")
                .globalConfig(builder -> {
                    builder.author("rxee") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .disableOpenDir()
                            .outputDir(System.getProperty("user.dir") + "/yeb_backend/yeb_generator/src/main/java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.rxee") // 设置父包名
                            .controller("controller")
                            .service("service")
                            .entity("entity")
                            .mapper("mapper")
                            .serviceImpl("service.impl")
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, System.getProperty("user.dir") + "/yeb_backend/yeb_generator/src/main/resources/mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.enableCapitalMode()
                            .addInclude("sys_user") // 设置需要生成的表名
                            .addTablePrefix("sys_") // 设置过滤表前缀
                            .entityBuilder().enableLombok();
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
