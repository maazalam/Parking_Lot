package com.mst.parkinglot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Car {

	@Id
	@GeneratedValue
	@Column(name= "id")
	private Long id;
	
	@Column(name= "registrationNumber")
    private String registrationNumber;
	@Column(name= "color")
    private String color;

	@Column(name= "level")
    private Integer level;

	@Column(name= "slot")
    private Integer slot;
	


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "registrationNumber='" + registrationNumber + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

	public int getLevel() {
		return level;
	}

	public int getSlot() {
		return slot;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setSlot(int slot) {
		this.slot = slot;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
}

