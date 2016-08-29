/*
package sjc.app.Configuration;


import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;
import java.net.URISyntaxException;

@Configuration
public class DatabaseConfiguration
{

    @Bean(name = "heroku")
    public BasicDataSource dataSource() throws URISyntaxException
    {
        URI dbUri = new URI(System.getenv("CLEARDB_DATABASE_URL"));
        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];

        String dbUrl = "jdbc:mysql://" + dbUri.getHost() + dbUri.getPath();

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.addConnectionProperty("serverTimezone", "America/Los_Angeles");
        basicDataSource.addConnectionProperty("testWhileIdle", "true");
        basicDataSource.addConnectionProperty("timeBetweenEvictionRunsMillis", "60000");
        //basicDataSource.addConnectionProperty("validationQuery ","SELECT 1");
        basicDataSource.addConnectionProperty("maxActive", "10");
        basicDataSource.addConnectionProperty("maxIdle", "5");
        basicDataSource.addConnectionProperty("minIdle", "2");
        basicDataSource.addConnectionProperty("initialSize", "5");
        basicDataSource.addConnectionProperty("removeAbandoned", "true");


        basicDataSource.setUrl(dbUrl);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);


        return basicDataSource;
    }
}
*/
