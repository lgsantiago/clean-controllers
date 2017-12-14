public class HospitalService{

	public ResponseEntity<Hospital> getHospital(long id) {
		logger.info(“Getting Hospital with id {}”, id);
 		Hospital hospital = hospitalRepository.findById(id);
 		return extractHospital(hospital);
 	}

	public ResponseEntity<Hospital> extractHospital(hospital){
		 if (hospital == null) {
		  logger.error(“Hospital not found. Id: {}”, id);
		  return new ResponseEntity(new EntityError("Hospital not found")), HttpStatus.NOT_FOUND);
		 }

		return new ResponseEntity<Hospital>(hospital, HttpStatus.OK);
	}
	
}