package sjc.app.model.vo.impl;

import sjc.app.model.vo.IContactUser;

public class ContactUserVO implements IContactUser {

    private String mobile;

    private String skype;

    private String email;

    public ContactUserVO() {
    }

    public ContactUserVO(String mobile, String skype, String email) {
        this.mobile = mobile;
        this.skype = skype;

        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
