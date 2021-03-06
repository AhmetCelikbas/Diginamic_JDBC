/**
 * 
 */
package fr.codevallee.formation.tp.modele;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Telephone")

/**
 * @author keylan
 *
 */
public class Telephone {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idTelephone;
	
	@Column(length=40)
	private String numero;
	
	@OneToOne
	private Utilisateur utilisateur;

	/**
	 * @return the idTelephone
	 */
	public Integer getIdTelephone() {
		return idTelephone;
	}

	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * @return the utilisateur
	 */
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	/**
	 * @param utilisateur the utilisateur to set
	 */
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
}
