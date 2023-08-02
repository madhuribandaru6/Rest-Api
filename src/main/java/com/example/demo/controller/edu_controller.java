package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptionhandling.ApiResponse;
import com.example.demo.payload.education_dpo;
import com.example.demo.service.edu_services;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1")
public class edu_controller {
	
	@Autowired
	edu_services service;
	
	@PostMapping("/insert")
	public ResponseEntity<education_dpo>adduser(@Valid @RequestBody education_dpo p){
		education_dpo edudto=this.service.addusers(p);
		return new ResponseEntity<>(edudto,HttpStatus.CREATED);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<education_dpo>update(@Valid @PathVariable int id,@RequestBody education_dpo p){
		education_dpo edudto=this.service.update(p,id);
		return ResponseEntity.ok(edudto);
		
		
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse>delete(@Valid @PathVariable int id){
		this.service.delete(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("id deleted successfully",true),HttpStatus.OK);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<education_dpo>>getall(){
		return ResponseEntity.ok(this.service.getallusers());
	}
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<education_dpo>getbyid(@Valid @PathVariable int id){
		return ResponseEntity.ok(this.service.getbyid(id));
	}

}
