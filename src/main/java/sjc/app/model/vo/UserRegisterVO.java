package sjc.app.model.vo;

public class UserRegisterVO
{
    String name;
    String lastName;
    String login;
    String password;
    String email;
    String sex;
    String bday;

    public UserRegisterVO() {
    }

    public UserRegisterVO(String name, String lastName, String login, String password, String email, String sex, String bday) {
        this.name = name;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.email = email;
        this.sex = sex;
        this.bday = bday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBday() {
        return bday;
    }

    public void setBday(String bday) {
        this.bday = bday;
    }
}
