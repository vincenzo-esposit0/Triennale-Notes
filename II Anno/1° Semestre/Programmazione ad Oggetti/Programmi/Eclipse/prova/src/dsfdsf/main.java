package dsfdsf;

import java.util.GregorianCalendar;

public class main {

	public static void main(String[] args) {
		GregorianCalendar time = new GregorianCalendar();
		System.out.println(time.getTimeInMillis());
		time.setTimeInMillis(time.getTimeInMillis()+10000);
		System.out.println(time.getTimeInMillis());
	}

}
