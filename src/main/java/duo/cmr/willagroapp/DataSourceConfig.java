package duo.cmr.willagroapp;

import duo.cmr.willagroapp.persistence.db.person.PersonDAO;
import duo.cmr.willagroapp.persistence.db.person.PersonDTO;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Optional;

@Configuration
public class DataSourceConfig {
    /*@Bean
    public DataSource datasource() {
        return DataSourceBuilder.create()
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .url("jdbc:mysql://localhost:3322/willagroapp")
                .username("root")
                .password("iamgroot")
                .build();
    }*/
}
