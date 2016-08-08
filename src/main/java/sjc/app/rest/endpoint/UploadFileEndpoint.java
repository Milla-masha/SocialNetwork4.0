package sjc.app.rest.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sjc.app.service.UploadfileService;

import javax.ws.rs.core.Response;


@Controller
@RequestMapping("/files")
public class UploadFileEndpoint
{
    @Autowired
    UploadfileService uploadfile;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Response uploadFileHandler(@RequestParam("name") String name, @RequestParam("file") MultipartFile file)
    {
        return Response.ok(uploadfile.UploadFile(name, file)).build();
    }


}
