package com.sqli.gfi.web;

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

import com.sqli.gfi.model.Sprint;
import com.sqli.gfi.service.ProjetService;
import com.sqli.gfi.service.SprintService;
import com.sqli.gfi.service.StatutService;
import com.sqli.gfi.service.TaskService;

@Controller
@RequestMapping("/dashboard/{idP}/sprint/*")
public class SprintController {
	
	@Autowired
    private SprintService sprintService;
	@Autowired
    private ProjetService projetService;
	@Autowired
    private StatutService statutService;
	@Autowired
    private TaskService TaskService;
	//________________________________________________________ Sprint Home______________________________________________________//
    //_____________________________________________________________________________________________________________________________________//
	
	@RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
    public String indexSprint(@PathVariable("idP") Integer idP, Model model) {
		model.addAttribute("idP", idP);
		model.addAttribute("idF", projetService.getProjetById(idP).getFicheClient().getId_ficheClient());
		model.addAttribute("sprints", sprintService.getAllSprint(idP));
		//Count Sprints
	    model.addAttribute("CountTasksCompleted", sprintService.getSprintsCompleted(idP).size());
		model.addAttribute("CountTasksInprogress", sprintService.getSprintsInprogress(idP).size());
		model.addAttribute("CountTasksPending", sprintService.getSprintsPending(idP).size());
        return "dashboardmanager_sprint_index";
    }
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addSprintPage(@PathVariable("idP") Integer idP, @ModelAttribute Sprint sprint, Model model) {
		model.addAttribute("idP", idP);
		model.addAttribute("idF", projetService.getProjetById(idP).getFicheClient().getId_ficheClient());
        model.addAttribute("sprint", sprint);
        model.addAttribute("statuts", statutService.getAllStatut());
        return "dashboardmanager_sprint_add";
    }
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addSprint(@RequestParam(value="id_statut", required = false) String id_statut, @PathVariable("idP") Integer idP, @Valid @ModelAttribute("sprint") Sprint sprint, BindingResult result, Model model, 
			RedirectAttributes redirectAttributes, HttpSession session) {
		if (result.hasErrors()) {
			model.addAttribute("idP", idP);
			model.addAttribute("idF", projetService.getProjetById(idP).getFicheClient().getId_ficheClient());
	        model.addAttribute("sprint", sprint);
	        model.addAttribute("statuts", statutService.getAllStatut());
			return "dashboardmanager_sprint_add";
		} 
				
		sprint.setStatut(statutService.getStatutById(Integer.parseInt(id_statut)));
		sprint.setProjet(projetService.getProjetById(idP));
		sprintService.addSprint(sprint);	
		redirectAttributes.addFlashAttribute("succesMessage", "Opération bien effectuée");
		return "redirect:/dashboard/"+idP+"/sprint/";
		
    }
	
	@RequestMapping(value = "/update/{idS}", method = RequestMethod.GET)
    public String updateSprintPage(@PathVariable("idS") Integer idS, @PathVariable("idP") Integer idP, @ModelAttribute Sprint sprint, Model model) {
		model.addAttribute("idP", idP);
		model.addAttribute("idF", projetService.getProjetById(idP).getFicheClient().getId_ficheClient());
        model.addAttribute("sprint", sprintService.getSprintById(idS));
        model.addAttribute("statuts", statutService.getAllStatut());
        return "dashboardmanager_sprint_update";
    }
	
	@RequestMapping(value = "/update/{idS}", method = RequestMethod.POST)
    public String updateSprint(@PathVariable("idS") Integer idS, @RequestParam(value="id_statut", required = false) String id_statut, @PathVariable("idP") Integer idP, @Valid @ModelAttribute("sprint") Sprint sprint, BindingResult result, Model model, 
			RedirectAttributes redirectAttributes, HttpSession session) {
		if (result.hasErrors()) {
			model.addAttribute("idP", idP);
			model.addAttribute("idF", projetService.getProjetById(idP).getFicheClient().getId_ficheClient());
	        model.addAttribute("sprint",  sprintService.getSprintById(idS));
	        model.addAttribute("statuts", statutService.getAllStatut());
			return "dashboardmanager_sprint_update";
		} 
				
		sprint.setStatut(statutService.getStatutById(Integer.parseInt(id_statut)));
		sprint.setProjet(projetService.getProjetById(idP));
		sprint.setId_sprint(idS);
		sprintService.addSprint(sprint);	
		redirectAttributes.addFlashAttribute("succesMessage", "Opération bien effectuée");
		return "redirect:/dashboard/"+idP+"/sprint/";
		
    }
	
	@RequestMapping(value = "/{idS}/detail", method = RequestMethod.GET)
	public String Projetdetails(@PathVariable("idS") Integer idS, @PathVariable("idP") Integer idP, Model model) {
		model.addAttribute("idP", idP);
		model.addAttribute("idF", projetService.getProjetById(idP).getFicheClient().getId_ficheClient());
		model.addAttribute("sprint", sprintService.getSprintById(idS));
		model.addAttribute("CountTasksCompleted", TaskService.getTasksCompleted(idS).size());
		model.addAttribute("CountTasksInprogress", TaskService.getTasksInprogress(idS).size());
		model.addAttribute("CountTasksPending", TaskService.getTasksPending(idS).size());
		return "dashboardmanager_sprint_detail"; 
		    
	}
	
	@RequestMapping(value = "/completed", method = RequestMethod.GET)
    public String SprintCompleted(@PathVariable("idP") Integer idP, Model model) {
		model.addAttribute("idP", idP);
		model.addAttribute("idF", projetService.getProjetById(idP).getFicheClient().getId_ficheClient());
		model.addAttribute("sprints", sprintService.getSprintsCompleted(idP));
		//Count Tasks
        model.addAttribute("CountTasksCompleted", sprintService.getSprintsCompleted(idP).size());
		model.addAttribute("CountTasksInprogress", sprintService.getSprintsInprogress(idP).size());
		model.addAttribute("CountTasksPending", sprintService.getSprintsPending(idP).size());
        return "dashboardmanager_sprint_completed";
    }
	
	@RequestMapping(value = "/inprogress", method = RequestMethod.GET)
    public String SprintInprogress(@PathVariable("idP") Integer idP, Model model) {
		model.addAttribute("idP", idP);
		model.addAttribute("idF", projetService.getProjetById(idP).getFicheClient().getId_ficheClient());
		model.addAttribute("sprints", sprintService.getSprintsInprogress(idP));
		//Count Tasks
        model.addAttribute("CountTasksCompleted", sprintService.getSprintsCompleted(idP).size());
		model.addAttribute("CountTasksInprogress", sprintService.getSprintsInprogress(idP).size());
		model.addAttribute("CountTasksPending", sprintService.getSprintsPending(idP).size());
        return "dashboardmanager_sprint_inprogress";
    }
	
	@RequestMapping(value = "/pending", method = RequestMethod.GET)
    public String SprintPending(@PathVariable("idP") Integer idP, Model model) {
		model.addAttribute("idP", idP);
		model.addAttribute("idF", projetService.getProjetById(idP).getFicheClient().getId_ficheClient());
		model.addAttribute("sprints", sprintService.getSprintsPending(idP));
		//Count Tasks
        model.addAttribute("CountTasksCompleted", sprintService.getSprintsCompleted(idP).size());
		model.addAttribute("CountTasksInprogress", sprintService.getSprintsInprogress(idP).size());
		model.addAttribute("CountTasksPending", sprintService.getSprintsPending(idP).size());
        return "dashboardmanager_sprint_pending";
    }
	
//	@RequestMapping(value = "/delete/{idS}", method = RequestMethod.GET)
//    public String deleteSprint(@PathVariable("idS") Integer idS, @PathVariable("idP") Integer idP, RedirectAttributes redirectAttributes, HttpSession session) {
//		Sprint sprint = sprintService.getSprintById(idS);
//		    if(sprint != null) {
//		    		projet.setFicheClient(null);
//		    		projetService.addProjet(projet);
//		    }
//			sprintService.deleteSprint(idFS;
////			session.setAttribute("count_dashboardmanager", dashboardService.countDashboardManager());
//	    	redirectAttributes.addFlashAttribute("succesMessage", "Opération bien effectuée");
//		    return "redirect:/dashboard/"+idP+"/sprint/";
//	 }

}
