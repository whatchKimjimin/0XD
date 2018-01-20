package co.kr.soboat.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import co.kr.soboat.dao.RentalDao;
import co.kr.soboat.service.RentalService;

@Service("RentalService")
public class RentalServiceImpl implements RentalService{

	@Resource(name = "RentalDao")
	RentalDao rentalDao;
	
	// RESULT
	Map<String , String> result;
	
	@Override
	public Map<String, String> boatRental(Map<String, String> reqParam) {
		// RESULT SETTING
		this.result = new HashMap<String , String>();
		// RENTAL CHECK
		if( rentalDao.boatRentalCheck(reqParam) == 0 ) {
			// RENTAL
			if( rentalDao.boatRental(reqParam) == 1) {
				result.put("success", "true");
			} else {
				result.put("success", "false");
				result.put("message", "RENTAL FAIL");
			}
		} else {
			result.put("success", "false");
			result.put("message", "DATE CHANGE PLZ");
		}
		
		
		return result;
	}
	
}
