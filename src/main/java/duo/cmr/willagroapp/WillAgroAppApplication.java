package duo.cmr.willagroapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class WillAgroAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(WillAgroAppApplication.class, args);
    }

}
