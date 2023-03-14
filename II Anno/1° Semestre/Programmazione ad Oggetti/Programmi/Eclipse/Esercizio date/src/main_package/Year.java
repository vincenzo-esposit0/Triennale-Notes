package main_package;

public class Year {
	private int anno;
	
	public Year(int inanno) {
		anno=inanno;
	}
	
	public int getYear() {
		return anno;
	}
	
	public boolean isLeapYear() {
		if ((anno%4==0)||(anno%400==0))
			return true;
		else
			return false;
	}
}
