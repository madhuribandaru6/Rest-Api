package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class education {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="name",nullable = false,length=50)
	private String username;
	private String branch;
	@Email
	private String email;
//	@Pattern(regexp ="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}")
	@Column(length = 10)
	private String password;
	
	
	
	

}
