package sjc.app.model.entity;

import sjc.app.model.entity.impl.UserEntityImpl;

/**
 * Created by psycl on 29.07.2016.
 */
public interface VideoEntity {
    public String getName();

    public void setName(String name);

    public String getUrl();

    public void setUrl(String url);

    public String getPreview();

    public void setPreview(String preview);

    public UserEntityImpl getFkUser();

    public void setFkUser(UserEntityImpl fkUser);

}
