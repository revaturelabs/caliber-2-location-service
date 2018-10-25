package com.revature.caliber.location;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.revature.caliber.location.dao.LocationRepository;
import com.revature.caliber.location.domain.Location;
import com.revature.caliber.location.service.LocationServiceImpl;

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
		this.l = new Location(1, "Reavature", "Tampa", "11111", "123 Sesame St", "Florida", true);
		
		this.lList.addAll(Arrays.asList(new Location[] {this.l, new Location()}));
		
		when(lr.findAll()).thenReturn(this.lList);
		
		//when(lr.findById(1)).thenReturn(this.l);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateLocation() {
		ls.createLocation(this.l);
		verify(lr).save(l);
	}

	@Test
	public void testGetAllLocations() {
		assertEquals("Should get whole list of locations", this.lList, this.ls.getAllLocations());
	}
	
	@Test
	public void testGetALocation() {
		assertEquals("Should get single location",this.l, this.ls.getLocation(1));
	}
	
	@Test
	public void testUpdateLocation() {
		ls.updateLocation(this.l);
		verify(lr).save(l);
	}
	
	@Test
	public void testDeleteLocation() {
		ls.deleteLocation(this.l);
		verify(lr).delete(l);
	}
	
}
