package spring.service.dice.impl;

import java.util.Random;

import spring.service.dice.Dice;

public class DiceAimpl implements Dice {
	
	private int value;
	
	public DiceAimpl() { System.out.println("::"+getClass().getName()+" 생성자....");}

	@Override
	public void selectedNumber() {value = new Random().nextInt(6) + 1;}

	@Override
	public int getValue() {return value;}

}
