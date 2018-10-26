package com.mst.parkinglot.resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mst.parkinglot.entity.Car;
import com.mst.parkinglot.model.ParkingModel;
import com.mst.parkinglot.parkingservice.ParkingDAO;
import com.mst.parkinglot.repository.UsersRepository;
import com.mst.parkinglot.response.ParkingLotResponse;

@RestController
@RequestMapping(value = "/api")
public class UsersResource {

	@Autowired
	ParkingDAO parkingDAO;
	// ParkingDAO parkingDAO;
	@Autowired
	ParkingModel parkingModel;
	@Autowired
	UsersRepository UsersRepository;

	@GetMapping(value = "/parking")
	public ParkingLotResponse getParking() {
		Map<String, Integer> map = parkingDAO.getParkingLot();

		ParkingLotResponse parkingLotResponse = new ParkingLotResponse();
		if (map.isEmpty()) {
			parkingLotResponse.setAvailable(false);
		} else {
			parkingLotResponse.setLevel(map.get("level"));
			parkingLotResponse.setSlot(map.get("slot"));
			parkingLotResponse.setAvailable(true);
		}
		return parkingLotResponse;
	}

	@PostMapping(value = "/parking")
	public Map<String, Boolean> reserveParking(@RequestBody Car car) {
		Map<String, Boolean> map = new HashMap<>();

		Car c = UsersRepository.save(car);
		parkingModel.reserveParking(c.getLevel(), c.getSlot());
		if (c.equals(c)) {
			map.put("Status", true);
			return map;
		} else {
			map.put("Status", false);
		}
		return map;
	}

	@DeleteMapping(value = "/parking")
	public Map<String, Boolean> freeParking(@RequestBody Car car) {
		Map<String, Boolean> map = new HashMap<>();
		String registrationNumber = car.getRegistrationNumber();

		Car c = UsersRepository.findByRegistrationNumber(registrationNumber);
		if (c.equals(c)) {
			parkingModel.freeParking(c.getLevel(), c.getSlot());
			UsersRepository.delete(c);
		    map.put("Status", true);
			return map;
		} else {
			map.put("Status", false);
		}
		return map;
	}
	
	@GetMapping(value = "/admin{registrationNumber}")
	public Map<String, Integer> search1(@PathVariable(value = "registrationNumber") String registrationNumber) {
		Map<String, Integer> map = new HashMap<>();
		int slotNo = UsersRepository.getSlotNoFromRegistration(registrationNumber);
		map.put(registrationNumber, slotNo);
		return map;
	}

	@GetMapping(value = "/admin/getRegistration/{color}")
	public List<String> search2(@PathVariable(value = "color") String color) {
		List<String> list = new ArrayList<>();
		list = UsersRepository.getAllRegistrationFromColor(color);
		return list;
	}

	@GetMapping(value = "/admin/getSlot/{color}")
	public List<Integer> search3(@PathVariable(value = "color") String color) {
		List<Integer> list = new ArrayList<>();
		list = UsersRepository.getAllSlotFromColor(color);
		return list;
	}
}
