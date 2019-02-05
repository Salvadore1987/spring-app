package uz.salvadore.spring.app.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

// Класс для настройки соединения с БД.
@EnableTransactionManagement
@Configuration
@PropertySource("classpath:application.properties")
public class JdbcConfigurer {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.driver-class-name}")
    private String driver;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.hikari.connection-timeout}")
    private String connectionTimeout;

    @Value("${spring.datasource.hikari.minimum-idle}")
    private String minimumIdle;

    @Value("${spring.datasource.hikari.maximum-pool-size}")
    private String maximumPool;

    @Value("${spring.datasource.hikari.idle-timeout}")
    private String idleTimeout;

    @Value("${spring.datasource.hikari.auto-commit}")
    private String autoCommit;

    @Value("${spring.datasource.type}")
    private String dataSourceType;


    // Бин для настройки dataSource.
    @Bean(value = "dataSource")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setConnectionProperties(getConnectionProperties());
        return dataSource;
    }

    // Метод формирует дополнительные параметры для dataSource.
    private Properties getConnectionProperties() {
        Properties properties = new Properties();
        properties.setProperty("connection-timeout", connectionTimeout);
        properties.setProperty("minimum-idle", minimumIdle);
        properties.setProperty("maximum-pool-size", maximumPool);
        properties.setProperty("idle-timeout", idleTimeout);
        properties.setProperty("auto-commit", autoCommit);
        properties.setProperty("type", dataSourceType);
        return properties;
    }

    @Bean
    public DataSourceTransactionManager txManager() {
        DataSourceTransactionManager manager = new DataSourceTransactionManager();
        manager.setDataSource(dataSource());
        return manager;
    }


}
