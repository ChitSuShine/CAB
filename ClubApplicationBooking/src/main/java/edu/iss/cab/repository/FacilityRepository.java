package edu.iss.cab.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import edu.iss.cab.model.Facility;

public interface FacilityRepository extends JpaRepository<Facility, String> {
	@Query(value = "SELECT * FROM facility WHERE status = 0", nativeQuery = true)
	ArrayList<Facility> findAllAvailableFacilities();

	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("UPDATE Facility SET status = 1 WHERE facilityId = ?1")
	void setDeleteStatus(String facilityId);
}
