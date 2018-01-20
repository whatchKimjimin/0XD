package co.kr.soboat;

import java.util.Iterator;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fasterxml.jackson.core.JsonProcessingException;

import co.kr.soboat.service.BoatsService;

@Controller
@RequestMapping(value = "/boat")
public class BoatController {
	private static final Logger logger = LoggerFactory.getLogger(BoatController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired
	private BoatsService boatsService;
	
	// RESULT
	Map<String , String> result;
	
	@RequestMapping(value = "",produces="application/json", method = RequestMethod.POST)
	public @ResponseBody Map<String, String> insertBoat(@RequestBody Map<String, String> reqParam) {
		System.err.println("BOATS INSERT");
		return boatsService.insertBoat(reqParam);
	}

	@RequestMapping(value = "/{BOATS_PM_KEY}",produces="application/json", method = RequestMethod.DELETE)
	public @ResponseBody Map<String, String> deleteBoat(@PathVariable(value="BOATS_PM_KEY") int USER_PM_KEY) {
		System.err.println("BOATS DELETE");
		return boatsService.deleteBoat(USER_PM_KEY);
	}
	
	@RequestMapping(value = "/search/{KEYWORD}",produces="application/json", method = RequestMethod.GET)
	public @ResponseBody Map<String, String> insertBoat(@PathVariable(value="KEYWORD") String KEYWORD) throws JsonProcessingException {
		System.err.println("BOATS SEARCH");
		return boatsService.positionSearchBoat(KEYWORD);
	}
	
	@RequestMapping(value = "/{BOATS_ID}",produces="application/json", method = RequestMethod.GET)
	public @ResponseBody Map<String, String> detailBoat(@PathVariable(value="BOATS_ID") int BOATS_ID) throws JsonProcessingException {
		System.out.println("BOAT DETAIL");
		return boatsService.boatDetail(BOATS_ID);
	}
	
}
