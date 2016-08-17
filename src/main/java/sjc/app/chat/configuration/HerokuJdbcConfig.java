/*
package sjc.app.chat.configuration;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;
import java.net.URISyntaxException;

*/
/**
 * Created by psycl on 16.08.2016.
 *//*


@Configuration
public class HerokuJdbcConfig
{

    @Bean
    public BasicDataSource dataSource() throws URISyntaxException
    {
        URI dbUri = new URI(System.getenv("mysql://be745b3c0c2e9e:382ad6c7@us-cdbr-iron-east-04.cleardb.net/heroku_b918673307eb9ec?reconnect=true"));

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:mysql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(dbUrl);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        return basicDataSource;
    }
}
*/
