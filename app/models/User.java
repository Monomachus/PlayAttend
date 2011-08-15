package models;

import javax.persistence.Column;
import javax.persistence.Entity;

import play.db.jpa.Model;
import play.libs.Codec;

@Entity
public class User extends Model {

	@Column(unique = true)
	public String name;
	public String passwordHash;
	public int roleId;

	public User(String username, String password, RoleEnum role) {
		this.name = username;
		this.passwordHash = Codec.hexMD5(password);
		this.roleId = role.ordinal();
	}

	public User(String username, String password) {
		this.name = username;
		this.passwordHash = Codec.hexMD5(password);
		this.roleId = RoleEnum.User.ordinal();
	}
}
