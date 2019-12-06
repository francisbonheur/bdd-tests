package com.edf.sitecp.bddtests;

import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest
@ContextConfiguration(
		classes = {BddTestsApplication.class}, 
		loader = SpringBootContextLoader.class, 
		initializers = ConfigFileApplicationContextInitializer.class
)
@WebAppConfiguration
class BddTestsApplicationTests {
}
