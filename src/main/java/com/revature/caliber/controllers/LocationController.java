package com.revature.caliber.controllers;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.caliber.location.domain.Location;
import com.revature.caliber.location.service.LocationService;

/**
 * 
 * @author Jason Martinez, Aric Rhodes
 * 
 *         Controller for performing CRUD methods on Locations, used to populate
 *         UI lists.
 *
 */
@RestController
@CrossOrigin(value = "*")
public class LocationController {

	private static Logger log = Logger.getLogger(LocationController.class);

	@Autowired
	LocationService ls;

	/**
	 * Waits for http request and calls the LocationService method createLocation()
	 * to save the location to the database
	 * 
	 * @param l
	 * 
	 * @return http response: CREATED
	 */
	@PostMapping(value = "vp/location/create", consumes = MediaType.APPLICATION_JSON_VALUE)
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public ResponseEntity<Location> createLocation(@Valid @RequestBody Location l) {
		log.debug("Saving new location:" + l);
		ls.createLocation(l);
		return new ResponseEntity<>(l, HttpStatus.CREATED);
	}

	/**
	 * Returns all Locations for the database
	 * 
	 * @return lList - a List object with all the Location entities from the
	 *         database
	 */
	@GetMapping(value = "all/location/all", produces = MediaType.APPLICATION_JSON_VALUE)
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public ResponseEntity<List<Location>> getAllLocations() {
		log.debug("Getting all locations from the database");
		List<Location> lList = ls.getAllLocations();
        if (lList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
		return new ResponseEntity<>(lList, HttpStatus.OK);
	}
	
	/**
	 * Returns a string version of a single Location object from the database
	 * 
	 * @param id - the id of the Location object to be returned
	 * 
	 * @return - Returns a string of the location object with the id provided
	 */
	@GetMapping(value = "all/location/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public ResponseEntity<String> getLocationById(@PathVariable(name="id") Integer id) {
		log.debug("Getting one Location object with id: " + id);
		return new ResponseEntity<>(ls.getLocation(id).toString(), HttpStatus.OK);
	}

	/**
	 * Updates a Location entry in the database
	 * 
	 * @param - l - the Location entry to be updated
	 * 
	 * @return - returns an http status code: NO_CONTENT
	 */
	@PutMapping(value = "vp/location/update", consumes = MediaType.APPLICATION_JSON_VALUE)
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public ResponseEntity<Void> updateLocation(@Valid @RequestBody Location l) {
		log.debug("Updating a location: " + l);
		ls.updateLocation(l);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	/**
	 * Deletes a Location entry from the database, soft delete, sets Location active
	 * field to false
	 * 
	 * @param - l - the Location entry to be deleted
	 * 
	 * @return returns an http status code: NO_CONTENT
	 */
	@DeleteMapping(value = "vp/location/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public ResponseEntity<Void> deleteLocation(@Valid @RequestBody Location l) {
		log.debug("Deactivating a location:  " + l);
		ls.updateLocation(l);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	/**
	 * Sets Location active field to true
	 * 
	 * @param - l - the Location entry to be reactivated
	 * 
	 * @return returns an http status code: NO_CONTENT
	 */
	@PutMapping(value = "vp/location/reactivate", consumes = MediaType.APPLICATION_JSON_VALUE)
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public ResponseEntity<Void> reactivateLocation(@Valid @RequestBody Location l) {
		log.debug("Reactivating a location:  " + l);
		ls.updateLocation(l);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
