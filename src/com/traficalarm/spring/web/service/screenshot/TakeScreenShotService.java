package com.traficalarm.spring.web.service.screenshot;

public interface TakeScreenShotService {

	//take a screenshot from the passed url
	byte[] run(String urlToTakeScreen);

}