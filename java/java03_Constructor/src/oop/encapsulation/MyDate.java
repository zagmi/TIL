package oop.encapsulation;

public class MyDate {
	public int month;
	public int day;
	
	public int getMonth() {
		return month;
	}
	//로컬변수와 필드의 이름이 같을때 구분하기 위해서 필드앞에 this를 지정한다.
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}	
}
