package com.mst.parkinglot.parkingservice;

import java.util.Map;

import javax.annotation.Resource;

/**
 * @author maaz
 *
 */
public interface ParkingDAO {

	Map<String, Integer> getParkingLot();
}
