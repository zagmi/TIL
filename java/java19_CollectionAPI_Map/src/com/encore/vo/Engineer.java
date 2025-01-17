package com.encore.vo;

import com.encore.util.MyDate;

public class Engineer extends Employee{
	private String tech;
	private double bonus;
	
	public Engineer(int ssn, String name, MyDate birthDate, double salary, String tech, double bonus) {
		super(ssn,name,birthDate,salary);	
		this.tech = tech;
		this.bonus = bonus;
	}		
	public void setTech(String tech) {
		this.tech = tech;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}	
	
	public String getTech() {
		return tech;
	}
	public double getBonus() {
		return bonus;
	}
	
	@Override
	public String toString() {		
		return super.toString()+" "+tech+" "+bonus;
	}
}
