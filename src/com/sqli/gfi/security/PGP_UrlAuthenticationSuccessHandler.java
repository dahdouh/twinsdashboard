package com.sqli.gfi.security;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.sqli.gfi.model.Utilisateur;
import com.sqli.gfi.service.ActionService;
import com.sqli.gfi.service.ChefprojetService;
import com.sqli.gfi.service.ClientService;
import com.sqli.gfi.service.CompteService;
import com.sqli.gfi.service.DashboardService;
import com.sqli.gfi.service.EquipeService;
import com.sqli.gfi.service.EventService;
import com.sqli.gfi.service.FicheClientService;
import com.sqli.gfi.service.ProjetService;
import com.sqli.gfi.service.TaskService;
import com.sqli.gfi.service.UtilisateurService;
import com.sqli.gfi.web.LoginController;

@Component
public class PGP_UrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	private static final Logger log = Logger.getLogger(LoginController.class);
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Autowired
	private CompteService compteService;
	@Autowired
	private UtilisateurService utilisateurService;
	@Autowired
    private DashboardService dashboardService;
	@Autowired
    private ChefprojetService chefprojetService;
	@Autowired
    private EquipeService equipeService;
	@Autowired
    private ClientService clientService;
	@Autowired
    private ActionService actionService;
	@Autowired
	private FicheClientService ficheClientService;
	@Autowired
	private ProjetService projetService;
	@Autowired
	private EventService eventService;
	@Autowired
	private TaskService taskService;
	
	
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication) throws IOException,ServletException {
		handle(request, response, authentication);
        clearAuthenticationAttributes(request);
		// TODO Auto-generated method stub
		
	}
	
	
	protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
		String targetUrl = determineTargetUrl(request, authentication);

		if (response.isCommitted()) {
			log.debug("Response has already been committed. Unable to redirect to " + targetUrl);
			return;
		}

		redirectStrategy.sendRedirect(request, response, targetUrl);
	}
	
	 /** Determiner la page d'acceuil de l'utilisateur connecte. */
    protected String determineTargetUrl(HttpServletRequest request, Authentication authentication) {
    	boolean isAdmin = false;
    	boolean isDashboard_Manger = false;
    	boolean isChef_Projet = false;
        boolean isMembre_equipe = false;
        boolean isClient = false;
        
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        
        /** get username(login) of user logged in */
        String login = authentication.getName();
        /** get  l'Id of user logged in */
	    Integer id_compte = compteService.getIdCompteByLogin(login);
	    Utilisateur user_logged_in= (Utilisateur)utilisateurService.getUtilisateurByIdCompte(id_compte);
	    HttpSession session = request.getSession();
	    session.setAttribute("user_logged_in", user_logged_in);
    	session.setAttribute("user", user_logged_in.getNom()+" "+user_logged_in.getPrenom()); 
	    
        for (GrantedAuthority grantedAuthority : authorities) {
        	if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
            	isAdmin = true;
                log.info(" _______________________ admin "+ user_logged_in.getPrenom()+""+ user_logged_in.getNom() +" connected to the system at  "+ new Date() +"_____________________");
                break;
            } else if (grantedAuthority.getAuthority().equals("ROLE_DASHBOARD_MANAGER")) {
            	isDashboard_Manger = true;
                log.info(" _______________________ dashboard manager "+ user_logged_in.getPrenom()+""+ user_logged_in.getNom() +" connected to the system at  "+ new Date() +"_____________________");
                break;
            } else if (grantedAuthority.getAuthority().equals("ROLE_CHEF_PROJET")) {
            	isChef_Projet = true;
            	log.info(" _______________________ chief project "+ user_logged_in.getPrenom()+""+ user_logged_in.getNom() +" connected to the system at  "+ new Date() +"_____________________");
                break;
            } else if (grantedAuthority.getAuthority().equals("ROLE_MEMBRE_EQUIPE")) {
            	isMembre_equipe = true;
            	log.info(" _______________________ team membre "+ user_logged_in.getPrenom()+""+ user_logged_in.getNom() +" connected to the system at  "+ new Date() +"_____________________");
                break;
            } else if (grantedAuthority.getAuthority().equals("ROLE_CLIENT")) {
            	isClient = true;
            	log.info(" _______________________ customer "+ user_logged_in.getPrenom()+" "+ user_logged_in.getNom() +" connected to the system at  "+ new Date() +"_____________________");
                break;
            }
        }
        
        if (isAdmin) {
        	session.setAttribute("count_dashboardmanager", dashboardService.countDashboardManager()); 
        	session.setAttribute("count_chefprojet", chefprojetService.countChefprojet()); 
        	session.setAttribute("count_membre_equipe", equipeService.countmembreEquipe()); 
        	session.setAttribute("count_client", clientService.countClient()); 
        	session.setAttribute("count_account", compteService.countCompte()); 
        	session.setAttribute("permission_account", actionService.countAction()); 
        	session.setAttribute("count_fiche", ficheClientService.countFicheclient()); 
        	session.setAttribute("count_projet", projetService.countProjet()); 
        	session.setAttribute("count_team", equipeService.countEquipe()); 
        	session.setAttribute("count_event", eventService.countEvent()); 
        	session.setAttribute("count_projet_teamember", projetService.countTeamemberProjet(user_logged_in.getId_u())); 
        	session.setAttribute("count_event_teamember", eventService.countTeamemberEvent(user_logged_in.getId_u()));
        	session.setAttribute("count_task_teamember", taskService.countTeamemberMyTask(user_logged_in.getId_u()));
        	
            return "/admin/";  /** redirect dashboard manager to  home page*/
        	
        } else if (isDashboard_Manger) {
        	session.setAttribute("count_fiche", ficheClientService.countFicheclient()); 
        	session.setAttribute("count_projet", projetService.countProjet()); 
        	session.setAttribute("count_team", equipeService.countEquipe()); 
        	session.setAttribute("count_event", eventService.countEvent()); 
        	//connected like team member
        	session.setAttribute("count_projet_teamember", projetService.countTeamemberProjet(user_logged_in.getId_u())); 
        	session.setAttribute("count_event_teamember", eventService.countTeamemberEvent(user_logged_in.getId_u()));
        	session.setAttribute("count_task_teamember", taskService.countTeamemberMyTask(user_logged_in.getId_u()));
            return "/dashboard/index";  /** redirect dashboard manager to  home page*/
        	
        } else if (isChef_Projet) {
        	session.setAttribute("count_projet", projetService.countProjet()); 
        	session.setAttribute("count_team", equipeService.countEquipe()); 
        	//connected like team member
        	session.setAttribute("count_projet_teamember", projetService.countTeamemberProjet(user_logged_in.getId_u())); 
        	session.setAttribute("count_event_teamember", eventService.countTeamemberEvent(user_logged_in.getId_u()));
        	session.setAttribute("count_task_teamember", taskService.countTeamemberMyTask(user_logged_in.getId_u()));
        	return "/dashboard/index"; /** redirect project chief to home page of project chief */
        	
        } else if (isMembre_equipe) {      	
        	session.setAttribute("count_projet_teamember", projetService.countTeamemberProjet(user_logged_in.getId_u())); 
        	session.setAttribute("count_event_teamember", eventService.countTeamemberEvent(user_logged_in.getId_u()));
        	session.setAttribute("count_task_teamember", taskService.countTeamemberMyTask(user_logged_in.getId_u()));
            return "/teamember/"; /** redirect team member to home page of team member */
        } else if (isClient) { 
        	session.setAttribute("count_projet_client", projetService.countProjetClient(user_logged_in.getId_u())); 
        	session.setAttribute("count_event_client", eventService.countTeamemberEvent(user_logged_in.getId_u()));
        	session.setAttribute("count_team_client", equipeService.countTeamClient(user_logged_in.getId_u()));
            return "/client/index"; /** redirect client to home page of client*/
        } else {
            throw new IllegalStateException();
        }
    }
    
    protected void clearAuthenticationAttributes(HttpServletRequest request) {
    	HttpSession session = request.getSession(false);
        if (session == null) {
            return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }
 
    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }
    protected RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }
	

}
