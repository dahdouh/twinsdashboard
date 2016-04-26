package com.sqli.gfi.web;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sqli.gfi.model.Compte;
import com.sqli.gfi.model.Utilisateur;
import com.sqli.gfi.service.CompteService;
import com.sqli.gfi.service.MailSenderService;
import com.sqli.gfi.service.UtilisateurService;

@Controller
@RequestMapping("/compte/*")
public class CompteController {
	
	@Autowired
	private CompteService compteService;
	@Autowired
	private MailSenderService  mailSenderService;
	@Autowired
	private UtilisateurService utilisateurService;
	
	private Map<String,String>  search_criteria() {
    	Map<String,String> search_criteria = new LinkedHashMap<String,String>();
    	search_criteria.put("login", "login");
    	return search_criteria;
	}
	
	@RequestMapping(value ={"/","/index"}, method = RequestMethod.GET)
    public String indexAction(Model model) {
        List<Compte> comptes = compteService.getAllCompte();
        model.addAttribute("comptes", comptes); 
        model.addAttribute("search_criteria_list", search_criteria()); 
        return "admin_compte_index";
    }
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchCompte(@RequestParam(value="criteria", required = false) String criteria, @RequestParam(value="libelle", required = false) String libelle, HttpServletRequest req, Model model) {

    	if(criteria == ""){
    		model.addAttribute("msgError", " veuillez selectionner un critère");
    		model.addAttribute("search_criteria_list", search_criteria()); 
        	model.addAttribute("comptes", compteService.getAllCompte());
    		return "admin_compte_index";
    	} else {
	    	model.addAttribute("search_criteria_list", search_criteria()); 
	    	model.addAttribute("comptes", compteService.getCompteByCriteria(criteria, libelle));
	    	return "admin_compte_index";
    	}
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addComptePage(@ModelAttribute Compte compte, Model model) {
    	model.addAttribute("users", utilisateurService.getAllUtilisateur());
    	return "admin_compte_add";
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addCompte(@RequestParam(value="utilisateur", required = false) String utilisateur, @Valid @ModelAttribute Compte compte, BindingResult result, 
    									  Model model, RedirectAttributes redirectAttributes, HttpSession session) {
//		if (result.hasErrors()) {			
//			model.addAttribute("users", utilisateurService.getAllUtilisateur());
//			return "admin_compte_add";
//		} 
			String login = compte.getLogin();
			String password = compte.getPassword();
			Boolean active = compte.getActive();
			System.out.println("#################################"+ utilisateur);
			Integer compteExiste = null;
			//test est ce que le login est deja existe
			compteExiste = compteService.getIdCompteByLogin(login);
			if(compteExiste == null) {			
				PasswordEncoder encoder = new Md5PasswordEncoder();
			    String hashedPassword = encoder.encodePassword(password, null);
				compte.setPassword(hashedPassword);
				// enregistrer le nouveau compte compte 
				Compte nouveau_comte = new Compte(login, hashedPassword, active);
				// update utilisateur, on lui associe à n nouveau compte
				Integer id_u = Integer.parseInt(utilisateur);
				Utilisateur ut_compte = utilisateurService.getUtilisateurById(id_u);
				ut_compte.setCompte(nouveau_comte);
				utilisateurService.updateUtilisateurCompte(ut_compte);
				
//				// envoyer le login et mot de passe au utilisateur 			
				mailSenderService.sendPassword(ut_compte.getEmail(), login, password, active);
				
				session.setAttribute("count_account", compteService.countCompte()); 
				redirectAttributes.addFlashAttribute("succesMessage", "Opération bien effectuée");
				return "redirect:index";
			} else {
				model.addAttribute("ErrorLoginExist", "login est deja existe, veuillez réessauer.");
		    	return "redirect:index";
			}
    }

    
    @RequestMapping(value = "update/{idCompte}", method = RequestMethod.GET)
    public String updateComptePage(@PathVariable("idCompte") Integer idCompte, Model model) {
    	model.addAttribute("compte", compteService.getCompteById(idCompte));
    	return "admin_compte_update";
    }

    @RequestMapping(value = "update/{idCompte}", method = RequestMethod.POST)
    public String updateCompte(@PathVariable("idCompte") Integer idCompte, @Valid @ModelAttribute Compte compte, BindingResult result, 
    						   Model model, RedirectAttributes redirectAttributes, HttpSession session) {
    	
    	if(result.hasErrors()) {
    		model.addAttribute("compte", compteService.getCompteById(idCompte));
    		return "admin_compte_update";
    	}
    	
    	String password = compte.getPassword();
    	PasswordEncoder encoder = new Md5PasswordEncoder();
	    String hashedPassword = encoder.encodePassword(password, null);
	    
	    compte.setId_compte(idCompte);
	    compte.setPassword(hashedPassword);
	    compteService.updateCompte(compte);
	    
	    /* envoyer le login et mot de passe au utilisateur */	
	    Utilisateur u = utilisateurService.getUtilisateurByIdCompte(idCompte);
		mailSenderService.sendUpdatePassword(u.getEmail(), compte.getLogin(), password, compte.getActive());
		session.setAttribute("count_account", compteService.countCompte());
		redirectAttributes.addFlashAttribute("succesMessage", "Opération bien effectuée");
    	return "redirect:/compte/index";
    }

    @RequestMapping(value = "delete/{idCompte}", method = RequestMethod.GET)
    public String deleteCompte(@PathVariable("idCompte") Integer idCompte, RedirectAttributes redirectAttributes) {
    	Utilisateur u = utilisateurService.getUtilisateurByIdCompte(idCompte);
    	u.setCompte(null);
    	utilisateurService.updateUtilisateurCompte(u);
    	compteService.deleteCompte(idCompte);
    	redirectAttributes.addFlashAttribute("succesMessage", "Opération bien effectuée");
        return "redirect:/compte/index";
    }
    
    
    /******************************************************************************
	this methode handling all reques in case if request is not mapping in this controller 								  
    *******************************************************************************/
    @RequestMapping(method = RequestMethod.GET)
	public String defaultPage(Model model) {
    	List<Compte> comptes = compteService.getAllCompte();
        model.addAttribute("comptes", comptes); 
        model.addAttribute("search_criteria_list", search_criteria()); 
        return "admin_compte_index";
    }
    
    
    
    
    
}
