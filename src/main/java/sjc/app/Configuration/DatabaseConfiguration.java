/*
package sjc.app.Configuration;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.TimeZone;
@Configuration
public class DatabaseConfiguration {

 @Bean(name = "heroku")
 public BasicDataSource dataSource() throws URISyntaxException
 {
       URI dbUri = new URI(System.getenv("CLEARDB_DATABASE_URL"));
       TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
       String username = dbUri.getUserInfo().split(":")[0];
       String password = dbUri.getUserInfo().split(":")[1];

       String dbUrl = "jdbc:mysql://" + dbUri.getHost() + dbUri.getPath();

       BasicDataSource basicDataSource = new BasicDataSource();
       basicDataSource.addConnectionProperty("serverTimezone","America/Los_Angeles");
       basicDataSource.addConnectionProperty("testWhileIdle" , "true");
       basicDataSource.addConnectionProperty("timeBetweenEvictionRunsMillis","60000");
       //hebasicDataSource.addConnectionProperty("validationQuery ","SELECT 1");
       basicDataSource.setUrl(dbUrl);
       basicDataSource.setUsername(username);
       basicDataSource.setPassword(password);

       return basicDataSource;
 }
}
*/
