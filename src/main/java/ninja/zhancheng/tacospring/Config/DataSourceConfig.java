package ninja.zhancheng.tacospring.Config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

//    @Bean
//    public DataSource getDataSource() {
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
//        dataSourceBuilder.url("jdbc:mysql://localhost:3306/springtaco?serverTimezone=UTC");
//        dataSourceBuilder.username("server");
//        dataSourceBuilder.password("diet4coke");
//
//        return dataSourceBuilder.build();
//    }
}
