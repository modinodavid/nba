
package org.modino.community.nba.controller; 

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * 
 * @author dmodino
 *
 */
@Controller
@SessionAttributes(types = NBAController.class)

public class NBAController {


	protected Logger logger = Logger.getLogger(NBAController.class);
	
//	@Autowired
//    private CacheService cacheService;
	
	 
	@Autowired
	public NBAController() {
	}

	/**
	 * Custom handler for the welcome view.
	 * <p>
	 * Note that this handler relies on the RequestToViewNameTranslator to
	 * determine the logical view name based on the request URL: "/welcome.do"
	 * -&gt; "welcome".
	 */
	@RequestMapping("/")
	public String welcomeHandler() {
		return "redirect:/home";
	}

	/**
	 * Custom handler for displaying vets.
	 *
	 * <p>Note that this handler returns a plain {@link ModelMap} object instead of
	 * a ModelAndView, thus leveraging convention-based model attribute names.
	 * It relies on the RequestToViewNameTranslator to determine the logical
	 * view name based on the request URL: "/vets.do" -&gt; "vets".
	 *
	 * @return a ModelMap with the model attributes for the view
	 */
	
//	@RequestMapping("/login")
//	public String homeHandler(Model model, HttpServletRequest request) {
//
//		if (logger.isDebugEnabled()){
//			logger.debug("---------------- SITEMINDER DETAILS ---------------");
//			logger.debug("TYPE "+request.getParameter(SiteminderDictionary.TYPE));
//			logger.debug("METHOD "+request.getParameter(SiteminderDictionary.METHOD));
//			logger.debug("REALMOID "+request.getParameter(SiteminderDictionary.REALMOID));
//			logger.debug("SMAGENTNAME "+request.getParameter(SiteminderDictionary.SMAGENTNAME));
//			logger.debug("SMAUTHREASON "+request.getParameter(SiteminderDictionary.SMAUTHREASON));
//			logger.debug("TARGET "+request.getParameter(SiteminderDictionary.TARGET));
//			logger.debug("ERR "+request.getParameter(SiteminderDictionary.ERR));
//			logger.debug("---------------- END SITEMINDER DETAILS ------------");
//		}
//		
//		String type = request.getParameter(SiteminderDictionary.TYPE);
//		String method = request.getParameter(SiteminderDictionary.METHOD);
//		String realmOID = request.getParameter(SiteminderDictionary.REALMOID);
//		String smAgent = request.getParameter(SiteminderDictionary.SMAGENTNAME);
//		String smAuth = request.getParameter(SiteminderDictionary.SMAUTHREASON);
//		String target = request.getParameter(SiteminderDictionary.TARGET);
//		String error = request.getParameter(SiteminderDictionary.ERR);
//		
//		SiteMinderUserCredentials user = new SiteMinderUserCredentials();
//		user.setMETHOD(method);
//		user.setREALMOID(realmOID);
//		user.setSMAGENTNAME(smAgent);
//		user.setSMAUTHREASON(smAuth);
//		user.setTARGET(target);
//		user.setTYPE(type);
//		user.setSMENC("ISO-8859-1");
//		user.setSMLOCALE("US-EN");
//		if(target!=null && target.contains(SiteminderDictionary.ERR)){
//			user.setError(SiteminderDictionary.ERR);
//		}
//		
//		model.addAttribute("user", user);
//		
//		if (error != null && !"".equals(error)){
//			return "redirect:/home?ERR="+error;
//		}else{
//			return "login";
//		}
//	}
	
	
//	@RequestMapping("/loaddata") 
//	public ModelMap loadData() {
//		 
//		this.cacheService.refreshCache(getToken());
//		return null;
//		
//	}
	
	@RequestMapping("/logout")
	public String homeHandler() {

		return "redirect:/home";
	}
	
	public String getToken() {
		return null; //TODO token
	}

}
