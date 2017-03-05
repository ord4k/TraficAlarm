package com.traficalarm.spring.web.service;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;


public class ScreenShotService {

	private WebDriver driver = new ChromeDriver();
	private String url = null;
	private String screenDir;

	// set Webiste URL
	public String getUrlString() {
		return url;
	}
	

	// Get WebSite URL
	public void setUrlString(String url) {
		this.url = url;
	}

	public void setScreenDir(String screenDir) {
		this.screenDir = screenDir;
	}
	public String getScreenDir() {
		return screenDir;
	}

	public void getWeb() {
		if (url != null) {
			driver.get(url);

			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				if (screenDir == null) {
					screenDir = "\\resources\\tmp";
				}
				FileUtils.copyFile(scrFile, new File(screenDir));

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.close();
			System.out.println("The website has been closed");
			System.out.println("Screen shot has been saved in: ");
		} else {
			System.out.println("First set the url for website you want to access!!");
		}
	}

}
