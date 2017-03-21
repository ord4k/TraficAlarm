package com.traficalarm.spring.web.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.traficalarm.spring.web.service.spotify.SpotifyService;

@Controller
public class HomeController {
	
	@Autowired
	SpotifyService spotify;

	@RequestMapping("/")
	public String showHome() {
		System.out.println("Home loaded");

		return "index";
	}

	@RequestMapping(value = "/api", method = RequestMethod.GET)
	public RedirectView api(RedirectView mav) {

		
		
		String clientId = spotify.getClientId();
		System.out.println(clientId);
		String responseType = "code";
		String redirectUri = "http://localhost:8080/traficalarm/callback/";
		// model.addAttribute("scope", "user-read-private user-read-email");
		mav.setUrl("https://accounts.spotify.com/authorize?client_id=" + clientId + "&response_type=" + responseType
				+ "&redirect_uri=" + redirectUri);
		return mav;
	}

	@RequestMapping(value = "/spotify", method = RequestMethod.GET)
	public String spotify(Model model) {
		// put some staff in model
		return "spotify";
	}
	
	
	
	/////this cannot be finished as there is no way to pass token as Post without JS server or JSON. Refer to https://developer.spotify.com/web-api/authorization-guide/ step 4
	@RequestMapping(value = "/callback/", method = RequestMethod.GET)
public RedirectView v1(RedirectView mav, @RequestParam(value="code") String code,HttpServletResponse response) {

		String clientId = spotify.getClientId();
		String clientSecret = spotify.getClientSecret();
		System.out.println(clientId);
		String responseType = "code";
		String redirectUri = "http://localhost:8080/traficalarm/callback/";
		// model.addAttribute("scope", "user-read-private user-read-email");
		mav.setUrl("https://accounts.spotify.com/api/token?client_id=" + clientId + "&response_type=" + responseType
				+ "&redirect_uri=" + redirectUri+"&client_secret="+clientSecret+"&code="+code+"&grant_type=authorization_code");
		return mav;
	}

}
