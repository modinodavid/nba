
package org.modino.community.nba.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.modino.community.nba.services.HomeService;
import org.omg.CORBA.portable.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


//import com.axaglobaldistributors.dms.bean.RecordDescripted;
//import com.axaglobaldistributors.dms.bean.TableData;
//import com.axaglobaldistributors.dms.conversors.BeanToDTO;
//import com.axaglobaldistributors.dms.conversors.DTOToBean;
//import com.axaglobaldistributors.dms.dictionary.Dictionary;
//import com.axaglobaldistributors.dms.dto.SearchCriteria;
//import com.axaglobaldistributors.dms.dto.SearchResult;
//import com.axaglobaldistributors.dms.exceptions.ApplicationException;
//import com.axaglobaldistributors.dms.helper.ObjectConversorHelper;
//import com.axaglobaldistributors.dms.services.HomeService;
//import com.axaglobaldistributors.dms.siteminder.AppUserDetails;

/**
 * JavaBean Form controller that is used to search for <code>Owner</code>s by
 * last name.
 * 
 * @author dmodino
 *
 */
@Controller
public class HomeController extends ApplicationController {
	
	
	protected Logger logger = Logger.getLogger(HomeController.class);
	
	@Autowired
	private HomeService homeService;
	
	public HomeController() {
	}

	
	/**
	 * Landing page: Load the requiered info to build the home page
	 * @return
	 * @throws ApplicationException
	 */
	@RequestMapping("/home")
	public ModelMap homeHandler(HttpServletRequest request) throws ApplicationException {
		
		ModelMap modelMap = new ModelMap();

		//Tables
		modelMap.addAttribute("allForums", this.homeService.getAllForums());
		modelMap.addAttribute("allLeagues", this.homeService.getAllLeagues());
		modelMap.addAttribute("allPolls", this.homeService.getAllPolls());
		modelMap.addAttribute("allTeams", this.homeService.getAllTeams());
		modelMap.addAttribute("allPrivateLeagues", this.homeService.getPrivateLeagues());
		modelMap.addAttribute("privateLeagues", this.homeService.getPrivateLeagues());
		modelMap.addAttribute("publicLeagues", this.homeService.getPublicLeagues());

		return modelMap;
	}



	
//	@InitBinder
//	public void setAllowedFields(WebDataBinder dataBinder) { 
//		dataBinder.setDisallowedFields("id");
//	}	 
	
	/**
	 * Return Firms for the search params
	 * 
	 * @param country
	 * @param firmType
	 * @return
	 * @throws ApplicationException
	 */
//	@RequestMapping(value = "home/getFirms", method = RequestMethod.POST)
//	public @ResponseBody List<RecordDescripted> getFirms(@RequestParam String country, @RequestParam String firmType) throws ApplicationException {
//		return this.homeService.getFirms(country, firmType);
//	}
	
	
	
	/**
	 * Executes the search for the SEARCH result table
	 * 
	 * @param tableData
	 * @return
	 */
//	@RequestMapping(value = "/home/search", method = RequestMethod.POST)
//	public ModelAndView search(@ModelAttribute TableData tableData, @RequestHeader("preferredLanguage") String langID) {
//		SearchCriteria searchCriteria = BeanToDTO.getSearchCriteria(tableData, SearchCriteria.SEARCH, 
//				null, Dictionary.DEFAULT_PAGE_SIZE);
//		searchCriteria.setLanguageId(langID);
//		
//		SearchResult searchResult = null; 
//		
//		try {
//			searchResult = this.homeService.search(searchCriteria);
//		}
//		catch (ApplicationException e) {
//			logger.error("UNABLE to search data for HOME", e.getException());
//		}
//		
//		TableData response = DTOToBean.getTableData(searchCriteria, tableData, searchResult, this.homeService.getHeadersTable(searchCriteria.getSearchType(), searchCriteria));
//		
//		ModelAndView map = new ModelAndView();
//		map.addObject("tableId", searchCriteria.getTableId());
//		map.addObject("beanName", "tableData");
//		map.addObject("formName", searchCriteria.getFormName()); 
//		map.addObject("tableData", response);
//		map.setViewName(JSP_LIST);
//		
//		return map;
//	}
	
	/**
	 * Updates the content of the tables according to the order / paging params
	 * 
	 * @param tableData
	 * @param tableId
	 * @return
	 */
//	@RequestMapping(value = "/home/paging/{tableId}", method = RequestMethod.POST)
//	public ModelAndView updateTable(@ModelAttribute TableData tableData, @PathVariable("tableId") int tableId, @RequestHeader("preferredLanguage") String langID) {
//		SearchCriteria searchCriteria = BeanToDTO.getSearchCriteria(tableData, tableId, 
//				null, Dictionary.DEFAULT_PAGE_SIZE);
//		searchCriteria.setLanguageId(langID);
//		
//		SearchResult searchResult = null; 
//		
//		try {
//			searchResult = this.homeService.search(searchCriteria);
//		}
//		catch (ApplicationException e) {
//			logger.error("UNABLE to search data for HOME", e.getException());
//		}
//		
//		TableData response = DTOToBean.getTableData(searchCriteria, tableData, searchResult, this.homeService.getHeadersTable(searchCriteria.getSearchType(), searchCriteria));
//		
//		ModelAndView map = new ModelAndView();
//		map.addObject("tableId", searchCriteria.getTableId());
//		map.addObject("beanName", "tableData");
//		map.addObject("formName", searchCriteria.getFormName()); 
//		map.addObject("tableData", response);
//		map.setViewName(JSP_LIST);
//		return map;
//	}
	
//	@RequestMapping(value = "/home/autocomplete", method = RequestMethod.GET)
//	public @ResponseBody ModelMap getOptions(@RequestParam String country, @RequestParam String entityType, @RequestParam String entityCriteria1, @RequestParam String searchBox) {
//		List<String> options = null;
//		try {
//			options = this.homeService.getAutocompleteOptions(country, entityType, entityCriteria1, searchBox);
//		}
//		catch (Exception e) {
//			options = new ArrayList<String>();
//			options.add("No options availables"); //TODO
//		}
//		
//		
//		ModelMap map = new ModelMap();
//		map.addAttribute("suggestions", ObjectConversorHelper.fromListToArray(options));
//		return map;
//	}
	 
}
