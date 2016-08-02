package sjc.app.rest.impl;

import com.dropbox.core.*;
import com.dropbox.core.v1.DbxEntry;
import com.dropbox.core.v1.DbxWriteMode;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;
import com.dropbox.core.v2.sharing.FileLinkMetadata;
import com.dropbox.core.v2.sharing.SharedLinkMetadata;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sjc.app.service.UploadfileService;

import javax.ws.rs.core.Response;
import java.io.*;
import java.util.Locale;


@Controller
@RequestMapping("/files")
public class UploadFileEndpoint
{
    UploadfileService uploadfile;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Response uploadFileHandler(@RequestParam("name") String name, @RequestParam("file") MultipartFile file)
    {
    return Response.ok(uploadfile.UploadFile(name, file)).build();
    }


}
