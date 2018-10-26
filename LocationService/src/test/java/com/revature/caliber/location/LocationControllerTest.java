package com.revature.caliber.location;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.http.Method.GET;

import io.restassured.RestAssured;
import io.restassured.module.mockmvc.RestAssuredMockMvc;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.caliber.controllers.LocationController;
import com.revature.caliber.location.dao.LocationRepository;
import com.revature.caliber.location.domain.Location;

@RunWith(SpringJUnit4ClassRunner.class)
public class LocationControllerTest {
	
	private static final Logger log = Logger.getLogger(LocationControllerTest.class);
	
	private String createLocationTest = "vp/location/create";
    private String updateLocationTest = "vp/location/update";
    private String getAllLocationTest = "all/location/all";
    private String removeLocationTest = "vp/location/delete";
    private String reactivateLocationTest = "vp/location/reactivate";
    private String baseUrl = "http://localhost:9000";
    
    private static final Location l1 = new Location(1,"Revature", "Tampa", "11111", "1223 Sesame St", "Florida", true);
    private static final Location l2 = new Location(2, "Congizant", "Dallas", "22222", "1313 Elm St", "Texas", false);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		RestAssured.port = 9000;
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
	public void testtest() {
		assertTrue(true);
	}

	@Test
	public void test() {
		given().
		
			standaloneSetup(new LocationController()).
	        
		when().
			
			request("get", "/all/location/all").
			
		then().
			
			statusCode(200);
	}

	/*@Test
	public void testCreateLocation() {
		log.debug("Create location test");
		Location loc1 = this.l1;
		loc1.setId(20);
		given().
		
			contentType(ContentType.JSON).
			body(loc1).
			
		when()
		
			.post(baseUrl + createLocationTest).
		
		then().
		
			assertThat().
			
				statusCode(201);
	}

	@Test
	public void testGetAllLoctions() throws JsonProcessingException {
		log.debug("Get all test");
		Location loc1 = this.l1;
		Location loc2 = this.l2;
		given().
			
			contentType(ContentType.JSON).
			
		when().
		
			get(baseUrl + getAllLocationTest).
			
		then().
		
			assertThat().
			
				statusCode(200).
				body(matchesJsonSchema(new ObjectMapper().writeValueAsString(loc1))).
				body(matchesJsonSchema(new ObjectMapper().writeValueAsString(loc2)));
	}
	
	@Test
	public void testUpdateLocation() {
		log.debug("Update location test");
		Location loc1 = this.l1;
		loc1.setAddress("123 Whatever Blvd");
		given().
		
			contentType(ContentType.JSON).
			
		when().
		
			put(baseUrl + updateLocationTest).
			
		then().
		
			assertThat().
			
				statusCode(204);  //not done
	}
	*/
}
