package com.traficalarm.spring.web.service.screenshot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TakeScreenShotServiceImp implements TakeScreenShotService {

	@Autowired
	private TakeScreenShotAsBytes app;
	private byte[] screen;

	// take a screenshot from the passed url
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.traficalarm.spring.web.service.screenshot.TakeScreenShotService#run(
	 * java.lang.String)
	 */
	@Override
	public byte[] run(String urlToTakeScreen) {
		String url = urlToTakeScreen;
		app.setUrlString(url);
		System.out.println(app.getUrlString());

		screen = app.getWeb();
		return screen;
	}

}
