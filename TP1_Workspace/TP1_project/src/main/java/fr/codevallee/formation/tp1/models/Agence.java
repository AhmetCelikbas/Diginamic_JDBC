/**
 * 
 */
package fr.codevallee.formation.tp1.models;

/**
 * @author keylan
 *
 */
public class Agence {
	private int idAgence;
	private String nom;
	private String adresse;
	
	public Agence(int idAgence, String nom, String adresse) {
		this.idAgence = idAgence;
		this.nom = nom;
		this.adresse = adresse;
	}
	
	
	/**
	 * @return the idAgence
	 */
	public int getIdAgence() {
		return idAgence;
	}
	/**
	 * @param idAgence the idAgence to set
	 */
	public void setIdAgence(int idAgence) {
		this.idAgence = idAgence;
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}
	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
}
