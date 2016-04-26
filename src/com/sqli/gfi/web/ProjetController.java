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

import com.sqli.gfi.model.Client;
import com.sqli.gfi.model.FicheClient;
import com.sqli.gfi.model.Projet;
import com.sqli.gfi.model.Task;
import com.sqli.gfi.service.ClientService;
import com.sqli.gfi.service.ProjetService;

@Controller
@RequestMapping("/dashboard/project/*")
public class ProjetController {
	
	@Autowired
    private ProjetService projetService;
	@Autowired
    private ClientService clientService;
	
	// ________________________________________________  Projet ____________________________________________//
	//______________________________________________________________________________________________________//
	
	@RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
    public String indexProject(Model model) {
		model.addAttribute("projects", projetService.getAllProjets());
        return "dashboardmanager_project_index";
    }

	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addProjectPage(@ModelAttribute Projet projet, Model model) {
        model.addAttribute("projet", projet);
        return "dashboardmanager_project_add";
    }
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addProject(@Valid @ModelAttribute("projet") Projet projet, BindingResult result, Model model, 
    						 HttpSession session, RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {		 		
			model.addAttribute("projet", projet);
	        return "dashboardmanager_project_add";
	    }
		  projetService.addProjet(projet);
		  session.setAttribute("count_projet", projetService.countProjet());
		  return "redirect:/dashboard/project/";
    }
	
	@RequestMapping(value = "/update/{idP}", method = RequestMethod.GET)
    public String udpateProjectPage(@PathVariable("idP") Integer idP, @ModelAttribute Projet projet, Model model) {
        model.addAttribute("projet", projetService.getProjetById(idP));
        return "dashboardmanager_project_update";
    }
	
	@RequestMapping(value = "/update/{idP}", method = RequestMethod.POST)
    public String udpateProject(@PathVariable("idP") Integer idP, @Valid @ModelAttribute("projet") Projet projet, BindingResult result, Model model, 
							 RedirectAttributes redirectAttributes, HttpSession session) {
		if (result.hasErrors()) {
			model.addAttribute("projet", projetService.getProjetById(idP));
	        return "dashboardmanager_project_update";
		} 
				
		projet.setId_projet(idP);
		projet.setFicheClient(projetService.getProjetById(idP).getFicheClient());
		projetService.addProjet(projet);	
		redirectAttributes.addFlashAttribute("succesMessage", "Opération bien effectuée");
		return "redirect:/dashboard/project/";
    }
	
	@RequestMapping(value = "/delete/{idP}", method = RequestMethod.GET)
	public String deleteSprint(@PathVariable("idP") Integer idP, RedirectAttributes redirectAttributes, HttpSession session) {
		    projetService.deleteProjet(idP);
		    session.setAttribute("count_projet", projetService.countProjet());
		    redirectAttributes.addFlashAttribute("succesMessage", "Opération bien effectuée");
		    return "redirect:/dashboard/project/";
   }

	// _____________________________________________  Fiche Client _________________________________________//
	//______________________________________________________________________________________________________//
	
	@RequestMapping(value = "/{idP}/fiche/add", method = RequestMethod.GET)
	 public String addProjetFichePage(@PathVariable("idP") Integer idP, @ModelAttribute FicheClient ficheclient, Model model) {
		  Projet projet = projetService.getProjetById(idP);
		  ficheclient.setProjet(projet);
		  model.addAttribute("ficheclient", ficheclient);
		  model.addAttribute("clients", clientService.getAllClients());
		  return "dashboardmanager_project_f_add";
	}
	
	@RequestMapping(value = "/{idP}/fiche/add", method = RequestMethod.POST)
	public String addProjetFiche(@PathVariable("idP") Integer idP, @RequestParam(value="id_client", required = false) String id_client, 
								@Valid @ModelAttribute("ficheclient") FicheClient ficheclient, BindingResult result, Model model, 
								RedirectAttributes redirectAttributes, HttpSession session) {		
			 if (result.hasErrors()) {
				  Projet projet = projetService.getProjetById(idP);
				  ficheclient.setProjet(projet);
				  model.addAttribute("ficheclient", ficheclient);
				  model.addAttribute("clients", clientService.getAllClients());
				  return "dashboardmanager_project_f_add";
			 } 
			Client client = clientService.getClientById(Integer.parseInt(id_client));			
			ficheclient.setClient(client);
			Projet projet = projetService.getProjetById(idP);
			projet.setFicheClient(ficheclient);
			projetService.addProjet(projet);
			redirectAttributes.addFlashAttribute("succesMessage", "Opération bien effectuée");
			return "redirect:/dashboard/project/";		 		
	 }
}
