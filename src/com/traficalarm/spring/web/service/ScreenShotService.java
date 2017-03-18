package com.traficalarm.spring.web.service;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

@Service
public class ScreenShotService {

	private WebDriver driver;
	private String url = null;
	private String screenDir;
	private byte[] screen;


	// set Webiste URL
	public String getUrlString() {
		return url;
	}

	// Get WebSite URL
	public void setUrlString(String url) {
		this.url = url;
	}

	public byte[] getWeb() {
		driver = new ChromeDriver();
		if (url != null) {

			driver.get(url);
			// File scrFile = ((TakesScreenshot)
			// driver).getScreenshotAs(OutputType.FILE);
			screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			System.out.println("Screen shot has been saved as a byteArray");
			
			//close ChromeDriver
			driver.close();
			System.out.println("The website has been closed");
		} else {
			System.out.println("First set the url for website you want to access!!");
		}
		return screen;
	}

}
