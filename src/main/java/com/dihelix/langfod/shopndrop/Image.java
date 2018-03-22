package com.dihelix.langfod.shopndrop;

public class Image {

	private String caption;
	private Long id;
	private String name;
	private String url;
	Image(){}
	public Image(String url) {
		this.url = url;
	}
	public Image(String name, String url, String caption) {
		this.name = name;
		this.url = url;
		this.caption = caption;
	}
	String getCaption() {
		return caption;
	}
	Long getId() {
		return id;
	}
	String getName() {
		return name;
	}
	String getUrl() {
		return url;
	}
	void setCaption(String caption) {
		this.caption = caption;
	}
	void setName(String name) {
		this.name = name;
	}
	void setUrl(String url) {
		this.url = url;
	}
}
