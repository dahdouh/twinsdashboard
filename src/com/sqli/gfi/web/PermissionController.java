package com.sqli.gfi.web;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sqli.gfi.model.Action;
import com.sqli.gfi.model.Profil;
import com.sqli.gfi.service.ActionService;
import com.sqli.gfi.service.ProfileService;

@Controller
@RequestMapping("/permission/*")
public class PermissionController {
	@Autowired
	private ActionService actionService;
	@Autowired
	private ProfileService profileService;
 

	@RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
    public String indexPermission(Model model) {
        model.addAttribute("permessions", actionService.getAllAction()); 
        return "admin_permission_index";
    }
	
	@ModelAttribute("profile")
	public List<Profil> profileList(){
	    List<Profil> selectItems = new ArrayList<Profil>();
	    List<Profil> profileList = profileService.getAllProfils();
	    for (Profil pf : profileList) {
	    	selectItems.add(new Profil(pf.getId_profil(),pf.getTitre()));
	    }
	    return selectItems;
	}
	
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String assignerProfleActionPage(@ModelAttribute Action action, Model model) {
    	model.addAttribute("permessions",actionService.getAllActionLibelle());
    	model.addAttribute("profiles",profileList()); 
    	return "admin_permission_add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String assignerProfleAction(@ModelAttribute Action ac, @Valid Action action, BindingResult result, Model model, 
    									HttpSession session,RedirectAttributes redirectAttributes) {
    	
			Integer id_profile = Integer.parseInt(ac.getProfil().getTitre());
			ac.getProfil().setId_profil(id_profile);
			System.out.println(ac);
			actionService.addAction(ac);
			session.setAttribute("permission_account", actionService.countAction()); 
			
			redirectAttributes.addFlashAttribute("succesMessage", "Opération bien effectuée");
	        return "redirect:index";		
    }
    
    @RequestMapping(value = "/update/{idA}", method = RequestMethod.GET)
    public String updateProfleActionPage(@PathVariable("idA") Integer idA, Model model) {
        Action action = actionService.getActionById(idA);
        model.addAttribute("action", action);
        model.addAttribute("permessions",actionService.getAllActionLibelle());
    	model.addAttribute("profiles",profileList());
        return "admin_permission_update";
    }

    @RequestMapping(value = "/update/{idA}", method = RequestMethod.POST)
    public String  updateProfleAction(@ModelAttribute("action") Action ac, @PathVariable("idA") Integer idA, Model model, @Valid Action action, BindingResult result, 
    							      RedirectAttributes redirectAttributes) {
//    	if (result.hasErrors()) {
//    		action.setId_action(idA);;
//    		model.addAttribute("action", action);
//    		model.addAttribute("actions",actionService.getAllActionLibelle());
//        	model.addAttribute("profiles",profileList());
//			return "action_update";
//		} else {
			Integer id_profile = Integer.parseInt(ac.getProfil().getTitre());
			ac.getProfil().setId_profil(id_profile);
			ac.setId_action(idA);
	    	actionService.addAction(ac);
	    	
	    	redirectAttributes.addFlashAttribute("succesMessage", "Opération bien effectuée");
			return "redirect:/permission/index";
//		}
    }
    
    @RequestMapping(value = "/delete/{idA}", method = RequestMethod.GET)
    public String deleteProfleAction(@PathVariable("idA") Integer idA, RedirectAttributes redirectAttributes, HttpSession session) {
        actionService.deleteAction(idA);
        session.setAttribute("permission_account", actionService.countAction()); 
        redirectAttributes.addFlashAttribute("succesMessage", "Opération bien effectuée");
        return "redirect:/permission/index";
    }
    
    
    /******************************************************************************
	this methode handling all reques in case if request is not mapping in controller 								  
    *******************************************************************************/
    @RequestMapping(method = RequestMethod.GET)
	public String defaultPage(Model model) {
    	 model.addAttribute("permessions", actionService.getAllAction()); 
         return "admin_permission_index";
    }
	

}
