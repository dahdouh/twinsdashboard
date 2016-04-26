package com.sqli.gfi.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
import com.sqli.gfi.service.ClientService;
import com.sqli.gfi.service.FicheClientService;
import com.sqli.gfi.service.ProjetService;
import com.sqli.gfi.service.SprintService;

@Controller
@RequestMapping("/dashboard/*")
public class DashBoardManagerController {
	
	@Autowired
    private ProjetService projetService;
	@Autowired
    private FicheClientService ficheClientService;
	@Autowired
    private ClientService clientService;
	@Autowired
    private SprintService sprintService;
	
	//________________________________________________________ Dashboard manager Home______________________________________________________//
    //_____________________________________________________________________________________________________________________________________//
	@RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
    public String indexDashboard(Model model) {
		model.addAttribute("fichesclient", ficheClientService.getAllFicheClient());
		
        return "index_dashboardmanager";
    }
	@RequestMapping(value ="/fiche", method = RequestMethod.GET)
    public String indexFiche(Model model) {
		model.addAttribute("fichesclient", ficheClientService.getAllFicheClient());
		
        return "index_fiche";
    }
	
	//_________________________________________________________ Fiche Client _________________________________________________________//
	//_____________________________________________________________________________________________________________________________________//
	@RequestMapping(value = "/fiche/add", method = RequestMethod.GET)
    public String addFicheClientPage(@ModelAttribute FicheClient ficheclient, Model model) {
        model.addAttribute("ficheclient", ficheclient);
        model.addAttribute("clients", clientService.getAllClients());
        return "dashboardmanager_ficheclient_add";
    }
	
	@RequestMapping(value = "/fiche/add", method = RequestMethod.POST)
	public String addFicheClient(@RequestParam(value="id_client", required = false) String id_client, @Valid @ModelAttribute("ficheclient") FicheClient ficheclient, BindingResult result, Model model, 
										RedirectAttributes redirectAttributes, HttpSession session) {		
			 if (result.hasErrors()) {
				    model.addAttribute("ficheclient", ficheclient);
			        model.addAttribute("clients", clientService.getAllClients());
					return "dashboardmanager_ficheclient_add";
			 } 
			Client client = clientService.getClientById(Integer.parseInt(id_client));			
			ficheclient.setClient(client);
			ficheClientService.addFicheclient(ficheclient);	
			session.setAttribute("count_fiche", ficheClientService.countFicheclient());
			redirectAttributes.addFlashAttribute("succesMessage", "Opération bien effectuée");
			return "redirect:/dashboard/fiche";		 		
	 }
	
	@RequestMapping(value = "/fiche/update/{idF}", method = RequestMethod.GET)
	 public String updateDashboardmanagerPgae( @PathVariable("idF") Integer idF, Model model) {
		  model.addAttribute("ficheclient", ficheClientService.getFicheclientById(idF));
		  model.addAttribute("clients", clientService.getAllClients());
		  return "dashboardmanager_ficheclient_update";
	}
	@RequestMapping(value = "/fiche/update/{idF}", method = RequestMethod.POST)
	public String updateDashboardmanager(@RequestParam(value="id_client", required = false) String id_client, @Valid @ModelAttribute("ficheclient") FicheClient ficheclient, BindingResult result, @PathVariable("idF") Integer idF, Model model, RedirectAttributes redirectAttributes) {
		 	if(result.hasErrors()) {		 		
	    		model.addAttribute("ficheclient", ficheClientService.getFicheclientById(idF));
	    		return "dashboardmanager_ficheclient_update";
	    	}
		 	ficheclient.setId_ficheClient(idF);
		 	Client client = clientService.getClientById(Integer.parseInt(id_client));			
			ficheclient.setClient(client);
			ficheClientService.addFicheclient(ficheclient);	
			redirectAttributes.addFlashAttribute("succesMessage", "Opération bien effectuée");
		    return "redirect:/dashboard/fiche";
	 }
	
	@RequestMapping(value = "/fiche/delete/{idF}", method = RequestMethod.GET)
    public String deleteDashboardmanager(@PathVariable("idF") Integer idF, RedirectAttributes redirectAttributes, HttpSession session) {
		Projet projet = projetService.getProjetByFicheClient(idF);
		    if(projet != null) {
		    		projet.setFicheClient(null);
		    		projetService.addProjet(projet);
		    }
			ficheClientService.deleteFicheclient(idF);
			session.setAttribute("count_fiche", ficheClientService.countFicheclient());
	    	redirectAttributes.addFlashAttribute("succesMessage", "Opération bien effectuée");
		    return "redirect:/dashboard/fiche";
	 }
	
	//_________________________________________________________ Project _________________________________________________________//
    //_____________________________________________________________________________________________________________________________________//
	@RequestMapping(value = "/{idF}/project/add", method = RequestMethod.GET)
	 public String indexProjetFichePage(@PathVariable("idF") Integer idF, @ModelAttribute Projet projet, Model model) {
		  FicheClient ficheclient = ficheClientService.getFicheclientById(idF);
		  projet.setFicheClient(ficheclient);
		  model.addAttribute("projet", projet);
		  return "dashboardmanager_projet_fiche_add";
	}
	
	@RequestMapping(value = "/{idF}/project/add", method = RequestMethod.POST)
	 public String indexProjetFiche(@PathVariable("idF") Integer idF, @Valid @ModelAttribute("projet") Projet projet, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
		 if(result.hasErrors()) {		 		
			  FicheClient ficheclient = ficheClientService.getFicheclientById(idF);
			  projet.setFicheClient(ficheclient);
			  model.addAttribute("projet", projet);
			  return "dashboardmanager_projet_fiche_add";
	    }
		  FicheClient ficheclient = ficheClientService.getFicheclientById(idF);
		  projet.setFicheClient(ficheclient);
		  projetService.addProjet(projet);
		  return "redirect:/dashboard/"+idF+"/project/detail"; 
		    
	}
	
	@RequestMapping(value = "/{idF}/project/detail", method = RequestMethod.GET)
	public String Projetdetails(@PathVariable("idF") Integer idF, Model model) {

		Projet projet = projetService.getProjetByFicheClient(idF);
		Date now = new Date();
		SimpleDateFormat formater = new SimpleDateFormat("hh:mm:s");
        Date dateProject =  projet.getDate_creation();
          Date datepassed = new Date(now.getTime() - projet.getDate_creation().getTime());
          model.addAttribute("datepassed", formater.format(datepassed));
		  model.addAttribute("projet", projet);
		//Count Sprints
	    model.addAttribute("CountTasksCompleted", sprintService.getSprintsCompleted(projet.getId_projet()).size());
		model.addAttribute("CountTasksInprogress", sprintService.getSprintsInprogress(projet.getId_projet()).size());
		model.addAttribute("CountTasksPending", sprintService.getSprintsPending(projet.getId_projet()).size());
	    return "dashboardmanager_projet_fiche_index";
		  
		 
		    
	}	
  //_______________________________________________________________________________________________________________________//
  //_______________________________________________________________________________________________________________________//
	
    public String addProjetPage(@ModelAttribute Projet projet) {
    	return "dashboardmanager_add";
    }
    
    /******************************************************************************
	this methode handling all request in case if request is not mapping in this controller 								  
    *******************************************************************************/
    @RequestMapping(method = RequestMethod.GET)
	public String defaultPage(Model model) {
        return "dashboardmanager_project_index";
    }

}
