package com.revature.caliber.location.service;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.caliber.location.dao.LocationRepository;
import com.revature.caliber.location.domain.Location;

/**
 * 
 * @author Jason Martinez, Aric Rhodes
 * 
 *         Service class for communications with repository.
 *
 */
@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	LocationRepository lr;

	private static final Logger log = Logger.getLogger(LocationServiceImpl.class);

	/**
	 * Adds a new Location entity to the database
	 * 
	 * @param l - the location to be added to the database
	 */
	@Override
	public void createLocation(Location l) {
		log.debug("Create location: " + l);
		lr.save(l);
	}

	/**
	 * Gets all locations
	 * 
	 * @return - returns all Location items from the database
	 */
	@Override
	public List<Location> getAllLocations() {
		log.debug("Getting all locations");
		return lr.findAll();
	}

	/**
	 * Gets a single Location, searches by Location id
	 * 
	 * @param - id - the id the Location to be retrieved
	 * 
	 * @return - a Location with matching id, if one exists, else null
	 */
	@Override
	public Location getLocation(int id) {
		log.debug("Got a location with id: " + id);
		Location l = lr.getOne(id);
		log.debug("Got location: " + l.toString());
		return l;
	}

	/**
	 * Updates a Location entity passed in, preserving the Location id
	 * 
	 * @param - l - the Location entity to be updated
	 */
	@Override
	public void updateLocation(Location l) {
		log.debug("Updating location: " + l);
		lr.save(l);
	}

	/**
	 * Deletes a location from the database
	 * 
	 * @param - l - the Location to be deleted
	 */
	@Override
	public void deleteLocation(Location l) {
		log.debug("Deleting location: " + l);
		lr.delete(l);
	}

}
