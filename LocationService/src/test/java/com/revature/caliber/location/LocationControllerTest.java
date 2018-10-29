package com.revature.caliber.location;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import com.revature.caliber.controllers.LocationController;
import com.revature.caliber.location.domain.Location;
import com.revature.caliber.location.service.LocationService;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@RunWith(MockitoJUnitRunner.class)
public class LocationControllerTest {

	private static final Logger log = Logger.getLogger(LocationControllerTest.class);

	@Mock
	static LocationService lsMock;

	@InjectMocks
	static LocationController lcMock;

	private static final Location l1 = new Location(1, "Revature", "Tampa", "11111", "1223 Sesame St", "Florida", true);
	private static final Location l2 = new Location(2, "Congizant", "Dallas", "22222", "1313 Elm St", "Texas", false);

	private static List<Location> lList;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		RestAssured.port = 9000;
		lList = new ArrayList<>();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		lList.clear();
		lList.add(l1);
		lList.add(l2);

		org.mockito.Mockito.when(lsMock.getAllLocations()).thenReturn(lList);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testtest() {
		assertTrue(true);
	}

	@Test
	public void testCreateLocation() {
		log.debug("Create Location test");

		lcMock.createLocation(l1);
		verify(lsMock).createLocation(l1);
	}

	@Test
	public void testGetAllLoctions() {
		log.debug("Get all test");

		List<Location> locList = lcMock.getAllLocations().getBody();
		assertEquals(l1, locList.get(0));
		assertEquals(l2, locList.get(1));
	}

	@Test
	public void testUpdateLocation() {
		log.debug("Update Location test");

		lcMock.updateLocation(l1);
		verify(lsMock).updateLocation(l1);
	}

	@Test
	public void testDelete() {
		log.debug("Delete Location test");

		lcMock.deleteLocation(l1);
		verify(lsMock).updateLocation(l1);
	}

	@Test
	public void testGetAllReturnsOkStatusCode() {
		log.debug("Http test, get all");

		given().

				standaloneSetup(lcMock).contentType(ContentType.JSON).

				when().

				get("/all/location/all").

				then().

				statusCode(200);
	}

	@Test
	public void testCreateReturnsCreatedStatusCode() {
		log.debug("Http test, create location");

		given().

				standaloneSetup(lcMock).contentType(ContentType.JSON).body(l1).

				when().

				post("/vp/location/create").

				then().

				statusCode(201);
	}

	@Test
	public void testUpdateReturnsCreatedStatusCode() {
		log.debug("Http test, update location");

		given().

				standaloneSetup(lcMock).contentType(ContentType.JSON).body(l1).

				when().

				put("/vp/location/update").

				then().

				statusCode(204);
	}

	@Test
	public void testDeleteReturnsCreatedStatusCode() {
		log.debug("Http test, delete location");

		given().

				standaloneSetup(lcMock).contentType(ContentType.JSON).body(l1).

				when().

				delete("/vp/location/delete").

				then().

				statusCode(204);
	}

	@Test
	public void testReactivateReturnsCreatedStatusCode() {
		log.debug("Http test, reactivate location");

		given().

				standaloneSetup(lcMock).contentType(ContentType.JSON).body(l1).

				when().

				put("/vp/location/reactivate").

				then().

				statusCode(204);
	}
}
