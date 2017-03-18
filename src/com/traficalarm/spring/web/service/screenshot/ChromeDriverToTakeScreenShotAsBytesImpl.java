package com.traficalarm.spring.web.service.screenshot;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service
// uncomment if scope needs to be set to session
// @Scope(value="session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ChromeDriverToTakeScreenShotAsBytesImpl implements TakeScreenShotAsBytes {

	private WebDriver driver;
	private String url = null;
	private byte[] screen;

	@Value("${webdriver.browser}")
	private String browser;

	// set Webiste URL
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.traficalarm.spring.web.service.screenshot.
	 * ChromeDriverToTakeScreenShotAsBytes#getUrlString()
	 */
	@Override
	public String getUrlString() {
		return url;
	}

	// Get WebSite URL
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.traficalarm.spring.web.service.screenshot.
	 * ChromeDriverToTakeScreenShotAsBytes#setUrlString(java.lang.String)
	 */
	@Override
	public void setUrlString(String url) {
		this.url = url;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.traficalarm.spring.web.service.screenshot.
	 * ChromeDriverToTakeScreenShotAsBytes#getWeb()
	 */
	@Override
	public byte[] getWeb() {

		if (driver == null) {
			driver = LocalDriverFactory.createInstance(browser);
			System.out.println("instantiating..." +browser);

		}

		if (url != null) {

			try {
				driver.get(url);
			} catch (WebDriverException wex) {
				System.out.println("Catch WebDriverException block");
				System.out.println(wex.getMessage());
				driver = new ChromeDriver();
				getWeb();
			}
			// File scrFile = ((TakesScreenshot)
			// driver).getScreenshotAs(OutputType.FILE);
			screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			System.out.println("Screen shot has been saved as a byteArray");

			// close ChromeDriver
			// driver.close();
			//debug
			//System.out.println("The website has been closed, the driver has hashCode " + driver.hashCode());
		} else {
			System.out.println("First set the url for website you want to access!!");
		}
		return screen;
	}

}
