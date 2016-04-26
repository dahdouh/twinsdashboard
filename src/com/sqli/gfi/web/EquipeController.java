package com.sqli.gfi.web;

import java.util.Date;
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

import com.sqli.gfi.model.Equipe;
import com.sqli.gfi.model.Projet;
import com.sqli.gfi.model.Utilisateur;
import com.sqli.gfi.service.EquipeService;
import com.sqli.gfi.service.ProjetService;
import com.sqli.gfi.service.SprintService;
import com.sqli.gfi.service.UtilisateurService;

@Controller
@RequestMapping("/dashboard/*")
public class EquipeController {
	@Autowired
    private EquipeService equipeService;
	@Autowired
    private ProjetService projetService;
	@Autowired
	private UtilisateurService utilisateurService;
	@Autowired
    private SprintService sprintService;
	
	//________________________________________________________ Team ______________________________________________________//
    //____________________________________________________________________________________________________________________//
	
	@RequestMapping(value = {"/team","team/index"}, method = RequestMethod.GET)
    public String indexEquipe(Model model) {
		model.addAttribute("teams", equipeService.getAllTeams());
        return "dashboardmanager_equipe_index";
    }
	
	@RequestMapping(value = "/team/add", method = RequestMethod.GET)
    public String addTeamPage(@ModelAttribute Equipe equipe, Model model) {
        model.addAttribute("equipe", equipe);
        return "dashboardmanager_equipe_add";
    }
	
	@RequestMapping(value = "/team/add", method = RequestMethod.POST)
    public String addTeam(@Valid @ModelAttribute("equipe") Equipe equipe, BindingResult result, Model model, 
			RedirectAttributes redirectAttributes, HttpSession session) {
		if (result.hasErrors()) {
			model.addAttribute("equipe", equipe);
	        return "dashboardmanager_equipe_add";
		} 
		equipe.setDate_creation(new Date());
		equipeService.addTeam(equipe);	
		redirectAttributes.addFlashAttribute("succesMessage", "Opération bien effectuée");
		session.setAttribute("count_team", equipeService.countEquipe()); 
		return "redirect:/dashboard/team/";
		
    }
	
	@RequestMapping(value = "/team/update/{idT}", method = RequestMethod.GET)
    public String udpateTaskPage(@PathVariable("idT") Integer idT, @ModelAttribute Equipe equipe, Model model) {
		model.addAttribute("equipe", equipeService.getTeamById(idT));
        return "dashboardmanager_equipe_update";
    }
	
	@RequestMapping(value = "/team/update/{idT}", method = RequestMethod.POST)
    public String udpateTask(@PathVariable("idT") Integer idT, @Valid @ModelAttribute("equipe") Equipe equipe, BindingResult result, Model model, 
							 RedirectAttributes redirectAttributes, HttpSession session) {
		if (result.hasErrors()) {
			model.addAttribute("equipe", equipeService.getTeamById(idT));
			 return "dashboardmanager_equipe_update";
		} 
		equipe.setDate_creation(equipeService.getTeamById(idT).getDate_creation());
		equipe.setId_equipe(idT);
		equipeService.addTeam(equipe);	
		redirectAttributes.addFlashAttribute("succesMessage", "Opération bien effectuée");
		return "redirect:/dashboard/team/";
    }
	
	@RequestMapping(value = "/team/delete/{idT}", method = RequestMethod.GET)
	public String deleteTeam(@PathVariable("idT") Integer idT, RedirectAttributes redirectAttributes, HttpSession session) {
 		    equipeService.deleteTeam(idT);
 		    session.setAttribute("count_team", equipeService.countEquipe()); 
		    redirectAttributes.addFlashAttribute("succesMessage", "Opération bien effectuée");
		    return "redirect:/dashboard/team/";
   }
	
	//________________________________________________________ Project Team ______________________________________________//
    //____________________________________________________________________________________________________________________//
	
	@RequestMapping(value = "{idP}/team/{idE}/detail", method = RequestMethod.GET)
    public String EquipeProjectDetail(@PathVariable("idP") Integer idP, @PathVariable("idE") Integer idE, Model model) {
		model.addAttribute("users", equipeService.getUsersByIdTeam(idE)); 
		Projet projet = projetService.getProjetById(idP);
		model.addAttribute("projet", projet);
			//Count Sprints
		model.addAttribute("CountTasksCompleted", sprintService.getSprintsCompleted(projet.getId_projet()).size());
		model.addAttribute("CountTasksInprogress", sprintService.getSprintsInprogress(projet.getId_projet()).size());
		model.addAttribute("CountTasksPending", sprintService.getSprintsPending(projet.getId_projet()).size());
        return "dashboardmanager_equipe_detail";
    }
	
	@RequestMapping(value = "{idP}/team/add", method = RequestMethod.GET)
    public String addEquipeProjetPage(@PathVariable("idP") Integer idP, @ModelAttribute Projet projet, Model model) {
		model.addAttribute("projet", projet);
		Projet p = projetService.getProjetById(idP);
		model.addAttribute("idP", p.getId_projet());
		model.addAttribute("idF", p.getFicheClient().getId_ficheClient());
		model.addAttribute("equipes", equipeService.getTeamsNotworksInProject(idP));
		//Count Sprints
		model.addAttribute("CountTasksCompleted", sprintService.getSprintsCompleted(p.getId_projet()).size());
		model.addAttribute("CountTasksInprogress", sprintService.getSprintsInprogress(p.getId_projet()).size());
		model.addAttribute("CountTasksPending", sprintService.getSprintsPending(p.getId_projet()).size());
        return "dashboardmanager_equipe_project_add";
    }
	
	@RequestMapping(value = "{idP}/team/add", method = RequestMethod.POST)
    public String addEquipeProjet(@PathVariable("idP") Integer idP, @RequestParam(value="id_equipe", required = false) String id_equipe,
    							   Model model, 
								   RedirectAttributes redirectAttributes, HttpSession session) {
		 
		Projet projet = projetService.getProjetById(idP);
		Set<Equipe> equipes = projet.getEquipes();
		equipes.add(equipeService.getTeamById(Integer.parseInt(id_equipe)));
		projet.setEquipes(equipes);
		projetService.addProjet(projet);	
		redirectAttributes.addFlashAttribute("succesMessage", "Opération bien effectuée");
		return "redirect:/dashboard/"+ idP +"/team/all";
		
    }
	
	@RequestMapping(value = "{idP}/team/delete/{idE}", method = RequestMethod.GET)
    public String deleteEquipeProjet(@PathVariable("idP") Integer idP,@PathVariable("idE") Integer idE, Model model, 
								   RedirectAttributes redirectAttributes, HttpSession session) {
		 
		equipeService.deleteTeamproject(idP, idE);
//		session.setAttribute("count_dashboardmanager", dashboardService.countDashboardManager());	    
		redirectAttributes.addFlashAttribute("succesMessage", "Opération bien effectuée");
		return "redirect:/dashboard/"+ idP +"/team/all";
		
    }
	
	//___________________________________________________ Project Team member ____________________________________________//
    //____________________________________________________________________________________________________________________//
	
	@RequestMapping(value = "/team/{idE}/member", method = RequestMethod.GET)
    public String memberEquipe(@PathVariable("idE") Integer idE, Model model) {
		model.addAttribute("members", equipeService.getUsersByIdTeam(idE));
		model.addAttribute("equipe", equipeService.getTeamById(idE));
        return "dashboardmanager_equipe_member";
    }
	
	@RequestMapping(value = "/team/{idE}/member/add", method = RequestMethod.GET)
    public String addmemberEquipePage(@PathVariable("idE") Integer idE, Model model) {
		model.addAttribute("users", utilisateurService.getUsersNotWorkInTeam(idE));
		model.addAttribute("idE", idE);
        return "dashboardmanager_equipe_member_add";
    }
	
	@RequestMapping(value = "/team/{idE}/member/add", method = RequestMethod.POST)
    public String addmemberEquipe(@PathVariable("idE") Integer idE, @RequestParam(value="id_member", required = false) String id_member,
    							   Model model, 
								   RedirectAttributes redirectAttributes, HttpSession session) {
		 
		Utilisateur user = utilisateurService.getUtilisateurById(Integer.parseInt(id_member));
		user.setEquipe(equipeService.getTeamById(idE));
		utilisateurService.updateUtilisateurCompte(user);
		redirectAttributes.addFlashAttribute("succesMessage", "Opération bien effectuée");
		return "redirect:/dashboard/team/"+idE+"/member";
    }
	
	@RequestMapping(value = "/team/{idE}/member/delete/{idU}", method = RequestMethod.GET)
    public String deletememberEquipe(@PathVariable("idE") Integer idE, @PathVariable("idU") Integer idU, Model model,
    										RedirectAttributes redirectAttributes, HttpSession session) {
		Utilisateur u = utilisateurService.getUtilisateurById(idU);
		u.setEquipe(null);
		utilisateurService.updateUtilisateurCompte(u);
		redirectAttributes.addFlashAttribute("succesMessage", "Opération bien effectuée");
		return "redirect:/dashboard/team/"+idE+"/member";
    }
	
	//____________________________________________ Project Team member via project _______________________________________//
    //____________________________________________________________________________________________________________________//
	
	@RequestMapping(value = "{idP}/team/all", method = RequestMethod.GET)
    public String EquipeProjet(@PathVariable("idP") Integer idP, Model model) {
		model.addAttribute("projet", equipeService.getTeamsByIdProject(idP)); 
		//Count Sprints
		Projet projet = projetService.getProjetById(idP);
	    model.addAttribute("CountTasksCompleted", sprintService.getSprintsCompleted(projet.getId_projet()).size());
		model.addAttribute("CountTasksInprogress", sprintService.getSprintsInprogress(projet.getId_projet()).size());
		model.addAttribute("CountTasksPending", sprintService.getSprintsPending(projet.getId_projet()).size());
        return "dashboardmanager_equipe_project_index";
    }
	
	@RequestMapping(value = "{idP}/team/{idE}/member", method = RequestMethod.GET)
    public String memberEquipeProjet(@PathVariable("idP") Integer idP, @PathVariable("idE") Integer idE, Model model) {
		model.addAttribute("members", equipeService.getUsersByIdTeam(idE));
		Projet p = projetService.getProjetById(idP);
		model.addAttribute("idP", p.getId_projet());
		model.addAttribute("idF", p.getFicheClient().getId_ficheClient());
		model.addAttribute("idE", idE);
		model.addAttribute("projet", p);
		model.addAttribute("equipe", equipeService.getTeamById(idE));
		//Count Sprints
		model.addAttribute("CountTasksCompleted", sprintService.getSprintsCompleted(p.getId_projet()).size());
		model.addAttribute("CountTasksInprogress", sprintService.getSprintsInprogress(p.getId_projet()).size());
		model.addAttribute("CountTasksPending", sprintService.getSprintsPending(p.getId_projet()).size());
        return "dashboardmanager_equipe_project_member";
    }
	
	@RequestMapping(value = "{idP}/team/{idE}/member/add", method = RequestMethod.GET)
    public String addmemberEquipeProjetPage(@PathVariable("idP") Integer idP, @PathVariable("idE") Integer idE, Model model) {
		model.addAttribute("users", utilisateurService.getUsersNotWorkInTeam(idE));
		Projet p = projetService.getProjetById(idP);
		model.addAttribute("idP", p.getId_projet());
		model.addAttribute("idF", p.getFicheClient().getId_ficheClient());
		model.addAttribute("idE", idE);
		//Count Sprints
		model.addAttribute("CountTasksCompleted", sprintService.getSprintsCompleted(p.getId_projet()).size());
		model.addAttribute("CountTasksInprogress", sprintService.getSprintsInprogress(p.getId_projet()).size());
		model.addAttribute("CountTasksPending", sprintService.getSprintsPending(p.getId_projet()).size());
        return "dashboardmanager_equipe_project_member_add";
    }
	
	@RequestMapping(value = "{idP}/team/{idE}/member/add", method = RequestMethod.POST)
    public String addmemberEquipeProjet(@PathVariable("idP") Integer idP, @PathVariable("idE") Integer idE, @RequestParam(value="id_member", required = false) String id_member,
    							   Model model, 
								   RedirectAttributes redirectAttributes, HttpSession session) {
		 
		Utilisateur user = utilisateurService.getUtilisateurById(Integer.parseInt(id_member));
		user.setEquipe(equipeService.getTeamById(idE));
		utilisateurService.updateUtilisateurCompte(user);
		redirectAttributes.addFlashAttribute("succesMessage", "Opération bien effectuée");
		return "redirect:/dashboard/"+idP+"/team/"+idE+"/member";
    }
	
	@RequestMapping(value = "{idP}/team/{idE}/member/delete/{idU}", method = RequestMethod.GET)
    public String deletememberEquipeProjet(@PathVariable("idP") Integer idP, @PathVariable("idE") Integer idE, @PathVariable("idU") Integer idU, Model model,
    										RedirectAttributes redirectAttributes, HttpSession session) {
		Utilisateur u = utilisateurService.getUtilisateurById(idU);
		u.setEquipe(null);
		utilisateurService.updateUtilisateurCompte(u);
//		session.setAttribute("count_dashboardmanager", dashboardService.countDashboardManager());	    
		redirectAttributes.addFlashAttribute("succesMessage", "Opération bien effectuée");
		return "redirect:/dashboard/"+idP+"/team/"+idE+"/member";
    }
	

}
