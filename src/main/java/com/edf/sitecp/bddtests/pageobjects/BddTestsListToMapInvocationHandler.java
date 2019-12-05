package com.edf.sitecp.bddtests.pageobjects;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import com.edf.sitecp.bddtests.constants.BddTestsConstants;

public class BddTestsListToMapInvocationHandler implements InvocationHandler {
	
	private final ElementLocator locator;
	
	public BddTestsListToMapInvocationHandler(ElementLocator locator) {
		this.locator = locator;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		List<WebElement> elements = locator.findElements();
		
		Map<String, WebElement> mapElements = new HashMap<String, WebElement>();
		
		for(WebElement element : elements) {
			mapElements.put(element.getAttribute(BddTestsConstants.DATA_TNR_ATTRIBUTE), element);
		}
		
		return method.invoke(mapElements, proxy);
	}

}
