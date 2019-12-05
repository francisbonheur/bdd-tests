package com.edf.sitecp.bddtests;

import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = BddTestsApplication.class, loader = SpringBootContextLoader.class)
class BddTestsApplicationTests {



}
