package org.activiti;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class EmployeController {

	@RequestMapping(value  = "test", method = RequestMethod.GET)
	public String addNewPriority(Map<String, Object> model){
		model.put("message", "hello world");
		return "test";
	}
}
