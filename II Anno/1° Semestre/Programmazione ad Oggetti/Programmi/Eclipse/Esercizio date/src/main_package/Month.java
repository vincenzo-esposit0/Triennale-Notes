package main_package;

public class Month {
	private int mese;
	
	public Month(int inmese) {
		mese=inmese;
	}
	
	public int getDays() {
		if (mese==1)
			return 31;
		else if (mese==2)
			return 28;
		else if (mese==3)
			return 31;
		else if (mese==4)
			return 30;
		else if (mese==5)
			return 31;
		else if (mese==6)
			return 30;
		else if (mese==7)
			return 31;
		else if (mese==8)
			return 31;
		else if (mese==9)
			return 30;
		else if (mese==10)
			return 31;
		else if (mese==11)
			return 30;
		else
			return 31;			
	}
	
	public String getMonth() {
		if (mese==1)
			return "Gennaio";
		else if (mese==2)
			return "Febbraio";
		else if (mese==3)
			return "Marzo";
		else if (mese==4)
			return "Aprile";
		else if (mese==5)
			return "Maggio";
		else if (mese==6)
			return "Giugno";
		else if (mese==7)
			return "Luglio";
		else if (mese==8)
			return "Agosto";
		else if (mese==9)
			return "Settembre";
		else if (mese==10)
			return "Ottobre";
		else if (mese==11)
			return "Novembre";
		else
			return "Dicembre";	
	}
}
