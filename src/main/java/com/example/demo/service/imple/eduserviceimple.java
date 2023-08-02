package com.example.demo.service.imple;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptionhandling.ResourceNotFoundException;
import com.example.demo.model.education;
import com.example.demo.payload.education_dpo;
import com.example.demo.repository.edurepository;
import com.example.demo.service.edu_services;

@Service
public class eduserviceimple implements edu_services {
	
	@Autowired
	edurepository repo;
	@Autowired //for connecting layers
	ModelMapper modelmapper;

	@Override
	public education_dpo addusers(education_dpo e1) {
		// TODO Auto-generated method stub
		education e4=this.dto_users(e1); //dto to orginal
		education saveuser=this.repo.save(e4); //saving data in database
		return this.users_dto(saveuser); // getting data from orginal to dto
		
	}



	@Override
	public education_dpo update(education_dpo e2, int id) {
		// TODO Auto-generated method stub
		 education e=this.repo.findById(id).orElseThrow(()->new ResourceNotFoundException("education","id",id));
		 e.setUsername(e2.getUsername());
		 e.setBranch(e2.getBranch());
		 e.setEmail(e2.getEmail());
		 e.setPassword(e2.getPassword());
		 education s=this.repo.save(e);
		 education_dpo ed=this.users_dto(s);
		 return ed;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		education edu=this.repo.findById(id).orElseThrow(()->new ResourceNotFoundException("education","id",id));
		this.repo.delete(edu);

	}

	@Override
	public List<education_dpo> getallusers() {
	  List<education> edu=(List<education>)this.repo.findAll();
	  List<education_dpo> ed=edu.stream().map(stu->this.users_dto(stu)).collect(Collectors.toList());
	  return ed;
	}

	@Override
	public education_dpo getbyid(int id) {
		// TODO Auto-generated method stub
		education ed=this.repo.findById(id).orElseThrow(()->new ResourceNotFoundException("education","id", id));
        return this.users_dto(ed);

	}

	
	public education dto_users(education_dpo edu) { //passing data from duplicate to original
		education e=this.modelmapper.map(edu, education.class);
		return e;
		
	}
	public education_dpo users_dto(education edu) {
		//passing data from
		education_dpo ed=this.modelmapper.map(edu, education_dpo.class);
		return ed;
		
	}
	//modelmapper is used for twoway binding for dataflowing
	

}
