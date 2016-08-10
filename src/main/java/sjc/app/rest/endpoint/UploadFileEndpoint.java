package sjc.app.rest.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sjc.app.rest.response.PaginationResponseOk;
import sjc.app.rest.response.ResponseOk;
import sjc.app.rest.response.impl.PaginationResponseImpl;
import sjc.app.rest.response.impl.ResponseImpl;
import sjc.app.service.UploadfileService;


@Controller
@RequestMapping("/files")
public class UploadFileEndpoint
{
    @Autowired
    UploadfileService uploadfile;
    private PaginationResponseOk paginationResponse=new PaginationResponseImpl();
    private ResponseOk response=new ResponseImpl();

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseOk uploadFileHandler(@RequestParam("name") String name, @RequestParam("file") MultipartFile file)
    {
        response.setEntity(uploadfile.UploadFile(name, file));
        return response;
    }


}
