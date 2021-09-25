package com.vco.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vco.project.exception.ResourceNotFoundException;
import com.vco.project.model.EmployeeDTO;
import com.vco.project.model.LocationDTO;
import com.vco.project.repository.EmployeeRepository;
import com.vco.project.repository.LocationRepository;

@RestController            //This annotation will specify the creation of RESTFUL web services.
@RequestMapping("/api/v1")// This annotation can be used both at the class and at the method level. In most cases, at the method level applications willprefer to use one of the HTTP method specific variants

public class LocationController {
	@Autowired            //This annotation is used to inject the object dependency implicitly
	   
    private LocationRepository locationRepository;
   
	//Get all the locations
	   
    @GetMapping("/locations")
    public List<LocationDTO> getAllLocations() {
        return locationRepository.findAll();
    }

    //get a particular location with id
    @GetMapping("/locations/{id}")
    public ResponseEntity<LocationDTO> getLocationById(@PathVariable(value = "id") Integer LocationId)
        throws ResourceNotFoundException {
    	LocationDTO location = locationRepository.findById(LocationId)
          .orElseThrow(() -> new ResourceNotFoundException("Location not found for this id :: " + LocationId));
        return ResponseEntity.ok().body(location);
    }
    //insert a location
    @PostMapping("/locations")
    public  LocationDTO createLocation(@Valid @RequestBody LocationDTO location) {
        return locationRepository.save(location);
    }
//update a location
    @PutMapping("/locations/{id}")
    public ResponseEntity<LocationDTO> updateLocation(@PathVariable(value = "id") Integer LocationId,
         @Valid @RequestBody LocationDTO locationDetails) throws ResourceNotFoundException {
    	LocationDTO location = locationRepository.findById(LocationId)
        .orElseThrow(() -> new ResourceNotFoundException("location not found for this id :: " + LocationId));

    	//location.setLocationId(locationDetails.getLocationId());
    	location.setLocationCode(locationDetails.getLocationCode());
      location.setLocationName(locationDetails.getLocationName());
      location.setLocationAddress(locationDetails.getLocationAddress());
  	location.setLocationCity(locationDetails.getLocationCity());
	location.setLocationZip(locationDetails.getLocationZip());
	location.setLocationState(locationDetails.getLocationState());
	location.setLocationCountry(locationDetails.getLocationCountry());

        final LocationDTO updatedLocation = locationRepository.save(location);
        return ResponseEntity.ok(updatedLocation);
    }
    //delete a particular location with id
    @DeleteMapping("/locations/{id}")
    public Map<String, Boolean> deleteLocation(@PathVariable(value = "id") Integer LocationId)
         throws ResourceNotFoundException {
    	LocationDTO location = locationRepository.findById(LocationId)
       .orElseThrow(() -> new ResourceNotFoundException("location not found for this id :: " + LocationId));

    	locationRepository.delete(location);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    
}
