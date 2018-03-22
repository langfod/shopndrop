package com.dihelix.langfod.shopndrop;

public class Spec {

	private String content;
	private Long id;
	private String title;

	Spec() {
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
