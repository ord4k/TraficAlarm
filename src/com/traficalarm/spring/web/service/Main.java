package com.traficalarm.spring.web.service;

import org.springframework.stereotype.Service;


public class Main {
	
	
	public void run() {
	String url = "https://www.google.pl/maps/@52.2229326,20.9125834,13z/data=!5m1!1e1";
	
	ScreenShotService app = new ScreenShotService();
	
	app.setUrlString(url);
	System.out.println(app.getUrlString());
	app.getWeb();

	}
	

}
