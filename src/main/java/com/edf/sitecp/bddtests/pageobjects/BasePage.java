package com.edf.sitecp.bddtests.pageobjects;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import com.edf.sitecp.bddtests.constants.BddTestsConstants;

import lombok.Getter;

@Getter
public class BasePage {

	@FindBys(
		@FindBy(css=BddTestsConstants.DATA_TNR_ATTRIBUTE_CSS_SELECTOR)
	)
	private Map<String,WebElement> elements; 
	
	private String pageUrl;
	
	public WebDriver webDriver;
	
	public BasePage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(new BddTestFieldDecorator(new DefaultElementLocatorFactory(webDriver)), this);
	}
	
	public void open(String url) {
		this.pageUrl = url;
		webDriver.get(url);
	}
}
