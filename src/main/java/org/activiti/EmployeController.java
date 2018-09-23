package org.activiti;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.model.PrioriteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class EmployeController {
	
	@Autowired
	private PrioRepository prioRepository; 
	
	@Autowired
	private EmployeRepository employeRepository;
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
	private TaskService taskService;

	/***
	 * list of employee prio
	 * @return
	 */
	@RequestMapping(value  = "employeePrio/{matricule}", method = RequestMethod.GET)
	public String employeePrio(Model model, @PathVariable("matricule") String matricule){
		PrioriteModel prioriteModel = new PrioriteModel();
		prioriteModel.setMatricule(matricule);
		model.addAttribute("priorite", prioriteModel);
		model.addAttribute("priorities", employeRepository.getPrioritiesByMatricule(matricule));
		// search the prio for this user
		return "employeePrio";
	}
	
	/**
	 * save a new employe prio
	 * @param priorite
	 * @return
	 */
	@RequestMapping(value  = "newEmployeePrio", method = RequestMethod.POST)
	public RedirectView addNewPriority(@ModelAttribute("priorite")PrioriteModel prioriteModel){
		Priorite prio  = new Priorite();
		prio.setOwner(employeRepository.findOne(prioriteModel.getMatricule()));
		prio.setTitre(prioriteModel.getTitre());
		prio.setDescription(prioriteModel.getDescription());
		prio.setDateFin(prioriteModel.getDateFin());
		prioRepository.save(prio);
		
		
		Map<String, Object> vars = Collections.<String, Object>singletonMap("priority", prio);
		ProcessInstance processInstance  = runtimeService.startProcessInstanceByKey("prioriteProcess", vars);
	    
		
	    // set the task to the current employee 
	      List<Task> tasks = taskService.createTaskQuery().executionId(processInstance.getId()).list();
	      for (Task task : tasks) {
	         task.setOwner(prio.getOwner().getMatricule());
	         if (prio.getOwner().getManager() != null){
	        	 task.setAssignee(prio.getOwner().getManager().getMatricule());	        	 
	         }
	         taskService.saveTask(task);
	      }
	    
	      // show the acitviti APIS as below
	      // http://localhost:8080/runtime/tasks
	      
	      
		return new RedirectView("employeePrio/"+prioriteModel.getMatricule());
	}
}
