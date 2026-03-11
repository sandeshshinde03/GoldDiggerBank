package com.empMVC.Controller;
import org.springframework.dao.DuplicateKeyException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.empMVC.DAO.EmployeeDAO;
import com.empMVC.Entity.Employee;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeDAO dao;
	
	@RequestMapping("/employee")
	public String showform() {
		return "employee";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("emp") Employee emp, Model model) {

	    if (dao.existsById(emp.getEid())) {
	        model.addAttribute("error", "Employee ID already exists!");
	        return "employee";   
	    }

	    dao.save(emp);
	    return "redirect:/viewemp";
	}
	
	@RequestMapping("/viewemp")
	public String viewemp(Model m) {
		List<Employee> list=dao.getAllEmp();
		m.addAttribute("list",list);
		return "EmployeeView";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {
	    dao.delete(id);
	    return "redirect:/viewemp";
	}
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") int id, Model model) {
	    Employee emp = dao.getEmpById(id);
	    model.addAttribute("emp", emp);
	    return "editemployee";  
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("emp") Employee emp) {
	    dao.update(emp);
	    return "redirect:/viewemp";
	}
}
