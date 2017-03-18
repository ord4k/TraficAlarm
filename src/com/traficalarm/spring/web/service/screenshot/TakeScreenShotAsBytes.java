package com.traficalarm.spring.web.service.screenshot;

public interface TakeScreenShotAsBytes {

	// set Webiste URL
	String getUrlString();

	// Get WebSite URL
	void setUrlString(String url);

	byte[] getWeb();

}