package co.kr.soboat;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;

import co.kr.soboat.service.RentalService;

@Controller
@RequestMapping(value = "/rental")
public class RentalController {
	private static final Logger logger = LoggerFactory.getLogger(RentalController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired
	private RentalService RentalService;
	
	// RESULT
	Map<String , String> result;
	
	@RequestMapping(value = "",produces="application/json", method = RequestMethod.POST)
	public @ResponseBody Map<String, String> insertBoat(@RequestBody Map<String, String> reqParam) {
		System.err.println("BOAT RENTAL");
		return RentalService.boatRental(reqParam);
	}
	
	
	
}
