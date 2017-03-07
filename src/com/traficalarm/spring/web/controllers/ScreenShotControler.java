package com.traficalarm.spring.web.controllers;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.traficalarm.spring.web.service.Main;

@Controller
public class ScreenShotControler {

	private Main screen;

	@Autowired
	public void setScreenShotService(Main screen) {
		this.screen = screen;
	}

	@RequestMapping("/takescreen")

	public String takeScreen() {
		System.out.println("takescreen invoked");
		screen.run();

		return "takescreen";
	}

}
