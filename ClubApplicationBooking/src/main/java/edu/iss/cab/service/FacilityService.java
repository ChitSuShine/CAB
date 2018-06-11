package edu.iss.cab.service;

import java.util.ArrayList;

import edu.iss.cab.model.Facility;

public interface FacilityService {

	ArrayList<Facility> findAllFacilitiesWithStatus();

	Facility findFacility(String facilityId);

	Facility createFacility(Facility facility);

	Facility updateFacility(Facility facility);

	void removeFacility(Facility facility);

}