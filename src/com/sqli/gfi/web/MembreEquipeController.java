package com.sqli.gfi.web;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sqli.gfi.model.Attachement;
import com.sqli.gfi.model.Task;
import com.sqli.gfi.model.Utilisateur;
import com.sqli.gfi.service.AttachementService;
import com.sqli.gfi.service.EventService;
import com.sqli.gfi.service.ProjetService;
import com.sqli.gfi.service.SprintService;
import com.sqli.gfi.service.StatutService;
import com.sqli.gfi.service.TaskService;


@Controller
@RequestMapping("/teamember/*")
public class MembreEquipeController {
	
	@Autowired
    private ProjetService projetService;
	@Autowired
    private SprintService sprintService;
	@Autowired
    private TaskService taskService;
	@Autowired
    private EventService eventService;
	@Autowired
	private AttachementService attachementService;
	@Autowired
    private StatutService statutService;
	
	@RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
    public String indexTeamMember(Model model, HttpSession session) {
		model.addAttribute("projects", projetService.getProjetByIdTeamMember(((Utilisateur)session.getAttribute("user_logged_in")).getId_u()));
        return "teamember_project_index";
    }
	
	@RequestMapping(value = "/project", method = RequestMethod.GET)
    public String indexProjectTeamMember(Model model, HttpSession session) {
		model.addAttribute("projects", projetService.getProjetByIdTeamMember(((Utilisateur)session.getAttribute("user_logged_in")).getId_u()));
        return "teamember_project_index";
    }
	
	@RequestMapping(value = "/event", method = RequestMethod.GET)
    public String indexEventTeamMember(Model model, HttpSession session) {
		model.addAttribute("events", eventService.getEventsByIdTeamMember(((Utilisateur)session.getAttribute("user_logged_in")).getId_u()));
        return "teamember_event_index";
    }
	
	@RequestMapping(value = "/invited/{idE}", method = RequestMethod.GET)
    public String Personinvited(@PathVariable("idE") Integer idE, Model model, HttpSession session) {
		model.addAttribute("users", eventService.getUserInvited(idE));
        return "teamember_event_invited";
    }
	
	@RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public String indexTasksTeamMember(Model model, HttpSession session) {
		model.addAttribute("tasks", taskService.getTasksByIdTeamMember(((Utilisateur)session.getAttribute("user_logged_in")).getId_u()));
        return "teamember_task_index";
    }
	
	@RequestMapping(value = "/task/{idT}/file", method = RequestMethod.GET)
    public String fileTaskTeamMember(@PathVariable("idT") Integer idT, Model model, HttpSession session) {
		model.addAttribute("files", attachementService.getFilesByIdTask(idT));
		model.addAttribute("idT", idT);
        return "teamember_task_file_index";
    }
	
	// add files to task
     @RequestMapping(value = "/task/{idT}/file/add", method = RequestMethod.GET)
     public String TeamemberAddFileTaskPage(@PathVariable("idT") Integer idT, @ModelAttribute Attachement file, Model model) {
				model.addAttribute("file", file);
				model.addAttribute("idT", idT);
		        return "teamember_task_file_add";
	}
     
     @RequestMapping(value = "/task/{idT}/file/add", method = RequestMethod.POST)
     public String TeamemberAddFileTask(@PathVariable("idT") Integer idT, @RequestParam("f") CommonsMultipartFile f/*MultipartFile file*/, 
     					@Valid @ModelAttribute("file") Attachement file,  BindingResult result, Model model, RedirectAttributes redirectAttributes) {
 				
 		if(result.hasErrors()) {
 			model.addAttribute("file", file);
			model.addAttribute("idT", idT);
	        return "teamember_task_file_add";
 		 }
 		 			
 		if (f != null && f.getSize() > 0) {
             
 			file.setFilename(f.getOriginalFilename());
 			file.setContenu(f.getBytes());
 			file.setTypeContenu(f.getContentType());
 			file.setDate_attachement(new Date());
 			file.setTask(taskService.getTaskById(idT));
 			attachementService.addAttechement(file);;
             
         } else if(f.getSize() == 0){
        	 model.addAttribute("file", file);
 			 model.addAttribute("idT", idT);
 			 model.addAttribute("errorFileEmpty", "vous devez spécifier un document");
 	         return "teamember_task_file_add";
                      	
         }
 	     redirectAttributes.addFlashAttribute("succesMessage", "Opération bien effectuée");		
 		 return "redirect:/teamember/task/"+idT+"/file";
     }
     
     @RequestMapping(value = "/task/{idT}/file/update/{idF}", method = RequestMethod.GET)
     public String TeamemberupdateFileTaskPage(@PathVariable("idT") Integer idT, @PathVariable("idF") Integer idF, @ModelAttribute Attachement file, Model model) {
 		model.addAttribute("file", attachementService.getAttachementById(idF));
 		model.addAttribute("idT", idT);
 		model.addAttribute("idF", idF);
        return "teamember_task_file_update";
     }
     
     @RequestMapping(value = "/task/{idT}/file/update/{idF}", method = RequestMethod.POST)
     public String TeamemberupdateFileTask(@PathVariable("idT") Integer idT, @PathVariable("idF") Integer idF, @RequestParam("f") CommonsMultipartFile f/*MultipartFile file*/, 
 					@Valid @ModelAttribute("file") Attachement file,  BindingResult result, Model model, RedirectAttributes redirectAttributes) {
 			
 			if(result.hasErrors()) {
 				model.addAttribute("file", attachementService.getAttachementById(idF));
 		 		model.addAttribute("idT", idT);
 		 		model.addAttribute("idF", idF);
 		        return "teamember_task_file_update";
 			}
 					
 			if (f != null && f.getSize() > 0) {
 			
 			file.setFilename(f.getOriginalFilename());
 			file.setContenu(f.getBytes());
 			file.setTypeContenu(f.getContentType());
 			file.setTask(taskService.getTaskById(idT));
 			file.setDate_attachement(new Date());
 			file.setId_attachement(idF);
 			attachementService.addAttechement(file);;
 			
 			} else if(f.getSize() == 0){
 				model.addAttribute("file", attachementService.getAttachementById(idF));
 		 		model.addAttribute("idT", idT);
 		 		model.addAttribute("idF", idF);
 		 		model.addAttribute("errorFileEmpty", "vous devez spécifier un document");
 		        return "teamember_task_file_update"; 				 			
 			}
 			redirectAttributes.addFlashAttribute("succesMessage", "Opération bien effectuée");		
 			return "redirect:/teamember/task/"+idT+"/file";
     }
     
     
     @RequestMapping(value = "/{idS}/task/update/{idT}", method = RequestMethod.GET)
     public String TeamemberudpateTaskPage(@PathVariable("idS") Integer idS, @PathVariable("idT") Integer idT, @ModelAttribute Task task, Model model) {
    	model.addAttribute("task", taskService.getTaskById(idT));
    	 model.addAttribute("statuts", statutService.getAllStatut());
        return "teamember_task_update";
     }
     
     @RequestMapping(value = "/{idS}/task/update/{idT}", method = RequestMethod.POST)
     public String TeamemberupdateTask(@PathVariable("idS") Integer idS, @PathVariable("idT") Integer idT, 
    		 				 @RequestParam(value="id_statut", required = false) String id_statut, 
 							 @Valid @ModelAttribute("task") Task task, BindingResult result, Model model, 
 							 RedirectAttributes redirectAttributes, HttpSession session) {
 		Task db_task = taskService.getTaskById(idT);		
 		task.setResponsable(db_task.getResponsable());
 		task.setSprint(sprintService.getSprintById(idS));
 		task.setNom(db_task.getNom());
 		task.setDesc(db_task.getDesc());
 		task.setDate_debut(db_task.getDate_debut());
 		task.setDate_fin(db_task.getDate_fin());
 		task.setPriorite(db_task.getPriorite());
 		task.setEstimation(db_task.getEstimation());
 		task.setStatut(statutService.getStatutById(Integer.parseInt(id_statut)));
 		task.setId_task(idT);
 		taskService.addTask(task);	
 		redirectAttributes.addFlashAttribute("succesMessage", "Opération bien effectuée");
 		return "redirect:/teamember/tasks";
     }
     
     @RequestMapping(value = "/myTask", method = RequestMethod.GET)
     public String myTaskTeamMember(Model model, HttpSession session) {
 		model.addAttribute("tasks", taskService.getTasksByIdTeamMember(((Utilisateur)session.getAttribute("user_logged_in")).getId_u()));
         return "teamember_my_task";
     }
	
	
	//___________________  Download file ___________________//
	//_____________________________________________________//
		
	@RequestMapping("/file/download/{idA}")
	public String download(@PathVariable("idA") Integer idA, HttpServletResponse response) {
		
		Attachement doc = attachementService.getAttachementById(idA);		
		try {
			response.setHeader("Content-Disposition", "inline;filename=\"" +doc.getFilename()+ "\"");
			OutputStream out = response.getOutputStream();
			response.setContentType(doc.getTypeContenu());
			FileCopyUtils.copy(doc.getContenu(), out);
			out.flush();
			out.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		} 

		return null;
	}
	
}
