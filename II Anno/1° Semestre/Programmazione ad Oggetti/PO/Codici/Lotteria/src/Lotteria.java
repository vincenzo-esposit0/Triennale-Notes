public class Lotteria {
	public Lotteria(String bigliettoVincente)
	{
		this.bigliettoVincente = bigliettoVincente;
	}
	
	public boolean ifVincente(String bigliettoCliente)
	{
		if(bigliettoVincente.equals(bigliettoCliente))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	String bigliettoVincente;
	String bigliettoCliente;
}
