package sjc.app.model.vo;

import java.util.List;

public class UserVO {

    private long id;
    private String password;
    private String login;
    private List<UserVO> friends;

      public UserVO() {
    }

    public UserVO(long id, String password, String login) {
        this.id=id;
        this.password = password;
        this.login = login;
        this.friends=null;
        }

    public UserVO(long id, String password, String login, List<UserVO> friends) {
        this.id=id;
        this.password = password;
        this.login = login;
        this.friends=friends;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<UserVO> getFriends() {
        return friends;
    }

    public void setFriends(List<UserVO> friends) {
        this.friends = friends;
    }

}
