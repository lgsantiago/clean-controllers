public class CleanControllers {

	/*Dirty Controller Method*/
	@RequestMapping(value = “/hospital/{id}”, method = RequestMethod.GET)
	public ResponseEntity<Hospital> getHospital(@PathVariable(“id”) long id){
		logger.info(“Getting Hospital with id {}”, id);
		Hospital hospital = hospitalService.findById(id);

		 if (hospital == null) {
		 	logger.error(“Hospital not found. Id: {}”, id);
		 	return new ResponseEntity(new EntityError("Hospital not found")), HttpStatus.NOT_FOUND);
		 }

	 	return new ResponseEntity<Hospital>(hospital, HttpStatus.OK);
	}

	/*Clean Controller Method*/
	@GetMapping("/hospital/{id}")
	public ResponseEntity<Hospital> getHospital(@PathVariable(“id”) long id) {
		return hospitalService.getHospital(id);
	}

}