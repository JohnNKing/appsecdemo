package com.johnnking.csrf;

public class Comment {

	private String comment;
	private String username = null;

	public Comment() {
		super();
	}

	public Comment(String comment) {
		super();
		this.comment = comment;
	}
	
	public Comment(String comment, String username) {
		super();
		this.comment = comment;
		this.username = username;
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
		this.username = username;
	}
}