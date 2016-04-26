package com.sqli.gfi.web;

import java.util.Set;

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

import com.sqli.gfi.model.Evenement;
import com.sqli.gfi.model.Utilisateur;
import com.sqli.gfi.service.EventService;
import com.sqli.gfi.service.MailSenderService;
import com.sqli.gfi.service.ProjetService;
import com.sqli.gfi.service.UtilisateurService;

@Controller
@RequestMapping("/dashboard/*")
public class EvenementController {
	@Autowired
	private EventService eventService;
	@Autowired
    private ProjetService projetService;
	@Autowired
	private UtilisateurService utilisateurService;
	@Autowired
	private MailSenderService  mailSenderService;
	
	@RequestMapping(value = {"/event","event/index"}, method = RequestMethod.GET)
    public String indexEvent(Model model) {
		model.addAttribute("events", eventService.getAllEvents());
        return "dashboardmanager_event_index";
    }
	
	@RequestMapping(value = "/event/add", method = RequestMethod.GET)
    public String addEventPage(@ModelAttribute Evenement event, Model model) {
		model.addAttribute("event", event);
		model.addAttribute("projets", projetService.getAllProjets());
        return "dashboardmanager_event_add";
    }
	
	@RequestMapping(value = "/event/add", method = RequestMethod.POST)
    public String addEvent(@RequestParam(value="id_projet", required = false) String id_projet,@Valid @ModelAttribute("event") Evenement event, BindingResult result, Model model,
    						RedirectAttributes redirectAttributes, HttpSession session) {        
        if (result.hasErrors()) {
        	model.addAttribute("event", event);
    		model.addAttribute("projets", projetService.getAllProjets());
            return "dashboardmanager_event_add";
		} 		
		event.setProjet(projetService.getProjetById(Integer.parseInt(id_projet)));
		eventService.addEvent(event);	
		session.setAttribute("count_event", eventService.countEvent()); 
		redirectAttributes.addFlashAttribute("succesMessage", "Opération bien effectuée");
		return "redirect:/dashboard/event";
    }
	
	@RequestMapping(value = "/event/update/{idE}", method = RequestMethod.GET)
    public String updateEventPage(@PathVariable("idE") Integer idE, @ModelAttribute Evenement event, Model model) {
        model.addAttribute("event", eventService.getEventById(idE));
        model.addAttribute("projets", projetService.getAllProjets());
        return "dashboardmanager_event_update";
    }
	
	@RequestMapping(value = "/event/update/{idE}", method = RequestMethod.POST)
    public String updateEvent(@PathVariable("idE") Integer idE, @RequestParam(value="id_projet", required = false) String id_projet,@Valid @ModelAttribute("event") Evenement event, BindingResult result, Model model,
    						RedirectAttributes redirectAttributes, HttpSession session) {        
        if (result.hasErrors()) {
        	model.addAttribute("event", eventService.getEventById(idE));
            model.addAttribute("projets", projetService.getAllProjets());
            return "dashboardmanager_event_update";
		} 		
		event.setProjet(projetService.getProjetById(Integer.parseInt(id_projet)));
		event.setId_evenement(idE);
		eventService.addEvent(event);	
		redirectAttributes.addFlashAttribute("succesMessage", "Opération bien effectuée");
		return "redirect:/dashboard/event";
    }

	@RequestMapping(value = "/event/delete/{idE}", method = RequestMethod.GET)
	  public String deleteSprint(@PathVariable("idE") Integer idE, RedirectAttributes redirectAttributes, HttpSession session) {
		    eventService.deleteEvent(idE);
		    session.setAttribute("count_event", eventService.countEvent()); 
		    redirectAttributes.addFlashAttribute("succesMessage", "Opération bien effectuée");
		    return "redirect:/dashboard/event";
	}
	
	@RequestMapping(value = "/event/invite/{idE}", method = RequestMethod.GET)
    public String inviteEventPage(@PathVariable("idE") Integer idE, Model model) {
		model.addAttribute("users", utilisateurService.getAlluserNotInvited(idE));
		model.addAttribute("idE", idE);
        return "dashboardmanager_event_invite";
    }
	
	@RequestMapping(value = "/event/invite/{idE}", method = RequestMethod.POST)
    public String inviteEvent(@PathVariable("idE") Integer idE, @RequestParam(value="checkBox_invite_users", required = false) Integer [] checkBox_invite_users, Model model,
    						  HttpSession session, RedirectAttributes redirectAttributes) {
		
		if(checkBox_invite_users==null) {
			model.addAttribute("users", utilisateurService.getAlluserNotInvited(idE));
			model.addAttribute("idE", idE);
			model.addAttribute("msgError", "Veuillez choisir les personnes à invitées");
	        return "dashboardmanager_event_invite";
		 }	

		 for(Integer id_u : checkBox_invite_users)
		 {
			    Evenement event_invite = eventService.getEventById(idE);
			 	Set<Utilisateur> invitations = event_invite.getInvitations();
			 	Utilisateur user = utilisateurService.getUtilisateurById(id_u);
			    invitations.add(user);
			    event_invite.setInvitations(invitations);
			    mailSenderService.sendInvitation(user, event_invite);
				eventService.addEvent(event_invite);
				
		 }	 
		redirectAttributes.addFlashAttribute("succesMessage", "Opération bien effectuée");
		return "redirect:/dashboard/event";
    }
	
	//___________________________________________________ Project Event ____________________________________________//
    //____________________________________________________________________________________________________________________//
	
	@RequestMapping(value = "{idP}/event/all", method = RequestMethod.GET)
    public String indexEventProject(@PathVariable("idP") Integer idP, Model model) {
		model.addAttribute("projet", eventService.getEventsByIdProject(idP));
        return "dashboardmanager_event_project_index";
    }
	
}
