/**
 * 
 */
package fr.codevallee.formation.tp.modele;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Voiture")

/**
 * @author keylan
 *
 */
public class Voiture {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idVoiture;

	private String marque;
	private String model;
	private String immatriculation;
	
	@OneToMany
	Set<Utilisateur> Utilisateur;
	
	/**
	 * @return the marque
	 */
	public String getMarque() {
		return marque;
	}

	/**
	 * @param marque the marque to set
	 */
	public void setMarque(String marque) {
		this.marque = marque;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the immatriculation
	 */
	public String getImmatriculation() {
		return immatriculation;
	}

	/**
	 * @param immatriculation the immatriculation to set
	 */
	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	/**
	 * @return the utilisateur
	 */
	public Set<Utilisateur> getUtilisateur() {
		return Utilisateur;
	}

	/**
	 * @param utilisateur the utilisateur to set
	 */
	public void setUtilisateur(Set<Utilisateur> utilisateur) {
		Utilisateur = utilisateur;
	}

	/**
	 * @return the idVoiture
	 */
	public Integer getIdVoiture() {
		return idVoiture;
	}

	

}
