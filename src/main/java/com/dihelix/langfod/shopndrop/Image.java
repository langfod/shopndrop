package com.dihelix.langfod.shopndrop;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Image {

	@Id
	@GeneratedValue
	private Long id;
	private String caption;
	private String name;
	private String url;
	private String urlThumb;

	String getUrlThumb() {
		return urlThumb;
	}
	void setUrlThumb(String urlThumb) {
		this.urlThumb = urlThumb;
	}
	Image(){}
	public Image(String url) {
		this.url = url;
	}
	public Image(String name, String url, String caption) {
		this.name = name;
		this.url = url;
		this.caption = caption;
	}
	
	public Image(String name, String url, String caption, String urlThumb) {
		this.name = name;
		this.url = url;
		this.caption = caption;
		this.urlThumb = urlThumb;

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
