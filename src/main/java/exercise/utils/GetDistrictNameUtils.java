package exercise.utils;

import java.util.HashMap;
import java.util.Map;

public class GetDistrictNameUtils {
	public static Map<Integer,String> getDistrictName(){
		Map<Integer,String> results = new HashMap<>();
		results.put(1, "Quận 1");
		results.put(2, "Quận 2");
		results.put(3, "Quận 4");
		return results;
	}
}
