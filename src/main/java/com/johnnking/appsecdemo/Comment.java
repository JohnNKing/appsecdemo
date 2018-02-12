package com.johnnking.appsecdemo;

public class Comment {

	private String comment;
	private String username = "";

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

		if (username != null) {
			this.username = username;
		}
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