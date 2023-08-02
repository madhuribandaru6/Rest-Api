package com.example.demo.service;

import java.util.List;

import com.example.demo.payload.education_dpo;

public interface edu_services {
	education_dpo addusers(education_dpo e1);
	education_dpo update(education_dpo e2,int id);
	void delete(int id);
	List<education_dpo>getallusers();
	education_dpo getbyid(int id);

}
