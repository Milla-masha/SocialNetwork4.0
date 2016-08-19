package sjc.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.stereotype.Service;
import sjc.app.constant.Constant;

import java.util.Date;

@Service
public class OnlineUser
{
    @Autowired
    private InMemoryTokenStore tokenStore;

    public boolean isOnline(String login)
    {
        Date date = new Date();
        if (tokenStore.findTokensByClientIdAndUserName(Constant.CLIENT_ID, login) != null)
        {
            if (tokenStore.findTokensByClientIdAndUserName(Constant.CLIENT_ID, login).size() > 0)
            {
                OAuth2AccessToken token = tokenStore.findTokensByClientIdAndUserName(Constant.CLIENT_ID, login).iterator().next();
                if (date.getTime() - token.getExpiration().getTime() < 300)
                {
                    return true;
                }
            }
        }
        return false;
    }
}
