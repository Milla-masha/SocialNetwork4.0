package sjc.app.service;


import org.springframework.web.multipart.MultipartFile;

public interface UploadfileService
{
    String UploadFile(String name, MultipartFile file, String login);
}
