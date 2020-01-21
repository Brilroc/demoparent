package dhcc.com.cn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("dhcc.com.cn.mapper")
public class Demo2Start {

    public static void main(String[] args) {
        SpringApplication.run(Demo2Start.class, args);
    }

}