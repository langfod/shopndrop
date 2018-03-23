package com.dihelix.langfod.shopndrop;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Spec implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4760143664696139550L;

	@Id
	@GeneratedValue
	private Long id;

	private String content;
	private String title;

	public Spec() {
	}
	public Spec(String title, String content) {
		this.title = title;
		this.content = content;
	}

	String getContent() {
		return content;
	}

	Long getId() {
		return id;
	}

	String getTitle() {
		return title;
	}

	void setContent(String content) {
		this.content = content;
	}

	void setTitle(String title) {
		this.title = title;
	}

}
