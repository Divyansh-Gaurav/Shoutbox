package com.cybage.shoutbox.models;

import java.util.Arrays;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "posts")
public class Posts {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "post_id", nullable = false)
	private UUID id;
	@Column(name = "post_name", nullable = false)
	private String name;
	@Column(name = "post_type", nullable = false)
	private PostType type;
	@Column(name = "post_data", nullable = false)
	@Lob
	private byte[] fileData;

	Posts() {
	}

	public byte[] getFileData() {
		return fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PostType getType() {
		return type;
	}

	public void setType(PostType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Posts [id=" + id + ", name=" + name + ", type=" + type + ", fileData=" + Arrays.toString(fileData)
				+ "]";
	}

}
