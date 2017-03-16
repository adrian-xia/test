package spring.test.sa.chapter03.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;


/**
 * Created by xialei on 2017/3/15.
 */
@Configuration
public class DataSourceConfig {

    @Bean
    @Profile("dev")
    public DataSource embeddedDataSource(){
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:sa/chapter03/build.sql")
                .addScript("classpath:sa/chapter03/testdata.sql")
                .build();
    }

}
