package com.edf.sitecp.bddtests.pageobjects;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	private FieldDecorator decorator;
	
	public BasePage(WebDriver webDriver) {
		this.webDriver = webDriver;
		this.decorator = new BddTestFieldDecorator(new DefaultElementLocatorFactory(webDriver));
		PageFactory.initElements(decorator, this);
	}
	
	public void open(String url) {
		this.pageUrl = url;
		webDriver.get(url);
	}
}
