package sjc.app.service.impl;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;
import com.dropbox.core.v2.sharing.SharedLinkMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import sjc.app.model.entity.ImageEntityImpl;
import sjc.app.model.entity.MusicEntityImpl;
import sjc.app.repository.dao.ImageDao;
import sjc.app.repository.dao.MusicDao;
import sjc.app.repository.dao.VideoDao;
import sjc.app.service.UploadfileService;

import java.io.InputStream;

@Scope(proxyMode = ScopedProxyMode.INTERFACES)
@Transactional
@Service
public class UploadFileServiceImpl implements UploadfileService
{

    @Autowired
    private MusicDao musicDao;
    @Autowired
    private VideoDao videoDao;
    @Autowired
    private ImageDao imageDao;

    private static final String ACCESS_TOKEN = "KF3sKUHJzGwAAAAAAAAFdmW6xalOLAW1tfL-4m8gZlAvofyLSsBnyTDoXBNU7U7B";
    private static final String CLIENT_IDENTIFIER = "dropbox/java-tutorial";
    private static final String USER_LOKALE = "en_US";
    DbxClientV2 client;

    @Override
    public Long UploadFile(String name, MultipartFile file)
    {
        DbxRequestConfig config = new DbxRequestConfig(CLIENT_IDENTIFIER, USER_LOKALE);
        client = new DbxClientV2(config, ACCESS_TOKEN);
        if (!file.isEmpty())
        {
            try
            {
                // Upload to dropbox
                try (InputStream in = file.getInputStream())
                {
                    FileMetadata metadata = client.files().uploadBuilder("/" + file.getOriginalFilename())
                            .uploadAndFinish(in);
                    SharedLinkMetadata sharedLinkMetadata = client.sharing().createSharedLinkWithSettings(metadata.getPathDisplay());
                    if (file.getContentType().contains("image"))
                    {
                        ImageEntityImpl image = new ImageEntityImpl();
                        image.setUrl(sharedLinkMetadata.getUrl());
                        return imageDao.save(image).getId();
                    } else if (file.getContentType().contains("audio"))
                    {
                        MusicEntityImpl music = new MusicEntityImpl();
                        music.setUrl(sharedLinkMetadata.getUrl());
                        return musicDao.save(music).getId();
                    } else
                    {
                        return null;
                    }
                }
            } catch (Exception e)
            {
                System.out.print("You failed to upload " + name + " => " + e.getMessage());
                return null;
            }
        } else
        {
            System.out.print("You failed to upload " + name + " because the file was empty.");
            return null;
        }
    }

    public void getListFolders() throws DbxException
    {
        ListFolderResult result = client.files().listFolder("");
        while (true)
        {
            for (Metadata metadata : result.getEntries())
            {
                System.out.println(metadata.getPathLower());
            }
            if (!result.getHasMore())
            {
                break;
            }
            result = client.files().listFolderContinue(result.getCursor());
        }
    }

}
