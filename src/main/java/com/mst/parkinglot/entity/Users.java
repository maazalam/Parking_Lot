package com.mst.parkinglot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Users {
	@Id
	@GeneratedValue
	@Column(name= "id")
	private Integer id;
	@Column(name= "name")
	private String name;
	@Column(name= "team_name")
	private String teamName;
	@Column(name= "salary")
	private Integer salary;
	
	public Users() {
		
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getTeamName() {
		return teamName;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	
}
