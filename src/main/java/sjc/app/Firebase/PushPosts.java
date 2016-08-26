package sjc.app.firebase;

import com.google.gson.Gson;
import org.apache.cxf.jaxrs.client.WebClient;
import sjc.app.constant.Constant;
import sjc.app.model.vo.PostNotificationVO;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class PushPosts
{
    public static void push(PostNotificationVO postNotificationVO, String token)
    {
        WebClient client = WebClient.create(Constant.URL_FOR_NOTIFICATION)
                .accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON);
        client.header(Constant.AUTHORIZATION, Constant.KEY_FOR_NOTIFICATION);
        Request request=new Request();
        request.setBody(postNotificationVO.getText());
        request.setTo(token);
        Gson gson = new Gson();
        String jsonInString = gson.toJson(request);
        Response response= client.post(jsonInString);
        String s;
}
}

