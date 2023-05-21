package ru.teachbase.go.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import ru.teachbase.go.UserServiceApplication;

import javax.sql.DataSource;

@Configuration
@Import({UserServiceApplication.class})
@Profile("test-contracts")
public class UserServiceTestContractConfig {
    @Bean
    public DataSourceInitializer testDataBaseInitializer(DataSource dataSource) {
        DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
        dataSourceInitializer.setDataSource(dataSource);
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();

        databasePopulator.addScript(new ClassPathResource("schema/UserEntity.sql"));
        databasePopulator.addScript(new ClassPathResource("schema/AccountEntity.sql"));

        databasePopulator.addScript(new ClassPathResource("data/User.sql"));
        databasePopulator.addScript(new ClassPathResource("data/Account.sql"));
        dataSourceInitializer.setDatabasePopulator(databasePopulator);

        return dataSourceInitializer;
    }
}
