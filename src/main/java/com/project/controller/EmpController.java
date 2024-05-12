
package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.entity.Employee;
import com.project.service.EmpService;

import jakarta.servlet.http.HttpSession;



@Controller
public class EmpController {
	
	@Autowired
	private EmpService service;
	
	@GetMapping("/home")
	public String home(Model m)
	{
		List <Employee> emp=service.getAll();
		m.addAttribute("emp",emp);
	
		return "index";
	}

	@GetMapping("/addemp")
	public String addEmpForm() {
		
		
		return "add_emp";
	}
	
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e , HttpSession session)
	{
		service.addEmp(e);
		System.out.println(e);
		
		session.setAttribute("msg" , "employee add Sucessfully");		
		return "register";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id,Model m) {
		
		Employee emp=service.getEmpById(id);
		m.addAttribute("emp",emp);
		
		return "edit";		
	}
	
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e,HttpSession session)
	{
		service.addEmp(e);
		session.setAttribute("msg", "employee update sucessfully...");
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmp(@PathVariable int id, HttpSession session) {
		
		service.deleteEmp(id);
		session.setAttribute("msg", "EMP data delete sucessfully...");
		return "redirect:/";
	}
}