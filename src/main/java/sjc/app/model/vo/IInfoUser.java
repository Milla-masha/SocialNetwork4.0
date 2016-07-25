package sjc.app.model.vo;

import sjc.app.model.vo.impl.ContactUserVO;

import java.util.Date;

public interface IInfoUser
{
    String getName();

    void setName(String name);

    String getLastName();

    void setLastName(String lastName);

    Date getBirthday();

    void setBirthday(Date birthday);

    String getAvatar();

    void setAvatar(String avatar);

    String getCity();

    void setCity(String city);

    String getAbout();

    void setAbout(String about);

    ContactUserVO getContactUser();

    void setContactUser(ContactUserVO contactUser);
}
