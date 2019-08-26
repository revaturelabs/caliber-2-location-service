package com.revature.caliber.location;

import com.revature.caliber.location.dao.LocationRepository;
import com.revature.caliber.location.domain.Location;
import com.revature.caliber.location.service.LocationServiceImpl;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LocationServiceImplTest {

	@Mock
	LocationRepository lr;
	
	@InjectMocks
	LocationServiceImpl ls;
	
	private static Location l;
	
	private static List<Location> lList;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		lList = new ArrayList<Location>();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		ls = new LocationServiceImpl(lr);

		l = new Location(1, "Reavature", "Tampa", "11111", "123 Sesame St", "Florida", true);
		
		lList.addAll(Arrays.asList(new Location[] {l, new Location()}));
		
		when(lr.findAll()).thenReturn(lList);
		
		when(lr.getOne(1)).thenReturn(l);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateLocation() {
		ls.createLocation(l);
		verify(lr).save(l);
	}

	@Test
	public void testGetAllLocations() {
		assertEquals("Should get whole list of locations", lList, this.ls.getAllLocations());
	}

	@Ignore
	@Test
	public void testGetALocation() {
		assertEquals("Should get single location",l, this.ls.getLocation(1));
	}
	
	@Test
	public void testUpdateLocation() {
		ls.updateLocation(l);
		verify(lr).save(l);
	}
	
	@Test
	public void testDeleteLocation() {
		ls.deleteLocation(l);
		verify(lr).delete(l);
	}
	
}
