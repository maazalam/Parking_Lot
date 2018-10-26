package com.mst.parkinglot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mst.parkinglot.entity.Car;

@Repository
public interface UsersRepository extends CrudRepository<Car, Long> {

	@Query("SELECT DISTINCT(c) FROM Car c WHERE c.registrationNumber=registrationNumber")
	Car findByRegistrationNumber(String registrationNumber);
	
	@Query("SELECT slot FROM Car WHERE registrationNumber=registrationNumber")
	int getSlotNoFromRegistration(String registrationNumber);

	@Query("SELECT registrationNumber FROM Car WHERE color=color")
	List<String> getAllRegistrationFromColor(String color);

	@Query("SELECT slot FROM Car WHERE color=color")
	List<Integer> getAllSlotFromColor(String color);

}
