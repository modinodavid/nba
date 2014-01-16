package org.modino.community.nba.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.util.WebUtils;

public class ApplicationController {
	
	protected Locale getLocale(HttpServletRequest req) {
		Locale locale = (Locale)WebUtils.getSessionAttribute(req, SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
		if (locale == null)
			locale = Locale.ENGLISH;
		return locale;
	}
	
//	public List<RecordDescripted> getSelectOptionsWithDummyOption(SingletonDomains singletonDomains, String domainId, String languageId) {
//		return getSelectOptionsWithDummyOption(singletonDomains, domainId, languageId, true);
//	}
//	
//	public List<RecordDescripted> getSelectOptions(SingletonDomains singletonDomains, String domainId, String languageId) {
//		return getSelectOptionsWithDummyOption(singletonDomains, domainId, languageId, false);
//	}
//
//	private List<RecordDescripted> getSelectOptionsWithDummyOption(SingletonDomains singletonDomains, String domainId, String languageId, boolean needDummyOption) {
//		if (needDummyOption)
//			return HtmlHelper.addDummyOption(DomainToBean.getRecordDescripted(singletonDomains.getDomains(domainId, languageId)));
//		else
//			return DomainToBean.getRecordDescripted(singletonDomains.getDomains(domainId, languageId)); 
//	}

}
