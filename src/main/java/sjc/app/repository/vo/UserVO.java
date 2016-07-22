package sjc.app.repository.vo;

import java.util.List;

public class UserVO {

    private Long id;
    private String password;
    private String login;

    public List<UserVO> getFriends() {
        return friends;
    }

    public void setFriends(List<UserVO> friends) {
        this.friends = friends;
    }

    private List<UserVO> friends;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public UserVO() {
    }

    public UserVO(Long id, String password, String login) {
        this.id=id;
        this.password = password;
        this.login = login;
        this.friends=null;
        }

    public UserVO(Long id, String password, String login, List<UserVO> friends) {
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

}
