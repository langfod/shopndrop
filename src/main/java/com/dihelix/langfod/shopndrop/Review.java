package com.dihelix.langfod.shopndrop;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

//@Entity
public class Review {

	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String content;
	private LocalDateTime postDate;
	private String userName;
	@JsonIgnore
	@ManyToMany(mappedBy="reviews") Set<Product> products = new HashSet<>();

	public Review() {
	}

	public Review(String title, String content, String userName) {
		this.title = title;
		this.content = content;
		this.userName = userName;
		this.postDate = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public String getCommentTitle() {
		return title;
	}

	public String getCommentContent() {
		return content;
	}

	public LocalDateTime getCommentDate() {
		return postDate;
	}

	public String getUserName() {
		return userName;
	}
}
