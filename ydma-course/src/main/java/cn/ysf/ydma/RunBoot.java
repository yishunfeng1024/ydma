package cn.ysf.ydma;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.client.RestTemplate;

/**
 * @author YiShunFeng
 * @version 1.0
 * @description cn.ysf.ydma
 * @data 2020/4/26
 */
@SpringBootApplication
@MapperScan(basePackages = "cn.ysf.ydma.dao")
@EnableCaching//开启cache注解标记
@ServletComponentScan
public class RunBoot {
    public static void main(String[] args) {
        SpringApplication.run(RunBoot.class,args);
    }

    @Bean
    public RedisTemplate<Object,Object> redisTemplate(RedisConnectionFactory connectionFactory){
        RedisTemplate<Object,Object> redis = new RedisTemplate<Object, Object>();
        //构建String序列化
        redis.setKeySerializer(new StringRedisSerializer());
        redis.setConnectionFactory(connectionFactory);
        return redis;
    }
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
