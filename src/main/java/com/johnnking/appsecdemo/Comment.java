package com.johnnking.appsecdemo;

public class Comment {

	private int id = -1;
	private String comment;
	private String username = "";

	public Comment() {
		super();
	}

	public Comment(int id, String comment) {
		super();
		this.id = id;
		this.comment = comment;
	}
	
	public Comment(int id, String comment, String username) {
		super();
		this.id = id;
		this.comment = comment;

		if (username != null) {
			this.username = username;
		}
	}
	public Comment(String comment) {
		super();
		this.comment = comment;
	}
	
	public Comment(String comment, String username) {
		super();
		this.comment = comment;

		if (username != null) {
			this.username = username;
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		if (username != null) {
			this.username = username;
		} else {
			username = "";
		}
	}
}