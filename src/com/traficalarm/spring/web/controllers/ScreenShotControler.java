package com.traficalarm.spring.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.traficalarm.spring.web.service.ScreenShotService;

@Controller
public class ScreenShotControler {

	//private ScreenShotService screenShotService;
/*
	@Autowired
	public void setScreenShotService(ScreenShotService screenShotService) {
		this.screenShotService = screenShotService;
	}
*/
	@RequestMapping("/takescreen")

	public String takeScreen() {
		System.out.println("takescreen invoked");

		return "takescreen";
	}

}
