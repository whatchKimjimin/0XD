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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;

import co.kr.soboat.service.UsersService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired
	private UsersService usersService;
	
	// RESULT
	Map<String , String> result;
	
	@RequestMapping(value = "",produces="application/json", method = RequestMethod.POST)
	public @ResponseBody Map<String, String> userJoin(@RequestBody Map<String, String> reqParam) {
		System.err.println("JOIN");
		return usersService.userJoin(reqParam);
	}
	
	@RequestMapping(value = "",produces="application/json", method = RequestMethod.GET)
	public @ResponseBody Map<String, String> userLogin(@RequestParam Map<String, String> reqParam) {
		System.err.println("LOGIN");
		return usersService.userLogin(reqParam);
	}
	
	@RequestMapping(value = "/{USER_PM_KEY}",produces="application/json", method = RequestMethod.GET)
	public @ResponseBody Map<String, String> getUserData(@PathVariable(value="USER_PM_KEY") int USER_PM_KEY) throws JsonProcessingException {
		return usersService.getUserData(USER_PM_KEY);
	}
	
	
	
}
