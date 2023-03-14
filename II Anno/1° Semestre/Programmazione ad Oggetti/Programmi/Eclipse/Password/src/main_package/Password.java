package main_package;

public class Password {
	private String word;
	private int length;
	
	public Password() {
	}
	
	private boolean lengthCeck() {
		if (word.length()>8)
			return true;
		else
			return false;
	}
	
	private boolean numberCeck() {
		for (int i=0;i<length;i++) {
			if ((word.charAt(i)>='0')&&(word.charAt(i)<='9'))
				return true;
		}
		return false;
	}
	
	private boolean upCaseCeck() {
		for (int i=0;i<length;i++) {
			if ((word.charAt(i)>='A')&&(word.charAt(i)<='B'))
				return true;
		}
		return false;
	}
	
	private boolean loCaseCeck() {
		for (int i=0;i<length;i++) {
			if ((word.charAt(i)>='a')&&(word.charAt(i)<='b'))
				return true;
		}
		return false;
	}
	
	public boolean passwordCeck(String x) {
		word=x;
		length=x.length();
		if ((this.lengthCeck())&&(this.numberCeck())&&(this.upCaseCeck())&&(this.loCaseCeck()))
				return true;
		else
			if (!this.lengthCeck())
				System.out.println("Password corta...");
			if (!this.numberCeck())
				System.out.println("Manca il numero...");
			if (!this.upCaseCeck())
				System.out.println("Manca il carattere grande...");
			if (!this.loCaseCeck())
				System.out.println("Manca il carattere piccolo...");
			return false;
	}
}
