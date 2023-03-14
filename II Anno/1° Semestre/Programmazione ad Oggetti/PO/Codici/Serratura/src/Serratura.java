public class Serratura {
		
		public Serratura(String combinazione, boolean serratura)
		{
			this.combinazione = combinazione;
			this.serratura = serratura = false;
		}

		public void unlock(String pwInserita)
		{
			if(combinazione.equalsIgnoreCase(pwInserita)){
				serratura = true;
				System.out.println("Password giusta. Serratura aperta");}
			else 
				{serratura = false;
				System.out.println("Password errata");}
		}
		
		public boolean isOpen()
		{
			return serratura;
		}
		
		public void lock(String pwInserita)
		{
			serratura = false;
		}
		
		public void newComb(String newComb)
		{
			if(serratura==true)
			{
				combinazione = newComb;
			}
		}
		
		public void setPosition(String charComb)
		{
	        combinazione = combinazione.concat(charComb);
		}
		
		public String getComb()
		{
			return combinazione;
		}
		
		private String charComb;
		private String combinazione;
		private String pwInserita;
		private Boolean serratura;
}
