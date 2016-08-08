package sjc.app.service;


import org.springframework.web.multipart.MultipartFile;

public interface UploadfileService
{
    Long UploadFile(String name, MultipartFile file);
}
