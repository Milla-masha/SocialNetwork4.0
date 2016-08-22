package sjc.app.Firebase;

import com.google.gson.Gson;
import org.apache.cxf.jaxrs.client.WebClient;
import sjc.app.model.vo.PostSmallVO;

import javax.ws.rs.core.MediaType;

public class PushPosts
{
    public static void push(PostSmallVO postSmallVO)
    {
        WebClient client = WebClient.create("https://fcm.googleapis.com/fcm/send")
                .accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON);
        client.header("Authorization", "key=AIzaSyBuV8kUN2UMbIaZ20NbXGfn58-FPyB6h1I");
        Request request=new Request();
        request.setData(postSmallVO);
        request.setTo("fZV7bA7x9lE:APA91bFSxN0qBekZfQ-8_bhOEQnA1oQcyUg93wJHT9MRPqCcDboMG9REk9XwZxNK3gBe_RQkrT3bdM0cx-gYDEnf7rU9qnA2k3ns4zpOZ4Dk0eVOtcKOSfUCeGlMVPH-iJ2LSC0Sck1j");
        Gson gson = new Gson();
        String jsonInString = gson.toJson(request);
        client.post(jsonInString);
    }
}

