package cn.bdqn.itrip;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "cn.bdqn.itrip.dao")
public class ItripApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItripApplication.class, args);
    }

}
