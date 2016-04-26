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
import com.sqli.gfi.service.AttachementService;
import com.sqli.gfi.service.ProjetService;
import com.sqli.gfi.service.SprintService;
import com.sqli.gfi.service.StatutService;
import com.sqli.gfi.service.TaskService;
import com.sqli.gfi.service.UtilisateurService;

@Controller
@RequestMapping("/dashboard/{idS}/file/*")
public class FilesController {
	
	@Autowired
    private AttachementService attachementService;
	@Autowired
    private SprintService sprintService;
	@Autowired
    private ProjetService projetService;
	@Autowired
    private StatutService statutService;
	@Autowired
	private UtilisateurService utilisateurService;
	@Autowired
    private TaskService TaskService;
	
	//_______________________________________________________ Files/Attachment Task _______________________________________________________//
    //_____________________________________________________________________________________________________________________________________//
	
	@RequestMapping(value = "/task/{idT}", method = RequestMethod.GET)
    public String indexAttachementTask(@PathVariable("idT") Integer idT, @PathVariable("idS") Integer idS, Model model) {
		model.addAttribute("files", attachementService.getFilesByIdTask(idT));
		model.addAttribute("sprint", sprintService.getSprintById(idS));
		model.addAttribute("idT", idT);
		//Count Tasks
        model.addAttribute("CountTasksCompleted", TaskService.getTasksCompleted(idS).size());
		model.addAttribute("CountTasksInprogress", TaskService.getTasksInprogress(idS).size());
		model.addAttribute("CountTasksPending", TaskService.getTasksPending(idS).size());
        return "dashboardmanager_files_task_index";
    }
	
	// add files to task
	@RequestMapping(value = "/task/{idT}/add", method = RequestMethod.GET)
	public String addFileTaskPage(@PathVariable("idT") Integer idT, @PathVariable("idS") Integer idS, @ModelAttribute Attachement file, Model model) {
			model.addAttribute("sprint", sprintService.getSprintById(idS));
			model.addAttribute("file", file);
			model.addAttribute("idT", idT);
	        return "dashboardmanager_file_task_add";
	 }
	
	@RequestMapping(value = "/task/{idT}/add", method = RequestMethod.POST)
    public String addFileTak(@PathVariable("idT") Integer idT, @PathVariable("idS") Integer idS, @RequestParam("f") CommonsMultipartFile f/*MultipartFile file*/, 
    					@Valid @ModelAttribute("file") Attachement file,  BindingResult result, Model model, RedirectAttributes redirectAttributes) {
				
		if(result.hasErrors()) {
			model.addAttribute("sprint", sprintService.getSprintById(idS));
			model.addAttribute("file", file);
			model.addAttribute("idT", idT);
	        return "dashboardmanager_file_add";
		 }
		 			
		if (f != null && f.getSize() > 0) {
            
			file.setFilename(f.getOriginalFilename());
			file.setContenu(f.getBytes());
			file.setTypeContenu(f.getContentType());
			file.setDate_attachement(new Date());
			file.setTask(TaskService.getTaskById(idT));
			attachementService.addAttechement(file);;
            
        } else if(f.getSize() == 0){
        	model.addAttribute("sprint", sprintService.getSprintById(idS));
			model.addAttribute("file", file);
			model.addAttribute("idT", idT);
            model.addAttribute("errorFileEmpty", "vous devez spécifier un document");
            return "dashboardmanager_file_task_add";
        	
        }
	     redirectAttributes.addFlashAttribute("succesMessage", "Opération bien effectuée");		
		 return "redirect:/dashboard/"+idS+"/file/task/"+idT;
    }
		
	@RequestMapping(value = "/task/{idT}/update/{idF}", method = RequestMethod.GET)
    public String updateFileTaskPage(@PathVariable("idT") Integer idT, @PathVariable("idS") Integer idS, @PathVariable("idF") Integer idF, @ModelAttribute Attachement file, Model model) {
		model.addAttribute("sprint", sprintService.getSprintById(idS));
		model.addAttribute("file", attachementService.getAttachementById(idF));
		model.addAttribute("idT", idT);
        return "dashboardmanager_file_task_update";
    }
	
	@RequestMapping(value = "/task/{idT}/update/{idF}", method = RequestMethod.POST)
    public String updateFileTask(@PathVariable("idT") Integer idT, @PathVariable("idS") Integer idS, @PathVariable("idF") Integer idF, @RequestParam("f") CommonsMultipartFile f/*MultipartFile file*/, 
					@Valid @ModelAttribute("file") Attachement file,  BindingResult result, Model model, RedirectAttributes redirectAttributes) {
			
			if(result.hasErrors()) {
				model.addAttribute("sprint", sprintService.getSprintById(idS));
				model.addAttribute("file", attachementService.getAttachementById(idF));
				model.addAttribute("idT", idT);
				return "dashboardmanager_file_task_update";
			}
					
			if (f != null && f.getSize() > 0) {
			
			file.setFilename(f.getOriginalFilename());
			file.setContenu(f.getBytes());
			file.setTypeContenu(f.getContentType());
			file.setTask(TaskService.getTaskById(idT));
			file.setDate_attachement(new Date());
			file.setId_attachement(idF);
			attachementService.addAttechement(file);;
			
			} else if(f.getSize() == 0){
				model.addAttribute("sprint", sprintService.getSprintById(idS));
				model.addAttribute("file", attachementService.getAttachementById(idF));
				model.addAttribute("idT", idT);
				model.addAttribute("errorFileEmpty", "vous devez spécifier un document");
				return "dashboardmanager_file_task_update";
			
			}
			redirectAttributes.addFlashAttribute("succesMessage", "Opération bien effectuée");		
			return "redirect:/dashboard/"+idS+"/file/task/"+idT;
    }
	
	@RequestMapping(value = "/task/{idT}/delete/{idF}", method = RequestMethod.GET)
	   public String deleteFileTaskSprint( @PathVariable("idT") Integer idT, @PathVariable("idS") Integer idS, @PathVariable("idF") Integer idF, RedirectAttributes redirectAttributes, HttpSession session) {
		    attachementService.deleteAttachment(idF);
//				session.setAttribute("count_dashboardmanager", dashboardService.countDashboardManager());
		    redirectAttributes.addFlashAttribute("succesMessage", "Opération bien effectuée");
		    return "redirect:/dashboard/"+idS+"/file/task/"+idT;
	}
	
	//________________________________________________________ Files/Attachment Sprint______________________________________________________//
    //_____________________________________________________________________________________________________________________________________//
	
	@RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
    public String indexAttachementSprint(@PathVariable("idS") Integer idS, Model model) {
		model.addAttribute("files", attachementService.getFilesByIdSprint(idS));
		model.addAttribute("sprint", sprintService.getSprintById(idS));
		//Count Tasks
        model.addAttribute("CountTasksCompleted", TaskService.getTasksCompleted(idS).size());
		model.addAttribute("CountTasksInprogress", TaskService.getTasksInprogress(idS).size());
		model.addAttribute("CountTasksPending", TaskService.getTasksPending(idS).size());
        return "dashboardmanager_files_sprint_index";
    }
	
	// add files to sprint
	@RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addFileSprintPage(@PathVariable("idS") Integer idS, @ModelAttribute Attachement file, Model model) {
		model.addAttribute("sprint", sprintService.getSprintById(idS));
		model.addAttribute("file", file);
		//Count Tasks
        model.addAttribute("CountTasksCompleted", TaskService.getTasksCompleted(idS).size());
		model.addAttribute("CountTasksInprogress", TaskService.getTasksInprogress(idS).size());
		model.addAttribute("CountTasksPending", TaskService.getTasksPending(idS).size());
        return "dashboardmanager_file_add";
    }
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addFileSprint(@PathVariable("idS") Integer idS, @RequestParam("f") CommonsMultipartFile f/*MultipartFile file*/, 
    					@Valid @ModelAttribute("file") Attachement file,  BindingResult result, Model model, RedirectAttributes redirectAttributes) {
				
		if(result.hasErrors()) {
			model.addAttribute("sprint", sprintService.getSprintById(idS));
			model.addAttribute("file", file);
	        return "dashboardmanager_file_add";
		 }
		 			
		if (f != null && f.getSize() > 0) {
            
			file.setFilename(f.getOriginalFilename());
			file.setContenu(f.getBytes());
			file.setTypeContenu(f.getContentType());
			
			file.setSprint(sprintService.getSprintById(idS));
			attachementService.addAttechement(file);;
            
        } else if(f.getSize() == 0){
        	model.addAttribute("sprint", sprintService.getSprintById(idS));
			model.addAttribute("file", file);
            model.addAttribute("errorFileEmpty", "vous devez spécifier un document");
            return "dashboardmanager_file_add";
        	
        }
	     redirectAttributes.addFlashAttribute("succesMessage", "Opération bien effectuée");		
		 return "redirect:/dashboard/"+idS+"/file/";
    }
	
	//________________________________________________ Files/Attachment Sprint via project ________________________________________________//
    //_____________________________________________________________________________________________________________________________________//	
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
    public String indexTaskProject(@PathVariable("idS") Integer idP, Model model) {
		model.addAttribute("files", attachementService.getFilesByIdProject(idP));
		model.addAttribute("projet", projetService.getProjetById(idP));
		//Count Sprints
	    model.addAttribute("CountTasksCompleted", sprintService.getSprintsCompleted(idP).size());
		model.addAttribute("CountTasksInprogress", sprintService.getSprintsInprogress(idP).size());
		model.addAttribute("CountTasksPending", sprintService.getSprintsPending(idP).size());
        return "dashboardmanager_files_project_index";
    }
	
	// add files to project
	@RequestMapping(value = "/project_add", method = RequestMethod.GET)
    public String addFileProjectPage(@PathVariable("idS") Integer idP, @ModelAttribute Attachement file, Model model) {
		model.addAttribute("projet", projetService.getProjetById(idP));
		model.addAttribute("sprints", sprintService.getAllSprint(idP));
		model.addAttribute("file", file);
		//Count Sprints
	    model.addAttribute("CountTasksCompleted", sprintService.getSprintsCompleted(idP).size());
		model.addAttribute("CountTasksInprogress", sprintService.getSprintsInprogress(idP).size());
		model.addAttribute("CountTasksPending", sprintService.getSprintsPending(idP).size());
        return "dashboardmanager_file_project_add";
    }
	
	@RequestMapping(value = "/project_add", method = RequestMethod.POST)
    public String addFileProject(@RequestParam(value="id_sprint", required = false) String id_sprint, @PathVariable("idS") Integer idP, @RequestParam("f") CommonsMultipartFile f/*MultipartFile file*/, 
    					@Valid @ModelAttribute("file") Attachement file,  BindingResult result, Model model, RedirectAttributes redirectAttributes) {
				
		if(result.hasErrors()) {
			model.addAttribute("projet", projetService.getProjetById(idP));
			model.addAttribute("sprints", sprintService.getAllSprint(idP));
			model.addAttribute("file", file);
			//Count Sprints
		    model.addAttribute("CountTasksCompleted", sprintService.getSprintsCompleted(idP).size());
			model.addAttribute("CountTasksInprogress", sprintService.getSprintsInprogress(idP).size());
			model.addAttribute("CountTasksPending", sprintService.getSprintsPending(idP).size());
	        return "dashboardmanager_file_project_add";
		 }
		 			
		if (f != null && f.getSize() > 0) {
            
			file.setFilename(f.getOriginalFilename());
			file.setContenu(f.getBytes());
			file.setTypeContenu(f.getContentType());
			
			file.setSprint(sprintService.getSprintById(Integer.parseInt(id_sprint)));
			attachementService.addAttechement(file);;
            
        } else if(f.getSize() == 0){
        	model.addAttribute("projet", projetService.getProjetById(idP));
			model.addAttribute("sprints", sprintService.getAllSprint(idP));
			model.addAttribute("file", file);
			//Count Sprints
		    model.addAttribute("CountTasksCompleted", sprintService.getSprintsCompleted(idP).size());
			model.addAttribute("CountTasksInprogress", sprintService.getSprintsInprogress(idP).size());
			model.addAttribute("CountTasksPending", sprintService.getSprintsPending(idP).size()); 
            model.addAttribute("errorFileEmpty", "vous devez spécifier un document");
            return "dashboardmanager_file_project_add";
        	
        }
	     redirectAttributes.addFlashAttribute("succesMessage", "Opération bien effectuée");		
		 return "redirect:/dashboard/"+idP+"/file/all";
    }
	
	
	@RequestMapping(value = "/update/{idF}", method = RequestMethod.GET)
    public String updateFilePage(@PathVariable("idS") Integer idS, @PathVariable("idF") Integer idF, @ModelAttribute Attachement file, Model model) {
		model.addAttribute("sprint", sprintService.getSprintById(idS));
		model.addAttribute("file", attachementService.getAttachementById(idF));
		//Count Tasks
        model.addAttribute("CountTasksCompleted", TaskService.getTasksCompleted(idS).size());
		model.addAttribute("CountTasksInprogress", TaskService.getTasksInprogress(idS).size());
		model.addAttribute("CountTasksPending", TaskService.getTasksPending(idS).size());
        return "dashboardmanager_file_update";
    }
	
	@RequestMapping(value = "/update/{idF}", method = RequestMethod.POST)
    public String updateFile(@PathVariable("idS") Integer idS, @PathVariable("idF") Integer idF, @RequestParam("f") CommonsMultipartFile f/*MultipartFile file*/, 
					@Valid @ModelAttribute("file") Attachement file,  BindingResult result, Model model, RedirectAttributes redirectAttributes) {
			
			if(result.hasErrors()) {
				model.addAttribute("sprint", sprintService.getSprintById(idS));
				model.addAttribute("file", attachementService.getAttachementById(idF));
				//Count Tasks
		        model.addAttribute("CountTasksCompleted", TaskService.getTasksCompleted(idS).size());
				model.addAttribute("CountTasksInprogress", TaskService.getTasksInprogress(idS).size());
				model.addAttribute("CountTasksPending", TaskService.getTasksPending(idS).size());
				return "dashboardmanager_file_update";
			}
					
			if (f != null && f.getSize() > 0) {
			
			file.setFilename(f.getOriginalFilename());
			file.setContenu(f.getBytes());
			file.setTypeContenu(f.getContentType());
			file.setSprint(sprintService.getSprintById(idS));
			file.setId_attachement(idF);
			attachementService.addAttechement(file);;
			
			} else if(f.getSize() == 0){
				model.addAttribute("sprint", sprintService.getSprintById(idS));
				model.addAttribute("file", attachementService.getAttachementById(idF));
				model.addAttribute("errorFileEmpty", "vous devez spécifier un document");
				return "dashboardmanager_file_update";
			
			}
			redirectAttributes.addFlashAttribute("succesMessage", "Opération bien effectuée");		
			return "redirect:/dashboard/"+idS+"/file/";
    }
	
	@RequestMapping(value = "/delete/{idF}", method = RequestMethod.GET)
	   public String deleteSprint(@PathVariable("idS") Integer idS, @PathVariable("idF") Integer idF, RedirectAttributes redirectAttributes, HttpSession session) {
		    attachementService.deleteAttachment(idF);
//				session.setAttribute("count_dashboardmanager", dashboardService.countDashboardManager());
		    redirectAttributes.addFlashAttribute("succesMessage", "Opération bien effectuée");
		    return "redirect:/dashboard/"+idS+"/file/";
  }

	@RequestMapping("/download/{idA}")
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
	
	/******************************************************************************
	this methode handling all request in case if request is not mapping in this controller 								  
    *******************************************************************************/
    @RequestMapping(method = RequestMethod.GET)
	public String defaultPage(@PathVariable("idS") Integer idS, Model model) {
        return "/dashboard/"+idS+"/file/";
    }
    
}
