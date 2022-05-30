package com.exercise.utils;

public class TypeBuildingUtils {
	public static StringBuilder formatType(String type) {
		String[] typeSplit = type.split(",");
		StringBuilder formart = new StringBuilder();
		for (int i = 0; i < typeSplit.length; i++) {
			if (typeSplit[i].equals("tang-tret")) {
				formart.append("Tầng trệt");
			}
			if (typeSplit[i].equals("nguyen-can")) {
				formart.append("Nguyên căn");
			}
			if (typeSplit[i].equals("noi-that")) {
				formart.append("Nội thất");
			}
			if (i < (typeSplit.length - 1)) {
				formart.append(" , ");
			}
		}
		return formart;
	}
}
