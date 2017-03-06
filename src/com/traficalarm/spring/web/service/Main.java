package com.traficalarm.spring.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Main {
	
	private ScreenShotService app;
	
	

	public ScreenShotService getApp() {
		return app;
	}


	@Autowired
	public void setApp(ScreenShotService app) {
		this.app = app;
	}


	public void run() {
	String url = "https://www.google.pl/maps/@52.2229326,20.9125834,13z/data=!5m1!1e1";
	app.setUrlString(url);
	System.out.println(app.getUrlString());
	app.getWeb();
	}
	

}
