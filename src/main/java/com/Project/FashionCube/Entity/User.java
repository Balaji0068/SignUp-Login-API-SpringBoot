package com.Project.FashionCube.Entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="userdata")
public class User {
   @Id
   @GeneratedValue(strategy =GenerationType.IDENTITY)
   @Column(name="user_id")
	private long userId;
   @Column(name="user_name",nullable=false)
	private String userName;
   @Column (name="email",unique=true ,nullable=false)
	private String email;
   @Column(name="password",unique=true ,nullable=false)
	private String password;
public long getUserId() {
	return userId;
}
public void setUserId(long userId) {
	this.userId = userId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public int hashCode() {
	return Objects.hash(email, password, userId, userName);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	User other = (User) obj;
	return Objects.equals(email, other.email) && Objects.equals(password, other.password) && userId == other.userId
			&& Objects.equals(userName, other.userName);
}
@Override
public String toString() {
	return "User [userId=" + userId + ", userName=" + userName + ", email=" + email + ", password=" + password + "]";
}
   
   
}
