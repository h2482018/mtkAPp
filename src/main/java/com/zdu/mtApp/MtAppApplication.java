package com.zdu.mtApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableRedisHttpSession(redisNamespace = "MY_SESSION")
public class MtAppApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(MtAppApplication.class, args);
    }
}
