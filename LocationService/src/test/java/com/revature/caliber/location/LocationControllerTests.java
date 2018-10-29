package com.revature.caliber.location;

import static org.junit.Assert.*;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.caliber.controllers.LocationController;

@RunWith(SpringJUnit4ClassRunner.class)
public class LocationControllerTests {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		given().standaloneSetup(new LocationController()).when().get("/all/location/all").then().statusCode(200);
	}

}
