package io.pivotal.demo.config;

import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("cloud")
@Configuration
public class CloudDataSourceConfig extends AbstractCloudConfig {
    @Bean
    public javax.sql.DataSource dataSource() {
        return connectionFactory().dataSource();
    }
}