package it.unisa.GameBarter.Model;

public class Prodotto {
	
	public Prodotto() {
		super();
	}
	

	/**
	 * @param titolo
	 * @param volume
	 */
	public Prodotto(String titolo, int volume) {
		super();
		this.titolo = titolo;
		this.volume = volume;
	}


	/**
	 * @param idprodotto
	 * @param titolo
	 * @param prezzo
	 * @param volume
	 * @param piattaforma
	 * @param genere
	 * @param anno
	 */
	public Prodotto(int idprodotto, String titolo, int prezzo, int volume, String piattaforma, String genere,
			String anno) {
		super();
		this.idprodotto = idprodotto;
		this.titolo = titolo;
		this.prezzo = prezzo;
		this.volume = volume;
		this.piattaforma = piattaforma;
		this.genere = genere;
		this.anno = anno;
	}
	
	/**
	 * @param idprodotto
	 * @param titolo
	 * @param prezzo
	 * @param piattaforma
	 * @param genere
	 * @param anno
	 */
	public Prodotto(int idprodotto, String titolo, int prezzo, String piattaforma, String genere,
			String anno) {
		super();
		this.idprodotto = idprodotto;
		this.titolo = titolo;
		this.prezzo = prezzo;
		this.piattaforma = piattaforma;
		this.genere = genere;
		this.anno = anno;
	}
	
	
	/**
	 * @param titolo
	 * @param prezzo
	 * @param volume
	 * @param piattaforma
	 * @param genere
	 * @param anno
	 */
	public Prodotto(String titolo, int prezzo, int volume, String piattaforma, String genere,
			String anno) {
		super();
		this.titolo = titolo;
		this.prezzo = prezzo;
		this.volume = volume;
		this.piattaforma = piattaforma;
		this.genere = genere;
		this.anno = anno;
	}
	
	/**
	 * @param titolo
	 * @param prezzo
	 * @param piattaforma
	 * @param genere
	 * @param anno
	 */
	public Prodotto(String titolo, int prezzo, String piattaforma, String genere,
			String anno) {
		super();
		this.titolo = titolo;
		this.prezzo = prezzo;
		this.piattaforma = piattaforma;
		this.genere = genere;
		this.anno = anno;
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
	/**
	 * @return the genere
	 */
	public String getGenere() {
		return genere;
	}
	/**
	 * @param genere the genere to set
	 */
	public void setGenere(String genere) {
		this.genere = genere;
	}
	/**
	 * @return the anno
	 */
	public String getAnno() {
		return anno;
	}
	/**
	 * @param anno the anno to set
	 */
	public void setAnno(String anno) {
		this.anno = anno;
	}
	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	} 
	
	private int idprodotto;
	private String titolo;
	private int prezzo;
	private int volume;
	private String piattaforma;
	private String genere;
	private String anno;
	//Variabile usata per inserire il path delle immagini di giochi
	private String path;
	

}
