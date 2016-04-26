package com.sqli.gfi.web;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
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

import com.sqli.gfi.model.ChefProjet;
import com.sqli.gfi.model.Client;
import com.sqli.gfi.model.DashboardManager;
import com.sqli.gfi.model.MembreEquipe;
import com.sqli.gfi.model.Profil;
import com.sqli.gfi.service.ChefprojetService;
import com.sqli.gfi.service.ClientService;
import com.sqli.gfi.service.DashboardService;
import com.sqli.gfi.service.EquipeService;
import com.sqli.gfi.service.ProfileService;


@Controller
@RequestMapping("/admin/*")
public class AdminController {
	@Autowired
    private DashboardService dashboardService;
	@Autowired
    private ChefprojetService chefprojetService;
	@Autowired
    private EquipeService equipeService;
	@Autowired
    private ClientService clientService;
	@Autowired
    private ProfileService profileService;
	
	
	@RequestMapping(value = {"/","/dashboard","/dashboard/index"}, method = RequestMethod.GET)
    public String indexDashboard(Model model) {
//		List<DashboardManager> dashboardmanagers = dashboardService.getAllDashboardManager();
//        model.addAttribute("dashboardmanagers", dashboardmanagers);
//        model.addAttribute("search_criteria_list",search_criteria());
        return "admin_dashboard";
    }
	
	//_________________________________________________________ Dashboard Manager _________________________________________________________//
	//_____________________________________________________________________________________________________________________________________//
	@RequestMapping(value = {"/dashboardmanager","/dashboardmanager/index"}, method = RequestMethod.GET)
    public String indexDashboardMnager(Model model) {
		List<DashboardManager> dashboardmanagers = dashboardService.getAllDashboardManager();
        model.addAttribute("dashboardmanagers", dashboardmanagers);
        model.addAttribute("search_criteria_list",search_criteria());
        return "admin_dashboardmanager_index";
    }
	
	private Map<String,String>  search_criteria() {
    	Map<String,String> search_criteria = new LinkedHashMap<String,String>();
    	search_criteria.put("nom", "nom");
    	search_criteria.put("prenom", "prenom");
    	search_criteria.put("email", "email");
    	search_criteria.put("tel", "tel");
    	search_criteria.put("adresse", "adresse");
    	return search_criteria;
	}
	
	@RequestMapping(value = "/dashboardmanager/search", method = RequestMethod.POST)
    public String searchDashboardManager(@RequestParam(value="criteria", required = false) String criteria, @RequestParam(value="libelle", required = false) String libelle, HttpServletRequest req, Model model) {

    	if(criteria == ""){
    		model.addAttribute("msgError", " veuillez selectionner un critère");
    		model.addAttribute("search_criteria_list", search_criteria()); 
        	model.addAttribute("dashboardmanagers", dashboardService.getAllDashboardManager());
    		return "admin_dashboardmanager_index";
    	} else {
	    	model.addAttribute("search_criteria_list", search_criteria()); 
	    	model.addAttribute("dashboardmanagers", dashboardService.getDashboardManagersByCritere(criteria, libelle));
	    	return "admin_dashboardmanager_index";
    	}
    }
	
	@RequestMapping(value = "/dashboardmanager/add", method = RequestMethod.GET)
	public String addDahsboardmanagerPage(@ModelAttribute DashboardManager dashboardmanager, Model model) {
		  model.addAttribute("dashboardmanager", dashboardmanager);
	   	return "admin_dashboardmanager_add";
	}
	 
	@RequestMapping(value = "/dashboardmanager/add", method = RequestMethod.POST)
	public String addDahsboardmanager(@Valid @ModelAttribute("dashboardmanager") DashboardManager dashboardmanager, BindingResult result, Model model, 
										RedirectAttributes redirectAttributes, HttpSession session) {
		  if (result.hasErrors()) {
			    model.addAttribute("dashboardmanager", dashboardmanager);
				return "admin_dashboardmanager_add";
			} 
		  		Profil profil = profileService.getByProfilById(1);
		  		dashboardmanager.setProfil(profil);
		  		dashboardService.addDashboardManager(dashboardmanager);		
		  		session.setAttribute("count_dashboardmanager", dashboardService.countDashboardManager());
			    redirectAttributes.addFlashAttribute("succesMessage", "Opération bien effectuée");
				return "redirect:index";		 		
	 }

	 @RequestMapping(value = "/dashboardmanager/update/{idD}", method = RequestMethod.GET)
	 public String updateDashboardmanagerPgae( @PathVariable("idD") Integer idD, Model model) {
		  model.addAttribute("dashboardmanager", dashboardService.getDashboardManagerById(idD));;
		  return "admin_dashboardmanager_update";
	 }
	 @RequestMapping(value = "/dashboardmanager/update/{idD}", method = RequestMethod.POST)
	public String updateDashboardmanager(@Valid @ModelAttribute("dashboardmanager") DashboardManager dashboardmanager, BindingResult result, @PathVariable("idD") Integer idD, Model model, RedirectAttributes redirectAttributes) {
		 	if(result.hasErrors()) {		 		
	    		model.addAttribute("dashboardmanager", dashboardService.getDashboardManagerById(idD));
	    		return "admin_dashboardmanager_update";
	    	}
		 	dashboardmanager.setId_u(idD);
		 	Profil profil = profileService.getByProfilById(1);
	  		dashboardmanager.setProfil(profil);
		 	dashboardService.addDashboardManager(dashboardmanager);
	      	redirectAttributes.addFlashAttribute("succesMessage", "Opération bien effectuée");
		    return "redirect:/admin/dashboardmanager/index";
	 }
	  
	@RequestMapping(value = "/dashboardmanager/delete/{idD}", method = RequestMethod.GET)
     public String deleteDashboardmanager(@PathVariable("idD") Integer idD, RedirectAttributes redirectAttributes, HttpSession session) {
			dashboardService.deleteDashboardManager(idD);
			session.setAttribute("count_dashboardmanager", dashboardService.countDashboardManager());
	    	redirectAttributes.addFlashAttribute("succesMessage", "Opération bien effectuée");
		    return "redirect:/admin/dashboardmanager/index";
	 }
	  
	//_________________________________________________________ Chefs Projets _________________________________________________________//
	//_____________________________________________________________________________________________________________________________________//
		@RequestMapping(value = {"/chefprojet","/chefprojet/index"}, method = RequestMethod.GET)
	    public String indexChefprojet(Model model) {
	        model.addAttribute("chefprojets", chefprojetService.getAllChefprojets());
	        model.addAttribute("search_criteria_list",search_criteria());
	        return "admin_chefprojet_index";
	    }
		
		@RequestMapping(value = "/chefprojet/search", method = RequestMethod.POST)
	    public String searchChefprojet(@RequestParam(value="criteria", required = false) String criteria, @RequestParam(value="libelle", required = false) String libelle, HttpServletRequest req, Model model) {

	    	if(criteria == ""){
	    		model.addAttribute("msgError", "veuillez selectionner un critère");
	    		model.addAttribute("search_criteria_list", search_criteria()); 
	        	model.addAttribute("chefprojets", chefprojetService.getAllChefprojets());
	    		return "admin_chefprojet_index";
	    	} else {
		    	model.addAttribute("search_criteria_list", search_criteria()); 
		    	model.addAttribute("chefprojets", chefprojetService.getChefprojetByCriteria(criteria, libelle));
		    	return "admin_chefprojet_index";
	    	}
	    }
		
		@RequestMapping(value = "/chefprojet/add", method = RequestMethod.GET)
		public String addChefprojetPage(@ModelAttribute ChefProjet chefprojet, Model model) {
			  model.addAttribute("chefprojet", chefprojet);
		   	return "admin_chefprojet_add";
		}
		 
		@RequestMapping(value = "/chefprojet/add", method = RequestMethod.POST)
		public String addChefprojet(@Valid @ModelAttribute("chefprojet") ChefProjet chefprojet, BindingResult result, Model model, 
									RedirectAttributes redirectAttributes, HttpSession session) {
			  if (result.hasErrors()) {
				    model.addAttribute("chefprojet", chefprojet);
					return "admin_chefprojet_add";
				} 
					Profil profil = profileService.getByProfilById(2);
					chefprojet.setProfil(profil);
			  		chefprojetService.addChefprojets(chefprojet);
			  		session.setAttribute("count_chefprojet", chefprojetService.countChefprojet());
				    redirectAttributes.addFlashAttribute("succesMessage", "Opération bien effectuée");
				    return "redirect:/admin/chefprojet/index";		 		
		}
		
		@RequestMapping(value = "/chefprojet/update/{idC}", method = RequestMethod.GET)
		 public String updateChefprojetPage( @PathVariable("idC") Integer idC, Model model) {
			  model.addAttribute("chefprojet", chefprojetService.getChefprojetById(idC));
			  return "admin_chefprojet_update";
		 }
		@RequestMapping(value = "/chefprojet/update/{idC}", method = RequestMethod.POST)
		public String updateChefprojet(@Valid @ModelAttribute("chefprojet") ChefProjet chefprojet, BindingResult result, @PathVariable("idC") Integer idC, 
										Model model, RedirectAttributes redirectAttributes, HttpSession session) {
			 	if(result.hasErrors()) {		 		
		    		model.addAttribute("chefprojet", chefprojetService.getChefprojetById(idC));
		    		return "admin_chefprojet_update";
		    	}
			 	chefprojet.setId_u(idC);
			 	Profil profil = profileService.getByProfilById(2);
				chefprojet.setProfil(profil);
			 	chefprojetService.addChefprojets(chefprojet);
		      	redirectAttributes.addFlashAttribute("succesMessage", "Opération bien effectuée");
			    return "redirect:/admin/chefprojet/index";
		 }
		
		@RequestMapping(value = "/chefprojet/delete/{idC}", method = RequestMethod.GET)
	     public String deleteChefprojet(@PathVariable("idC") Integer idC, RedirectAttributes redirectAttributes, HttpSession session) {
				chefprojetService.deleteChef(idC);
				session.setAttribute("count_chefprojet", chefprojetService.countChefprojet()); 
		    	redirectAttributes.addFlashAttribute("succesMessage", "Opération bien effectuée");
			    return "redirect:/admin/chefprojet/index";
		 }
		
		//_________________________________________________________ 	Membre Equipe  _________________________________________________________//
		//_____________________________________________________________________________________________________________________________________//
			
		@RequestMapping(value = {"/teamember","/teamember/index"}, method = RequestMethod.GET)
		public String indexMembre(Model model) {
		        model.addAttribute("teamembers", equipeService.getAllMembreEquipe());
		        model.addAttribute("search_criteria_list",search_criteria());
		        return "admin_equipe_index";
		}
		
		@RequestMapping(value = "/teamember/search", method = RequestMethod.POST)
	    public String searchmemberEquipe(@RequestParam(value="criteria", required = false) String criteria, @RequestParam(value="libelle", required = false) String libelle, HttpServletRequest req, Model model) {

	    	if(criteria == ""){
	    		model.addAttribute("msgError", "veuillez selectionner un critère");
	    		model.addAttribute("search_criteria_list", search_criteria());
	        	model.addAttribute("teamembers",equipeService.getAllMembreEquipe());
	    		return "admin_equipe_index";
	    	} else {
		    	model.addAttribute("search_criteria_list", search_criteria()); 
		    	model.addAttribute("teamembers", equipeService.getmembresEquipeByCriteria(criteria, libelle));
		    	return "admin_equipe_index";
	    	}
	    }
		
		@RequestMapping(value = "/teamember/add", method = RequestMethod.GET)
		public String addTeamMemberPage(@ModelAttribute MembreEquipe teamember, Model model) {
			  model.addAttribute("teamember", teamember);
		   	return "admin_equipe_add";
		}
		 
		@RequestMapping(value = "/teamember/add", method = RequestMethod.POST)
		public String addTeamMember(@Valid @ModelAttribute("teamember") MembreEquipe teamember, BindingResult result, Model model, 
									RedirectAttributes redirectAttributes, HttpSession session) {
			  if (result.hasErrors()) {
				    model.addAttribute("teamember", teamember);
					return "admin_equipe_add";
				} 
			  		Profil profil = profileService.getByProfilById(3);
			  		teamember.setProfil(profil);
			  		equipeService.addmembreEquipe(teamember);
			  		session.setAttribute("count_membre_equipe", equipeService.countmembreEquipe());
				    redirectAttributes.addFlashAttribute("succesMessage", "Opération bien effectuée");
				    return "redirect:/admin/teamember/index";		 		
		}
		
		@RequestMapping(value = "/teamember/update/{idM}", method = RequestMethod.GET)
		 public String updateTeamMemberPage( @PathVariable("idM") Integer idM, Model model) {
			  model.addAttribute("teamember", equipeService.getmembreEquipeById(idM));
			  return "admin_equipe_update";
		}
		
		@RequestMapping(value = "/teamember/update/{idM}", method = RequestMethod.POST)
		public String updateTeamMember(@Valid @ModelAttribute("teamember") MembreEquipe teamember, BindingResult result, @PathVariable("idM") Integer idM, Model model, RedirectAttributes redirectAttributes) {
			 	if(result.hasErrors()) {		 		
		    		model.addAttribute("teamember", equipeService.getmembreEquipeById(idM));
		    		return "admin_equipe_update";
		    	}
			 	teamember.setId_u(idM);
			 	Profil profil = profileService.getByProfilById(3);
		  		teamember.setProfil(profil);
			 	equipeService.addmembreEquipe(teamember);
		      	redirectAttributes.addFlashAttribute("succesMessage", "Opération bien effectuée");
			    return "redirect:/admin/teamember/index";
		}
		
		@RequestMapping(value = "/teamember/delete/{idM}", method = RequestMethod.GET)
	    public String deleteTeamMember(@PathVariable("idM") Integer idM, RedirectAttributes redirectAttributes, HttpSession session) {
				equipeService.deletemembreEquipe(idM);
				session.setAttribute("count_membre_equipe", equipeService.countmembreEquipe()); 
		    	redirectAttributes.addFlashAttribute("succesMessage", "Opération bien effectuée");
			    return "redirect:/admin/teamember/index";
		 }
		
		//_________________________________________________________ 	Client_________________________________________________________________//
		//_____________________________________________________________________________________________________________________________________//
		
		private Map<String,String>  search_criteria_client() {
	    	Map<String,String> search_criteria = new LinkedHashMap<String,String>();
	    	search_criteria.put("nom", "nom");
	    	search_criteria.put("prenom", "prenom");
	    	search_criteria.put("email", "email");
	    	search_criteria.put("tel", "tel");
	    	search_criteria.put("adresse", "adresse");
	    	search_criteria.put("societe", "societe");
	    	return search_criteria;
		}
		
		@RequestMapping(value = {"/client","/client/index"}, method = RequestMethod.GET)
		public String indexClient(Model model) {
		        model.addAttribute("clients", clientService.getAllClients());
		        model.addAttribute("search_criteria_list",search_criteria_client());
		        return "admin_client_index";
		}
		
		@RequestMapping(value = "/client/search", method = RequestMethod.POST)
	    public String searchClient(@RequestParam(value="criteria", required = false) String criteria, @RequestParam(value="libelle", required = false) String libelle, HttpServletRequest req, Model model) {

	    	if(criteria == ""){
	    		model.addAttribute("msgError", "veuillez selectionner un critère");
	    		model.addAttribute("clients",clientService.getAllClients());
	    		model.addAttribute("search_criteria_list", search_criteria_client());
	    		return "admin_client_index";
	    	} else {
	    		model.addAttribute("clients", clientService.getClientByCriteria(criteria, libelle));
		    	model.addAttribute("search_criteria_list", search_criteria_client()); 
		    	return "admin_client_index";
	    	}
	    }
		
		@RequestMapping(value = "/client/add", method = RequestMethod.GET)
		public String addClientPage(@ModelAttribute Client client, Model model) {
			  model.addAttribute("client", client);
		   	return "admin_client_add";
		}
		 
		@RequestMapping(value = "/client/add", method = RequestMethod.POST)
		public String addClient(@Valid @ModelAttribute("client") Client client, BindingResult result, Model model, 
									RedirectAttributes redirectAttributes, HttpSession session) {
			  if (result.hasErrors()) {
				    model.addAttribute("client", client);
					return "admin_client_add";
				} 
				  	Profil profil = profileService.getByProfilById(4);
				  	client.setProfil(profil);
			  		clientService.addClient(client);
			  		session.setAttribute("count_client", clientService.countClient());
				    redirectAttributes.addFlashAttribute("succesMessage", "Opération bien effectuée");
				    return "redirect:/admin/client/index";		 		
		}
		
		@RequestMapping(value = "/client/update/{idC}", method = RequestMethod.GET)
		 public String updateClientPage( @PathVariable("idC") Integer idC, Model model) {
			  model.addAttribute("client", clientService.getClientById(idC));
			  return "admin_client_update";
		}
		
		@RequestMapping(value = "/client/update/{idC}", method = RequestMethod.POST)
		public String updateClient(@Valid @ModelAttribute("client") Client client, BindingResult result, @PathVariable("idC") Integer idC, Model model, RedirectAttributes redirectAttributes) {
			 	if(result.hasErrors()) {		 		
		    		model.addAttribute("client", equipeService.getmembreEquipeById(idC));
		    		return "admin_client_update";
		    	}
			 	client.setId_u(idC);
			 	Profil profil = profileService.getByProfilById(4);
			  	client.setProfil(profil);
			 	clientService.addClient(client);
		      	redirectAttributes.addFlashAttribute("succesMessage", "Opération bien effectuée");
			    return "redirect:/admin/client/index";
		}
		
		@RequestMapping(value = "/client/delete/{idC}", method = RequestMethod.GET)
	    public String deleteClient(@PathVariable("idC") Integer idC, RedirectAttributes redirectAttributes, HttpSession session) {
				clientService.deleteClient(idC);
				session.setAttribute("count_client", clientService.countClient()); 
		    	redirectAttributes.addFlashAttribute("succesMessage", "Opération bien effectuée");
			    return "redirect:/admin/client/index";
		 }


		
		
	
}
