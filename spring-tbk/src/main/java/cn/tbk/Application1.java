package cn.tbk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@EnableTransactionManagement
@SpringBootApplication
@ComponentScan("cn.tbk.*")
@MapperScan({"cn.tbk.mapper"})
public class Application1
{

    public static void main(String[] args) {
//        SpringApplication app = new SpringApplication(Application.class);
//        app.addListeners(new ApplicationReadyEventProcessor());
//        app.run(args);
        SpringApplication.run(Application1.class, args);
    }
}
