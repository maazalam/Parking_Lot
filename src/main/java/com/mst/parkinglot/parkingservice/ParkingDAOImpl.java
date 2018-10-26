package com.mst.parkinglot.parkingservice;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.mst.parkinglot.parkingservice.ParkingDAO;
import com.mst.parkinglot.model.ParkingModel;

@Component
@Transactional
public class ParkingDAOImpl implements ParkingDAO {

    @Autowired
    ParkingModel parkingModel;

    @Override
    public Map<String, Integer> getParkingLot() {
    	Map<String, Integer> parkingSlot = parkingModel.getParkingLot();
        return parkingSlot;
    }
}
