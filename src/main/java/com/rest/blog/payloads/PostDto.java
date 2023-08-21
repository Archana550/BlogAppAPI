package com.rest.blog.payloads;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.hateoas.RepresentationModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto extends RepresentationModel<PostDto>{

	private Integer postId;
	@NotNull(message="Title can't be empty.")
	@NotBlank(message="Title is mandatory.")
	@Size(min=4, message="Title must be 4 characters long.")
	private String title;
	@NotNull(message="Content can't be empty.")
	@NotBlank(message="Content is mandatory.")
	private String content;
	@NotNull(message="Image file can't be empty.")
	@NotBlank(message="Image file is mandatory.")
	private String imagefile;
	private Date createdAt;
	private Integer categoryId;
	private CategoryDto category;
	private UserDto user;
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImagefile() {
		return imagefile;
	}
	public void setImagefile(String imagefile) {
		this.imagefile = imagefile;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public CategoryDto getCategory() {
		return category;
	}
	public void setCategory(CategoryDto category) {
		this.category = category;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	
	
}
