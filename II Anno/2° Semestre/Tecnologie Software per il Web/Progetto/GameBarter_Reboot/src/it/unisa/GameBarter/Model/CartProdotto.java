package it.unisa.GameBarter.Model;

public class CartProdotto {
	

	/**
	 * 
	 */
	public CartProdotto() {
		super();
	}
	/**
	 * @param idprodotto
	 * @param titolo
	 * @param prezzo
	 * @param volume
	 * @param piattaforma
	 */
	public CartProdotto(int idprodotto, String titolo, int prezzo, int volume, String piattaforma) {
		super();
		this.idprodotto = idprodotto;
		this.titolo = titolo;
		this.prezzo = prezzo;
		this.volume = volume;
		this.piattaforma = piattaforma;
	}
	/**
	 * @return the idprodotto
	 */
	public int getIdprodotto() {
		return idprodotto;
	}
	/**
	 * @param idprodotto the idprodotto to set
	 */
	public void setIdprodotto(int idprodotto) {
		this.idprodotto = idprodotto;
	}
	/**
	 * @return the titolo
	 */
	public String getTitolo() {
		return titolo;
	}
	/**
	 * @param titolo the titolo to set
	 */
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	/**
	 * @return the prezzo
	 */
	public int getPrezzo() {
		return prezzo;
	}
	/**
	 * @param prezzo the prezzo to set
	 */
	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}
	/**
	 * @return the volume
	 */
	public int getVolume() {
		return volume;
	}
	/**
	 * @param volume the volume to set
	 */
	public void setVolume(int volume) {
		this.volume = volume;
	}
	/**
	 * @return the piattaforma
	 */
	public String getPiattaforma() {
		return piattaforma;
	}
	/**
	 * @param piattaforma the piattaforma to set
	 */
	public void setPiattaforma(String piattaforma) {
		this.piattaforma = piattaforma;
	}
	

	private int idprodotto;
	private String titolo;
	private int prezzo;
	private int volume;
	private String piattaforma;

}
