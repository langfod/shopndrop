package com.dihelix.langfod.shopndrop;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Spec {

	@Id
	@GeneratedValue
	private Long id;

	private String content;
	private String title;

	@JsonIgnore
	@OneToMany(mappedBy = "spec")
	Set<Product> products = new HashSet<>();

	public Spec() {
	}

	public Spec(String title, String content) {
		this.title = title;
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	void setContent(String content) {
		this.content = content;
	}

	void setTitle(String title) {
		this.title = title;
	}

}
