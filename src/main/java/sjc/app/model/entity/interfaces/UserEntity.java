package sjc.app.model.entity.interfaces;

import sjc.app.model.entity.*;

import java.util.Date;
import java.util.List;

/**
 * Created by psycl on 09.08.2016.
 */
public interface UserEntity {
    String getPassword();

    void setPassword(String password);

    String getLogin();

    void setLogin(String login);

    List<RoleEntityImpl> getAuthorities();

    void setAuthorities(List<RoleEntityImpl> authorities);

    List<UserEntityImpl> getFriends();

    void setFriends(List<UserEntityImpl> friends);

    List<GroupEntityImpl> getGroups();

    void setGroups(List<GroupEntityImpl> groups);

    List<PostUserEntityImpl> getPosts();

    void setPosts(List<PostUserEntityImpl> posts);


    List<UserEntityImpl> getBlackListUsers();

    void setBlackListUsers(List<UserEntityImpl> blackListUsers);

    int getEnabled();

    void setEnabled(int enabled);

    String getName();

    void setName(String name);

    String getLastName();

    void setLastName(String lastName);

    String getSex();

    void setSex(String sex);

    ImageEntityImpl getAvatar();

    void setAvatar(ImageEntityImpl avatar);

    Date getBirthdate();

    void setBirthdate(Date birthdate);

    void setBirthdateString(String birthdate);

    String getCity();

    void setCity(String city);

    String getAbout();

    void setAbout(String about);

    String getEmail();

    void setEmail(String email);

    String getSkype();

    void setSkype(String skype);

    int getMobile();

    String getMobileString();

    void setMobile(int mobile);

    List<MusicEntityImpl> getMusics();

    void setMusics(List<MusicEntityImpl> musics);

    List<VideoEntityImpl> getVideos();

    void setVideos(List<VideoEntityImpl> videos);

    List<ImageEntityImpl> getImages();

    void setImages(List<ImageEntityImpl> images);
}
