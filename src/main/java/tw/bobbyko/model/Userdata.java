package tw.bobbyko.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERDATA")
public class Userdata {
	@Id 
	@Column(name = "USERID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userid;
	@Column(name = "USER_ACC")
	private String user_acc;
	@Column(name = "USER_PWD")
	private String user_pwd;
	@Column(name = "USERNAME")
	private String username;
	@Column(name = "USER_PHONE")
	private String user_phone;
	@Column(name = "BIRTHDAY")
	private String birthday;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "AUTHCODE")
	private String authcode;
	
	
	
	public Userdata() {
		}
	
	public Userdata(String user_acc, String user_pwd) {
		this.user_acc = user_acc;
		this.user_pwd = user_pwd;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUser_acc() {
		return user_acc;
	}

	public void setUser_acc(String user_acc) {
		this.user_acc = user_acc;
	}

	public String getUser_pwd() {
		return user_pwd;
	}

	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAuthcode() {
		return authcode;
	}

	public void setAutocode(String authcode) {
		this.authcode = authcode;
	}

}
