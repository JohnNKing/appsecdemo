package com.johnnking.appsecdemo;

public class User {

	private String name;
	private String password;
	private String favoriteColor = "unknown";

	public User(String name) {
		this.name = name;
		this.password = name;
	}
	
	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public User(String name, String password, String favoriteColor) {
		this.name = name;
		this.password = password;
		this.favoriteColor = favoriteColor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFavoriteColor() {
		return favoriteColor;
	}

	public void setFavoriteColor(String favoriteColor) {
		this.favoriteColor = favoriteColor;
	}
}