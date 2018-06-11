package edu.iss.cab.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import edu.iss.cab.controllers.CommonController;
import edu.iss.cab.model.Facility;

//CHIT SU SHINE
@Component
public class FacilityValidator implements Validator {

	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Facility.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Facility facility = (Facility) target;
		ValidationUtils.rejectIfEmpty(errors, "facilityName", "error.facility.facilityId.empty");
		ValidationUtils.rejectIfEmpty(errors, "price", "error.facility.price.empty");

		logger.info("Facility: " + facility.toString());
	}

}
