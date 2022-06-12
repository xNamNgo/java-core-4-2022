package com.exercise.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.exercise.controller.BuildingController;
import com.exercise.model.dto.BuildingDTO;
import com.exercise.model.input.BuildingSearchInput;
import com.exercise.model.output.BuildingOutput;

public class BuildingListView {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		BuildingSearchInput buildingSearchInput = new BuildingSearchInput();

		System.out.println("============INPUT==============");
		System.out.print("Name : ");
		buildingSearchInput.setName(input.nextLine());
		System.out.print("Street : ");
		buildingSearchInput.setStreet(input.nextLine());
		System.out.print("Ward : ");
		buildingSearchInput.setWard(input.nextLine());
		System.out.print("District : ");
		buildingSearchInput.setDistrict(input.nextLine());
		System.out.print("Floorarea : ");
		buildingSearchInput.setFloorArea(Integer.parseInt(input.nextLine()));
		
		System.out.println("============OUTPUT==============");
		BuildingController buildingController = new BuildingController();
		List<BuildingOutput> buildingOutputs = buildingController.findBuilding(buildingSearchInput);
		if (buildingOutputs.size() > 0) {
			showBuildingOutput(buildingOutputs);
		} else {
			System.out.println("Không tìm thấy kết quả!");
		}

	}

	public static void showBuildingOutput(List<BuildingOutput> buildingOutputs) {
		for (BuildingOutput item : buildingOutputs) {
			System.out.println("ID : " + item.getId() + " -  Name : " + item.getName());
			System.out.println("Adress : " + item.getAddress());
			System.out.println("Floorarea : " + item.getFloorarea());
			System.out.println("Type : " + item.getType());
			System.out.println("=================================");
		}
	}
}