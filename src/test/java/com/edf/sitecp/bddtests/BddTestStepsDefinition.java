package com.edf.sitecp.bddtests;

import static org.junit.Assert.assertTrue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.edf.sitecp.bddtests.pageobjects.BasePage;

import io.cucumber.java.After;
import io.cucumber.java.en.When;

public class BddTestStepsDefinition extends BddTestsApplicationTests {
	
	private static final Logger LOG = LoggerFactory.getLogger(BddTestsApplicationTests.class);
	
	@Autowired
	private BasePage currentPage;
		
	@After
	public void tearDown()
	{
		currentPage.getWebDriver().quit();
	}

	@When("^Je suis sur la page (.*)$")
	public void jeSuisSurLaPage(String url) {
		currentPage.open(url);
		assertTrue(currentPage.getWebDriver().getCurrentUrl().replaceAll("/$", "").equals(url));
	}
	
	@When("^La zone (.*) est affichee") 
	public void laZoneEstAffichee(String nomZone) {
		assertTrue((currentPage.getElements().get(nomZone) != null));	
	}

	@When("^La zone (.*) n'est pas affichee") 
	public void laZoneNEstPasAffichee(String nomZone) {
		assertTrue((currentPage.getElements().get(nomZone) == null));	
	}
}
