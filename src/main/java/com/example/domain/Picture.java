package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="pictures")
public class Picture {
	@Id
	private String id;
	
	private String user_id;
	
	private String comment;
	
	private String path;
	
}
