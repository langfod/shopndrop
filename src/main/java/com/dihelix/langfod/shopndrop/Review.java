package com.dihelix.langfod.shopndrop;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Review {


	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String content;
	private LocalDateTime postDate;
	private String userName;


	public Review() {}
	
	public Review(String title, String content, String userName) {
		this.title = title;
		this.content = content;
		this.userName = userName;
		this.postDate = LocalDateTime.now();
	}


	Long getId() {
		return id;
	}


	String getCommentTitle() {
		return title;
	}


	String getCommentContent() {
		return content;
	}


	LocalDateTime getCommentDate() {
		return postDate;
	}


	String getUserName() {
		return userName;
	}
}
