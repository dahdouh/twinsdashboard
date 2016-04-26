package com.sqli.gfi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sqli.gfi.model.Profil;
import com.sqli.gfi.service.ProfileService;


@Controller
@RequestMapping("/chiefproject/*")
public class ChefProjetController {
	
	@Autowired
	private ProfileService profileService;
	
	@RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
    public String indexCollaborateur(Model model) {
        //List<Profil> profiles = profileService.getAllProfils();
        //model.addAttribute("profiles", profiles);
        return "index_chef_projet";
    }
	
	/* ajouter un nouveau PROFILE */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addProfilePage(@ModelAttribute Profil profile) {
    	return "profile_add";
    }

}

