package com.mst.parkinglot.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.mst.parkinglot.exception.ParkingNotAvailableException;
@Component
public class ParkingModel {

	static int a[][]=new int[3][10];
	public Map<String, Integer> getParkingLot() {
		Map<String,Integer> m = new HashMap<>();
		
		for(int i=1;i<=3;i++) {
			for(int j=1;j<=10;j++) {
				if(!(a[i-1][j-1] == 1)) {
					m.put("slot",j);
					m.put("level",i);
					return m;
				}
				}
		}
		
		return m;
		
	}
	public void reserveParking(int i, int j) {
		a[i-1][j-1]=1;
		
	}
	public void freeParking(int i, int j) {
		if(a[i-1][j-1]==1) {
			a[i-1][j-1]=0;
		}
		else
			System.out.println("Parking is already free");
			
		
	}
	
}
