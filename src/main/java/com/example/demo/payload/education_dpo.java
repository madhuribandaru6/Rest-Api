package com.example.demo.payload;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class education_dpo {
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
