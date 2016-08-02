package sjc.app.service.impl;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;
import com.dropbox.core.v2.sharing.SharedLinkMetadata;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sjc.app.service.UploadfileService;

import java.io.InputStream;

//@Scope(proxyMode = ScopedProxyMode.INTERFACES)
//@Transactional
@Service
public class UploadFileServiceImpl implements UploadfileService {
    private static final String ACCESS_TOKEN = "KF3sKUHJzGwAAAAAAAAFdmW6xalOLAW1tfL-4m8gZlAvofyLSsBnyTDoXBNU7U7B";
    DbxClientV2 client;

    @Override
    public String UploadFile(String name, MultipartFile file) {
        DbxRequestConfig config = new DbxRequestConfig("dropbox/java-tutorial", "en_US");
        client = new DbxClientV2(config, ACCESS_TOKEN);
        if (!file.isEmpty()) {
            try {
                // Upload to dropbox
                try (InputStream in = file.getInputStream())
                {
                    FileMetadata metadata = client.files().uploadBuilder("/" + file.getOriginalFilename())
                            .uploadAndFinish(in);
                    SharedLinkMetadata sharedLinkMetadata = client.sharing().createSharedLinkWithSettings(metadata.getPathDisplay());
                    System.out.println(sharedLinkMetadata.getUrl());
                }
                return "You successfully uploaded file=" + name;
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name + " because the file was empty.";
        }
    }

    public void getListFolders() throws DbxException {
        ListFolderResult result = client.files().listFolder("");
        while (true) {
            for (Metadata metadata : result.getEntries()) {
                System.out.println(metadata.getPathLower());
            }
            if (!result.getHasMore()) {
                break;
            }
            result = client.files().listFolderContinue(result.getCursor());
        }
    }
}
