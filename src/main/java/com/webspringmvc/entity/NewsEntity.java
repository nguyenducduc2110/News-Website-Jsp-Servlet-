package com.webspringmvc.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "news")
@Table(name="news")
public class NewsEntity extends BaseEntity{
	@Column
	private String title;
	@Column
	private String thumbnail;
	@Column(name="shortdescription", columnDefinition= "TEXT")
	private String shortDescription;
	@Column(columnDefinition = "TEXT")
	private String content;
	public NewsEntity() {
		super();
	}
	public NewsEntity(Long id, Timestamp createdDate, Timestamp modifiedDate, String createdBy, String modifiedBy,
			String title, String thumbnail, String shortDescription, String content) {
		super(id, createdDate, modifiedDate, createdBy, modifiedBy);
		this.title = title;
		this.thumbnail = thumbnail;
		this.shortDescription = shortDescription;
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
	