package sjc.app.Configuration;


import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.cloud.config.java.ServiceScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

/**
 * Created by psycl on 19.08.2016.
 *
 * ЧТОБЫ ЗАПУСТИТЬ СЕРВЕР ЛОКАЛЬНО
 * НУЖНО ЗАКОМЕНТИТЬ ВЕСЬ ЭТОТ КЛАСС
 *
 */
@Profile("cloud")
@ServiceScan
@Configuration
public class CloudConfiguration extends AbstractCloudConfig
{
    @Bean
    public DataSource dataSource() {
        return connectionFactory().dataSource();
    }

}
