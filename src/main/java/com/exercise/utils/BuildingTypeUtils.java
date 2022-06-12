package com.exercise.utils;

import java.util.HashMap;
import java.util.Map;

import com.exercise.constant.SystemConstant;

public class BuildingTypeUtils {
	public static Map<String,String> getBuildingType(){
		Map<String, String> results = new HashMap<String, String>();
		results.put(SystemConstant.NGUYEN_CAN_CODE, SystemConstant.NGUYEN_CAN);
		results.put(SystemConstant.NOI_THAT_CODE, SystemConstant.NOI_THAT);
		results.put(SystemConstant.TANG_TRET_CODE, SystemConstant.TANG_TRET);
		return results;
	}
	
	
}
