package sjc.app.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class UserEntity extends AbstractPersistable {

	private String password;
	private String login;
	@OneToOne(mappedBy = "user")
	private InfoUser infoUser;

	@OneToOne(mappedBy = "userEntity")
	private ContactUser contactUser;

	public ContactUser getContactUser() {
		return contactUser;
	}

	public void setContactUser(ContactUser contactUser) {
		this.contactUser = contactUser;
	}

	public InfoUser getInfoUser() {
		return infoUser;
	}

	public void setInfoUser(InfoUser infoUser) {
		this.infoUser = infoUser;
	}

	@ManyToMany( fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "friends",  joinColumns = {
			@JoinColumn(name = "fk_user1", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "fk_user2",
					nullable = false, updatable = false) })
	private List<UserEntity> friends;

	@OneToMany( mappedBy = "idU", fetch = FetchType.LAZY)
	private List<Authorities> authorities;

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "login")
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public List<Authorities> getAuthorities() {
		return authorities;
	}

	public UserEntity() {
	}

	public void setAuthorities(List<Authorities> authorities) {
		this.authorities = authorities;
	}

	public List<UserEntity> getFriends() {
		return friends;
	}

	public void setFriends(List<UserEntity> friends) {
		this.friends = friends;
	}

}
