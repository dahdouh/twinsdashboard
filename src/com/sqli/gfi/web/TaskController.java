package com.sqli.gfi.web;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sqli.gfi.model.Task;
import com.sqli.gfi.service.ProjetService;
import com.sqli.gfi.service.SprintService;
import com.sqli.gfi.service.StatutService;
import com.sqli.gfi.service.TaskService;
import com.sqli.gfi.service.UtilisateurService;

@Controller
@RequestMapping("/dashboard/{idS}/task/*")
public class TaskController {
	
	@Autowired
    private TaskService TaskService;
	@Autowired
    private SprintService sprintService;
	@Autowired
    private ProjetService projetService;
	@Autowired
    private StatutService statutService;
	@Autowired
	private UtilisateurService utilisateurService;
	//________________________________________________________ Task Home______________________________________________________//
    //_____________________________________________________________________________________________________________________________________//
	
	@RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
    public String indexTaskSprint(@PathVariable("idS") Integer idS, Model model) {
		model.addAttribute("tasks", TaskService.getTasksByIdSprint(idS));
		model.addAttribute("sprint", sprintService.getSprintById(idS));
		//Count Tasks
        model.addAttribute("CountTasksCompleted", TaskService.getTasksCompleted(idS).size());
		model.addAttribute("CountTasksInprogress", TaskService.getTasksInprogress(idS).size());
		model.addAttribute("CountTasksPending", TaskService.getTasksPending(idS).size());
        return "dashboardmanager_task_sprint_index";
    }
	@RequestMapping(value = "/all", method = RequestMethod.GET)
    public String indexTaskProject(@PathVariable("idS") Integer idP, Model model) {
		model.addAttribute("tasks", TaskService.getTasksByIdProject(idP));
		model.addAttribute("projet", projetService.getProjetById(idP));
		//Count Sprints
	    model.addAttribute("CountTasksCompleted", sprintService.getSprintsCompleted(idP).size());
		model.addAttribute("CountTasksInprogress", sprintService.getSprintsInprogress(idP).size());
		model.addAttribute("CountTasksPending", sprintService.getSprintsPending(idP).size());
        return "dashboardmanager_task_project_index";
    }
	
	private Map<String,String>  priority_list() {
    	Map<String,String> priority_list = new LinkedHashMap<String,String>();
    	priority_list.put("High", "High");
    	priority_list.put("Normal", "Normal");
    	priority_list.put("Low", "Low");;
    	return priority_list;
	}
	// add task sprint
	@RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addTaskPage(@PathVariable("idS") Integer idS, @ModelAttribute Task task, Model model) {
		model.addAttribute("sprint", sprintService.getSprintById(idS));
		model.addAttribute("task", task);
		model.addAttribute("responsables", utilisateurService.getAllUtilisateurTeamProject(sprintService.getSprintById(idS).getProjet().getId_projet()));
        model.addAttribute("statuts", statutService.getAllStatut());
        model.addAttribute("priority", priority_list());
        //Count Tasks
        model.addAttribute("CountTasksCompleted", TaskService.getTasksCompleted(idS).size());
		model.addAttribute("CountTasksInprogress", TaskService.getTasksInprogress(idS).size());
		model.addAttribute("CountTasksPending", TaskService.getTasksPending(idS).size());
        return "dashboardmanager_task_add";
    }
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addTaskt(@RequestParam(value="id_responsable", required = false) String id_responsable, @RequestParam(value="id_statut", required = false) String id_statut,
    					   @PathVariable("idS") Integer idS, 
    					   @Valid @ModelAttribute("task") Task task, BindingResult result, Model model, 
			RedirectAttributes redirectAttributes, HttpSession session) {
		if (result.hasErrors()) {
	        model.addAttribute("task", task);
	        model.addAttribute("sprint", sprintService.getSprintById(idS));
			model.addAttribute("task", task);
			model.addAttribute("responsables", utilisateurService.getAllUtilisateurTeamProject(sprintService.getSprintById(idS).getProjet().getId_projet()));
	        model.addAttribute("statuts", statutService.getAllStatut());
	        model.addAttribute("priority", priority_list());
	        //Count Tasks
	        model.addAttribute("CountTasksCompleted", TaskService.getTasksCompleted(idS).size());
			model.addAttribute("CountTasksInprogress", TaskService.getTasksInprogress(idS).size());
			model.addAttribute("CountTasksPending", TaskService.getTasksPending(idS).size());
			return "dashboardmanager_task_add";
		} 
				
		task.setStatut(statutService.getStatutById(Integer.parseInt(id_statut)));
		task.setResponsable(utilisateurService.getUtilisateurById(Integer.parseInt(id_responsable)));
		task.setSprint(sprintService.getSprintById(idS));
		TaskService.addTask(task);	
		redirectAttributes.addFlashAttribute("succesMessage", "Opération bien effectuée");
		return "redirect:/dashboard/"+idS+"/task/";
		
    }
	// add task project
	@RequestMapping(value = "/project_add", method = RequestMethod.GET)
    public String addTaskProjectPage(@PathVariable("idS") Integer idP, @ModelAttribute Task task, Model model) {
		model.addAttribute("projet", projetService.getProjetById(idP));
		model.addAttribute("task", task);
		model.addAttribute("sprints", sprintService.getAllSprint(idP));
		model.addAttribute("responsables", utilisateurService.getAllUtilisateurTeamProject(idP));
        model.addAttribute("statuts", statutService.getAllStatut());
        model.addAttribute("priority", priority_list());
       //Count Sprints
	    model.addAttribute("CountTasksCompleted", sprintService.getSprintsCompleted(idP).size());
		model.addAttribute("CountTasksInprogress", sprintService.getSprintsInprogress(idP).size());
		model.addAttribute("CountTasksPending", sprintService.getSprintsPending(idP).size());
        return "dashboardmanager_task_project_add";
    }
	
	@RequestMapping(value = "/project_add", method = RequestMethod.POST)
    public String addTaskProject(@RequestParam(value="id_sprint", required = false) String id_sprint, @RequestParam(value="id_responsable", required = false) String id_responsable,
    						@RequestParam(value="id_statut", required = false) String id_statut,
    					   @PathVariable("idS") Integer idP, 
    					   @Valid @ModelAttribute("task") Task task, BindingResult result, Model model, 
			RedirectAttributes redirectAttributes, HttpSession session) {
		if (result.hasErrors()) {
			model.addAttribute("projet", projetService.getProjetById(idP));
			model.addAttribute("task", task);
			model.addAttribute("sprints", sprintService.getAllSprint(idP));
			model.addAttribute("responsables", utilisateurService.getAllUtilisateurTeamProject(idP));
	        model.addAttribute("statuts", statutService.getAllStatut());
	        model.addAttribute("priority", priority_list());
	       //Count Sprints
		    model.addAttribute("CountTasksCompleted", sprintService.getSprintsCompleted(idP).size());
			model.addAttribute("CountTasksInprogress", sprintService.getSprintsInprogress(idP).size());
			model.addAttribute("CountTasksPending", sprintService.getSprintsPending(idP).size());
	        return "dashboardmanager_task_project_add";
		} 
				
		task.setStatut(statutService.getStatutById(Integer.parseInt(id_statut)));
		task.setResponsable(utilisateurService.getUtilisateurById(Integer.parseInt(id_responsable)));
		task.setSprint(sprintService.getSprintById(Integer.parseInt(id_sprint)));
		TaskService.addTask(task);	
		redirectAttributes.addFlashAttribute("succesMessage", "Opération bien effectuée");
		return "redirect:/dashboard/"+idP+"/task/all";		
    }
	
	@RequestMapping(value = "/update/{idT}", method = RequestMethod.GET)
    public String udpateTaskPage(@PathVariable("idS") Integer idS, @PathVariable("idT") Integer idT, @ModelAttribute Task task, Model model) {
		model.addAttribute("sprint", sprintService.getSprintById(idS));
		model.addAttribute("task", TaskService.getTaskById(idT));
		model.addAttribute("responsables", utilisateurService.getAllUtilisateurTeamProject(sprintService.getSprintById(idS).getProjet().getId_projet()));
        model.addAttribute("statuts", statutService.getAllStatut());
        model.addAttribute("priority", priority_list());
       //Count Tasks
        model.addAttribute("CountTasksCompleted", TaskService.getTasksCompleted(idS).size());
		model.addAttribute("CountTasksInprogress", TaskService.getTasksInprogress(idS).size());
		model.addAttribute("CountTasksPending", TaskService.getTasksPending(idS).size());
        return "dashboardmanager_task_update";
    }
	
	@RequestMapping(value = "/update/{idT}", method = RequestMethod.POST)
    public String updateTask(@PathVariable("idS") Integer idS, @PathVariable("idT") Integer idT, @RequestParam(value="id_responsable", required = false) String id_responsable,
    						 @RequestParam(value="id_statut", required = false) String id_statut, 
							 @Valid @ModelAttribute("task") Task task, BindingResult result, Model model, 
							 RedirectAttributes redirectAttributes, HttpSession session) {
		if (result.hasErrors()) {
			model.addAttribute("sprint", sprintService.getSprintById(idS));
			model.addAttribute("task", TaskService.getTaskById(idT));
			model.addAttribute("responsables", utilisateurService.getAllUtilisateurTeamProject(sprintService.getSprintById(idS).getProjet().getId_projet()));
	        model.addAttribute("statuts", statutService.getAllStatut());
	        model.addAttribute("priority", priority_list());
	        //Count Tasks
	        model.addAttribute("CountTasksCompleted", TaskService.getTasksCompleted(idS).size());
			model.addAttribute("CountTasksInprogress", TaskService.getTasksInprogress(idS).size());
			model.addAttribute("CountTasksPending", TaskService.getTasksPending(idS).size());
	        return "dashboardmanager_task_update";
		} 
				
		task.setStatut(statutService.getStatutById(Integer.parseInt(id_statut)));
		task.setResponsable(utilisateurService.getUtilisateurById(Integer.parseInt(id_responsable)));
		task.setSprint(sprintService.getSprintById(idS));
		task.setId_task(idT);
		TaskService.addTask(task);	
		redirectAttributes.addFlashAttribute("succesMessage", "Opération bien effectuée");
		return "redirect:/dashboard/"+idS+"/task/";
    }
	
	@RequestMapping(value = "/delete/{idT}", method = RequestMethod.GET)
  public String deleteSprint(@PathVariable("idS") Integer idS, @PathVariable("idT") Integer idT, RedirectAttributes redirectAttributes, HttpSession session) {
		Task task = TaskService.getTaskById(idT);
	    TaskService.deleteTask(idT);
//			session.setAttribute("count_dashboardmanager", dashboardService.countDashboardManager());
	    redirectAttributes.addFlashAttribute("succesMessage", "Opération bien effectuée");
	    return "redirect:/dashboard/"+idS+"/task/";
	 }

	@RequestMapping(value = "/completed", method = RequestMethod.GET)
    public String TaskCompleted(@PathVariable("idS") Integer idS, Model model) {
		model.addAttribute("tasks", TaskService.getTasksCompleted(idS));
		model.addAttribute("sprint", sprintService.getSprintById(idS));
		//Count Tasks
        model.addAttribute("CountTasksCompleted", TaskService.getTasksCompleted(idS).size());
		model.addAttribute("CountTasksInprogress", TaskService.getTasksInprogress(idS).size());
		model.addAttribute("CountTasksPending", TaskService.getTasksPending(idS).size());
        return "dashboardmanager_task_completed";
    }
	
	@RequestMapping(value = "/inprogress", method = RequestMethod.GET)
    public String TaskInProgress(@PathVariable("idS") Integer idS, Model model) {
		model.addAttribute("tasks", TaskService.getTasksInprogress(idS));
		model.addAttribute("sprint", sprintService.getSprintById(idS));
		//Count Tasks
        model.addAttribute("CountTasksCompleted", TaskService.getTasksCompleted(idS).size());
		model.addAttribute("CountTasksInprogress", TaskService.getTasksInprogress(idS).size());
		model.addAttribute("CountTasksPending", TaskService.getTasksPending(idS).size());
        return "dashboardmanager_task_inprogress";
    }
	
	@RequestMapping(value = "/pending", method = RequestMethod.GET)
    public String TaskPending(@PathVariable("idS") Integer idS, Model model) {
		model.addAttribute("tasks", TaskService.getTasksPending(idS));
		model.addAttribute("sprint", sprintService.getSprintById(idS));
		//Count Tasks
        model.addAttribute("CountTasksCompleted", TaskService.getTasksCompleted(idS).size());
		model.addAttribute("CountTasksInprogress", TaskService.getTasksInprogress(idS).size());
		model.addAttribute("CountTasksPending", TaskService.getTasksPending(idS).size());
        return "dashboardmanager_task_pending";
    }

}
