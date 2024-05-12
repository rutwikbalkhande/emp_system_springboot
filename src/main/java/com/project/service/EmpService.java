package com.project.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.helpers.Reporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.entity.Employee;
import com.project.repository.EmpRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class EmpService {
 
	@Autowired
	private EmpRepository empRepository;
	
	
	public String addEmp(Employee e ) {
		
		empRepository.save(e);
		
		return"";
	}
	
	public List<Employee> getAll()
	{
		return empRepository.findAll();
	}
	 
	
	public Employee getEmpById(int id) {
               Optional<Employee> e= empRepository.findById(id);
		
		         if(e.isPresent())
		       {
			      return e.get();
	         	}
	            	return null;
	     }
	
	public String deleteEmp(int id)
	{
		empRepository.deleteById(id);
		return "";
	}
      }
