package com.mst.parkinglot.exception;

public class ParkingNotAvailableException extends Exception{

    public ParkingNotAvailableException(String msg)
    {
        super(msg);
    }
}