package org.activiti;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Controller
public class EmployeController {

	@Autowired
	 private ApplicantRepository applicantRepository;
	
	@RequestMapping(value  = "test", method = RequestMethod.GET)
	public String addNewPriority(Map<String, Object> model){
		model.put("message", "hello world");
		return "test";
	}
	

	
	
	
	
	
	
}
