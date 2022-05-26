package com.exercise.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.exercise.controller.BuildingController;
import com.exercise.model.dto.BuildingDTO;
import com.exercise.model.output.BuildingOutput;

public class BuildingListView {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		BuildingDTO buildingDTO = new BuildingDTO();
		System.out.println("============INPUT==============");
		System.out.print("Id : ");
		String id = input.nextLine();
		buildingDTO.setId(id);
		System.out.print("Name : ");
		String name = input.nextLine();
		buildingDTO.setName(name);
		System.out.print("Street : ");
		String street = input.nextLine();
		buildingDTO.setStreet(street);
		System.out.print("Ward : ");
		String ward = input.nextLine();
		buildingDTO.setWard(ward);
		System.out.print("District : ");
		String district = input.nextLine();
		buildingDTO.setDistrict(district);
		System.out.print("Floorarea : ");
		Integer floorarea = input.nextInt();
		input.nextLine();
		buildingDTO.setFloorarea(floorarea);
		System.out.println("============OUTPUT==============");
		BuildingController buildingController = new BuildingController();
		ArrayList<BuildingOutput> buildingOutputs = buildingController.findBuilding(buildingDTO);
		showBuildingOutput(buildingOutputs);

	}

	public static void showBuildingOutput(ArrayList<BuildingOutput> buildingOutputs) {
		for (BuildingOutput item : buildingOutputs) {
			System.out.println("ID : " + item.getId() + " -  Name : " + item.getName());
			System.out.println("Adress : " + item.getAddress());
			System.out.println("Floorarea : " + item.getFloorarea());
			System.out.println("Type : " + item.getType());
			System.out.println("=================================");
		}
	}
}