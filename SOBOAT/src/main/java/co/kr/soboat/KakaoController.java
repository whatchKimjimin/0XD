package co.kr.soboat;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/kakao")
public class KakaoController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/ouath",produces="application/json", method = RequestMethod.GET)
	public @ResponseBody Map<String, String> kakaoOuath(@RequestParam Map<String, String> reqParam) {
		System.out.println(reqParam.get("code"));
		return null;
	}
	
	@RequestMapping(value = "/ouath/token",produces="application/json", method = {RequestMethod.GET , RequestMethod.POST})
	public @ResponseBody Map<String, String> kakaoOuathToken(@RequestBody Map<String, String> reqParam) {
		System.out.println(reqParam.get("access_token"));
		return null;
	}
	
}
