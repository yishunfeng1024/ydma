package cn.ysf.ydma;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author YiShunFeng
 * @version 1.0
 * @description cn.ysf.ydma
 * @data 2020/4/29
 */
@SpringBootApplication
@MapperScan(basePackages = "cn/ysf/ydma/dao")
public class RunBoot {
    public static void main(String[] args) {
        SpringApplication.run(RunBoot.class,args);

    }
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
