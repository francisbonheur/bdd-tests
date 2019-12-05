package com.edf.sitecp.bddtests.configuration;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.edf.sitecp.bddtests.pageobjects.BasePage;

@Configuration
@ConfigurationProperties("com.edf.sitecp.bddtests")
public class BddTestsConfiguration {

	private String seleniumUrl;
	private String proxy;
	private String chromeVersion;
	
	@Bean
	public WebDriver getWebDriver() {
		ChromeOptions options = new ChromeOptions();
		options.setCapability("version", chromeVersion);
		options.setCapability("proxy", proxy);
		URL url = null;
		try {
			url = new URL(seleniumUrl);
		} catch (MalformedURLException e) {
		}
		
		return new RemoteWebDriver(options);
		
	}
	
	@Bean
	public BasePage getBasePage() {
		return new BasePage(getWebDriver());
	}
}
