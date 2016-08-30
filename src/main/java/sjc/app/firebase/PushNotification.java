package sjc.app.firebase;

import com.google.gson.Gson;
import org.apache.cxf.jaxrs.client.WebClient;
import sjc.app.constant.Constant;

import javax.ws.rs.core.MediaType;

public class PushNotification
{
    public static void push(Object body ,String title, String token)
    {
        WebClient client = WebClient.create(Constant.URL_FOR_NOTIFICATION)
                .accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON);
        client.header(Constant.AUTHORIZATION, Constant.KEY_FOR_NOTIFICATION);
        Request request = new Request();
        request.setBody(body);
        request.setTitle(title);
        request.setTo(token);
        Gson gson = new Gson();
        String jsonInString = gson.toJson(request);
        client.post(jsonInString);
    }
}

