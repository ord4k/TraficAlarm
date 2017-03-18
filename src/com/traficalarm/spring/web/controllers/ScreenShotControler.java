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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.traficalarm.spring.web.service.Main;

@Controller
@SessionAttributes({"last","screen"})
public class ScreenShotControler {
	
	@Autowired
	Main screenService;
	
	@Autowired
	SimpleDateFormat sdf;


	@RequestMapping(value = "/takescreen", method = RequestMethod.POST)
	public String takeScreen(Model model) {
		
		String timeStampScreen = sdf.format(Calendar.getInstance().getTime());
		System.out.println("takescreen invoked at " + timeStampScreen);
		//saving screenshot as a byteArray
		byte[] screen = screenService.run();
		model.addAttribute("timeStampScreen", timeStampScreen);
		model.addAttribute("screen", screen);
		return "takescreen";
	}

	@RequestMapping(value = "/getscreen", method = RequestMethod.GET)
	public String getScreen(Model model) {
		String last = (String) model.asMap().get("last");
		System.out.println("Screen made at is ready to view " + last);
		return "getscreen";
	}

}
