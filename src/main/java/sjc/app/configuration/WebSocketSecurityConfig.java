package sjc.app.configuration;

import org.springframework.security.config.annotation.web.messaging.MessageSecurityMetadataSourceRegistry;
import org.springframework.security.config.annotation.web.socket.AbstractSecurityWebSocketMessageBrokerConfigurer;

/**
 * Created by psycl on 08.08.2016.
 */
public class WebSocketSecurityConfig extends
        AbstractSecurityWebSocketMessageBrokerConfigurer {
    protected void configureInbound(MessageSecurityMetadataSourceRegistry messages) {
        messages
                . simpDestMatchers("/user/queue/errors").permitAll()
                . simpDestMatchers("/**").hasRole("ROLE_CLIENT");
    }
}