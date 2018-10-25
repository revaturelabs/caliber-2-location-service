package com.revature.caliber.location.service;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.caliber.location.dao.LocationRepository;
import com.revature.caliber.location.domain.Location;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	LocationRepository lr;
	
	private static final Logger log = Logger.getLogger(LocationServiceImpl.class);
	
	@Override
	public void createLocation(Location l) {
		log.debug("Create location: " + l);

	}

	@Override
	public List<Location> getAllLocations() {		
		return lr.findAll();
	}

	@Override
	public Location getLocation(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateLocation(Location l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteLocation(Location l) {
		// TODO Auto-generated method stub

	}

}
