package co.kr.soboat.dao;

import java.util.Map;

public interface RentalDao {
	// BOAT RENTAL
	public int boatRental(Map<String , String> reqParam);
	// BOAT RENTAL CHECK
	public int boatRentalCheck(Map<String , String> reqParam);
}
