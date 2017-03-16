package com.traficalarm.spring.web.controllers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.traficalarm.spring.web.service.Main;

@Controller
public class ScreenShotControler {

	private Main screen;


	private SimpleDateFormat sdf;

	public SimpleDateFormat getSdf() {
		return sdf;
	}

	@Autowired
	public void setSdf(SimpleDateFormat sdf) {
		this.sdf = sdf;
	}

	@Autowired
	public void setScreenShotService(Main screen) {
		this.screen = screen;
	}

	@ModelAttribute("timeStampScreen")
	public String getTimeStamp() {
		String timeStampScreen = sdf.format(Calendar.getInstance().getTime());
		return timeStampScreen;

	}

	

	@RequestMapping(value = "/takescreen", method = RequestMethod.POST)
	public String takeScreen(@ModelAttribute("timeStampScreen") String timeStampScreen) {
		System.out.println("takescreen invoked at " + timeStampScreen);
		screen.run();
		return "takescreen";
	}

	@RequestMapping(value = "/getscreen", method = RequestMethod.GET)
	public String getScreen() {
		System.out.println("Screen made at is ready to view");
		return "getscreen";
	}

}
