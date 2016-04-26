package com.sqli.gfi.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sqli.gfi.model.ChefProjet;
import com.sqli.gfi.model.Projet;
import com.sqli.gfi.model.Utilisateur;
import com.sqli.gfi.service.ChefprojetService;
import com.sqli.gfi.service.EquipeService;
import com.sqli.gfi.service.EventService;
import com.sqli.gfi.service.MailSenderService;
import com.sqli.gfi.service.ProjetService;
import com.sqli.gfi.service.SprintService;


@Controller
@RequestMapping("/client/*")
public class ClientController {
	
	@Autowired
    private ProjetService projetService;
	@Autowired
    private SprintService sprintService;
	@Autowired
    private EventService eventService;
	@Autowired
    private EquipeService equipeService;
	@Autowired
    private ChefprojetService chefprojetService;
	@Autowired
	private MailSenderService  mailSenderService;
	
	
	@RequestMapping(value = {"/", "/index", "/project"}, method = RequestMethod.GET)
    public String indexProjectTeamMember(Model model, HttpSession session) {
		model.addAttribute("projects", projetService.getProjetByIdClient(((Utilisateur)session.getAttribute("user_logged_in")).getId_u()));
        return "client_project_index";
    }
	
	@RequestMapping(value = "/event", method = RequestMethod.GET)
    public String indexEventTeamMember(Model model, HttpSession session) {
		model.addAttribute("events", eventService.getEventsByIdTeamMember(((Utilisateur)session.getAttribute("user_logged_in")).getId_u()));
        return "client_event_index";
    }
	
	@RequestMapping(value = "/invited/{idC}", method = RequestMethod.GET)
    public String Personinvited(@PathVariable("idC") Integer idC, Model model, HttpSession session) {
		model.addAttribute("users", eventService.getUserInvited(idC));
        return "client_event_invited";
    }
	
	@RequestMapping(value = "/{idC}/team/", method = RequestMethod.GET)
    public String teamProjectClient(@PathVariable("idC") Integer idC, Model model, HttpSession session) {
		model.addAttribute("projets", equipeService.getTeamsByIdClient(idC)); 
        return "client_equipe_index";
    }
	
	@RequestMapping(value = "/team/{idT}/member", method = RequestMethod.GET)
    public String teamember(@PathVariable("idT") Integer idT, Model model) {
		model.addAttribute("members", equipeService.getUsersByIdTeam(idT));
		model.addAttribute("equipe", equipeService.getTeamById(idT));
        return "client_equipe_member";
    }
	
	@RequestMapping(value = "/correspondence", method = RequestMethod.GET)
    public String correspondenceChefProjetPage(@ModelAttribute Utilisateur chefprojet, Model model, HttpSession session) {
		model.addAttribute("chefprojet", chefprojet);
		model.addAttribute("chefs", projetService.getAllChefProjetClient(((Utilisateur)session.getAttribute("user_logged_in")).getId_u()));
        return "client_correspondence";
    }
	
	@RequestMapping(value = "/correspondence", method = RequestMethod.POST)
    public String correspondenceChefProjet(@RequestParam(value="id_chefprojet", required = false) String id_chefprojet, 
    									   @RequestParam(value="message", required = false) String message,
    									   Model model, RedirectAttributes redirectAttributes, HttpSession session) {
		
		ChefProjet chefprojet = chefprojetService.getChefprojetById(Integer.parseInt(id_chefprojet));
		
		// envoyer le login et mot de passe au utilisateur 			
		mailSenderService.correspondance(chefprojet, message);
		redirectAttributes.addFlashAttribute("succesMessage", "Message à bien été envoyé");
        return "redirect:/client/correspondence";
    }
	
	@RequestMapping(value = "/progress", method = RequestMethod.GET)
    public String ProjectsProgress(@ModelAttribute Utilisateur chefprojet, Model model, HttpSession session) {
		model.addAttribute("sprint1", 43.0);
		model.addAttribute("projects", projetService.getProjetByIdClient(((Utilisateur)session.getAttribute("user_logged_in")).getId_u()));		
		model.addAttribute("chefs", projetService.getAllChefProjetClient(((Utilisateur)session.getAttribute("user_logged_in")).getId_u()));
        return "client_progress_project";
    }
	
	@RequestMapping(value = "/progress/{idP}", method = RequestMethod.GET)
    public String statSprintProgress(@PathVariable("idP") Integer idP, Model model, HttpSession session) {
		model.addAttribute("CountSprints", sprintService.getSprints(idP).size());

		model.addAttribute("sprints", sprintService.getAllSprint(idP));
		model.addAttribute("projet", projetService.getProjetById(idP).getNom());
		model.addAttribute("CountSprintsCompleted", sprintService.getSprintsCompleted(idP).size());
		model.addAttribute("CountSprintsInprogress", sprintService.getSprintsInprogress(idP).size());
		model.addAttribute("CountSprintsPending", sprintService.getSprintsPending(idP).size());
		
		model.addAttribute("chefs", projetService.getAllChefProjetClient(((Utilisateur)session.getAttribute("user_logged_in")).getId_u()));
        return "client_progress_sprint";
    }
	
	
}
