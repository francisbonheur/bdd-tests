package com.edf.sitecp.bddtests.configuration;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.edf.sitecp.bddtests.pageobjects.BasePage;
import com.edf.sitecp.bddtests.pageobjects.BddTestFieldDecorator;
import com.edf.sitecp.bddtests.pageobjects.BddTestWebDriverEventListener;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "com.edf.sitecp.bddtests")
public class BddTestsConfiguration {

	private static final Logger LOG = LoggerFactory.getLogger(BddTestsConfiguration.class);
	
	private String seleniumUrl;
	private String proxy;
	private String chromeVersion;
	private String browserPath;
	
	@Bean
	public WebDriver getWebDriver() {
		ChromeOptions options = new ChromeOptions();
		LOG.error(String.format("browserPath : %s", browserPath));
		LOG.error(String.format("chromeVersion : %s", chromeVersion));
		LOG.error(String.format("seleniumUrl : %s", seleniumUrl));
		
		options.setBinary(browserPath);
		//options.setCapability("version", chromeVersion);
		//options.setCapability("proxy", proxy);
		URL url = null;
		try {
			url = new URL(seleniumUrl);
		} catch (MalformedURLException e) {
			LOG.error("Cannot parse seleniumUrl", e);
		}
		
		return new RemoteWebDriver(options);
		
	}

	@Bean
	public FieldDecorator getDecorator(WebDriver webDriver) {
		return new BddTestFieldDecorator(new AjaxElementLocatorFactory(webDriver, 30));
	}

	@Bean
	public BasePage getBasePage(WebDriver webDriver, FieldDecorator decorator) {
		return new BasePage(webDriver, decorator);
	}
	
	@Bean
	public BddTestWebDriverEventListener getEventListener(BasePage currentPage) {
		return new BddTestWebDriverEventListener(currentPage);
	}	

}
