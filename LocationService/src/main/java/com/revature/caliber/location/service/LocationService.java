package com.revature.caliber.location.service;

import java.util.List;

import com.revature.caliber.location.domain.Location;

public interface LocationService {

	public void createLocation(Location l);
	
	public List<Location> getAllLocations();
	
	public Location getLocation(int id);
	
	public void updateLocation(Location l);
	
	public void deleteLocation(Location l);
}
