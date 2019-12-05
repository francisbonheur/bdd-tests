package com.edf.sitecp.bddtests.pageobjects;

import java.awt.List;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

public class BddTestFieldDecorator extends DefaultFieldDecorator {

	BddTestFieldDecorator(ElementLocatorFactory factory) {
		super(factory);
	}
	
	 @Override
	 public Object decorate(ClassLoader loader, Field field) {
		 if(!(WebElement.class.isAssignableFrom(field.getType()) 
				 || isDecoratableList(field))) {
			 return null;
		 }
		 
		 ElementLocator locator = factory.createLocator(field);
		 
		 if(WebElement.class.isAssignableFrom(field.getType())) {
			 return proxyForListLocator(loader, locator);
		 } else if(List.class.isAssignableFrom(field.getType())) {
			 return customProxyForListLocator(loader, locator);
		 } else {
			 return null;
		 }
	 }
	 
	 
	 protected Map<String,WebElement> customProxyForListLocator(ClassLoader loader, ElementLocator locator) {
		 InvocationHandler handler = new BddTestsListToMapInvocationHandler(locator);
		 
		 Map<String,WebElement> proxy;
		 proxy = (Map<String,WebElement>) Proxy.newProxyInstance(loader, new Class[] {Map.class}, handler);
		 
		 return proxy;
	 }

}
