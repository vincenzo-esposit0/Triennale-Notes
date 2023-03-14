package it.unisa.GameBarter.Model;

public class Ordine {

	/**
	 * 
	 */
	public Ordine() {
		super();
	}

	/**
	 * @param idordine
	 * @param titolo
	 * @param volume
	 * @param prezzo
	 * @param data
	 * @param username
	 */
	public Ordine(int idordine, String data, String titolo, int volume, String username, int prezzo ) {
		super();
		this.idordine = idordine;
		this.titolo = titolo;
		this.volume = volume;
		this.prezzo = prezzo;
		this.data = data;
		this.username = username;
	}

	/**
	 * @param idordine
	 * @param titolo
	 * @param volume
	 * @param prezzo
	 * @param data
	 */
	public Ordine(int idordine, String titolo, int volume, int prezzo, String data) {
		super();
		this.idordine = idordine;
		this.titolo = titolo;
		this.volume = volume;
		this.prezzo = prezzo;
		this.data = data;
	}
	
	/**
	 * @return the idordine
	 */
	public int getIdordine() {
		return idordine;
	}
	/**
	 * @param idordine the idordine to set
	 */
	public void setIdordine(int idordine) {
		this.idordine = idordine;
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
	 * @return the data
	 */
	public String getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(String data) {
		this.data = data;
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
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
	
	private int idordine;
	private String titolo;
	private int volume;
	private int prezzo;
	private String data;
	
	private String username;





}
