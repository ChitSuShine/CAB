package edu.iss.cab.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.iss.cab.model.Facility;
import edu.iss.cab.repository.FacilityRepository;

@Service
public class FacilityServiceImpl implements FacilityService {

	@Resource
	FacilityRepository facilityRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.iss.cab.service.FacilityService#findDepartment(java.lang.String)
	 */
	@Override
	@Transactional
	public Facility findFacility(String facilityId) {
		return facilityRepository.findOne(facilityId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.iss.cab.service.FacilityService#createFacility(edu.iss.cab.model.
	 * Facility)
	 */
	@Override
	@Transactional
	public Facility createFacility(Facility facility) {
		return facilityRepository.saveAndFlush(facility);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.iss.cab.service.FacilityService#updateFacility(edu.iss.cab.model.
	 * Facility)
	 */
	@Override
	@Transactional
	public Facility updateFacility(Facility facility) {
		return facilityRepository.saveAndFlush(facility);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.iss.cab.service.FacilityService#removeFacility(edu.iss.cab.model.
	 * Facility)
	 */
	@Override
	public void removeFacility(Facility facility) {
		facilityRepository.setDeleteStatus(facility.getFacilityId());
	}

	@Override
	public ArrayList<Facility> findAllFacilitiesWithStatus() {
		// TODO Auto-generated method stub
		return facilityRepository.findAllAvailableFacilities();
	}
}
