package com.sqli.gfi.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sqli.gfi.model.Profil;
import com.sqli.gfi.service.ProfileService;


@Controller
@RequestMapping("/profile/*")
public class ProfileController {
	@Autowired
	private ProfileService profileService;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
    public String indexCollaborateur(Model model) {
        List<Profil> profiles = profileService.getAllProfils();
        model.addAttribute("profiles", profiles);
        return "index_profile";
    }
	
	/* ajouter un nouveau PROFILE */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addProfilePage(@ModelAttribute Profil profile) {
    	return "profile_add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addProfile(@ModelAttribute("profile") Profil p, @Valid Profil profile, BindingResult result, RedirectAttributes redirectAttributes) {
    	if (result.hasErrors()) {
			return "profile_add";
		} else {
			profileService.addProfil(p);
			redirectAttributes.addFlashAttribute("succesMessage", "Opération bien effectuée");
	        return "redirect:/profile/index";
		}		
    }
    
    /** supprimer un PROFILE 
    @RequestMapping(value = "/delete/{idP}", method = RequestMethod.GET)
    public String deleteProfile(@PathVariable("idP") Integer idP) {
    	profileService.deleteProfile(idP);
        return "redirect:/profile/index";
    }
    */
    /******************************************************************************
	this methode handling all reques in case if request is not mapping in this controller 								  
    *******************************************************************************/
//    @RequestMapping(method = RequestMethod.GET)
//	public String defaultPage() {
//		return "defaultPage";
//    }

}
