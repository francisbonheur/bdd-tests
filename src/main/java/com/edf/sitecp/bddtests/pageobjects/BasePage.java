package com.edf.sitecp.bddtests.pageobjects;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.pagefactory.FieldDecorator;
import org.springframework.beans.factory.annotation.Autowired;

import com.edf.sitecp.bddtests.constants.BddTestsConstants;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BasePage {

	@FindBys(
		@FindBy(css=BddTestsConstants.DATA_TNR_ATTRIBUTE_CSS_SELECTOR)
	)
	private Map<String,WebElement> elements; 
	private String pageUrl;
	
	
	private WebDriver webDriver;
	
	private EventFiringWebDriver eventDriver;
	
	private FieldDecorator decorator;
	
	@Autowired
	public BasePage(WebDriver webDriver, FieldDecorator decorator) {
		this.webDriver = webDriver;
		this.decorator = decorator;
		eventDriver = new EventFiringWebDriver(webDriver);
	}
	
	public void open(String url) {
		this.pageUrl = url;
		eventDriver.get(url);
	}
}
