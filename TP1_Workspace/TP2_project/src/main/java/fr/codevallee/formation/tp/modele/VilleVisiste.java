/**
 * 
 */
package fr.codevallee.formation.tp.modele;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "VilleVisiste")

/**
 * @author keylan
 *
 */
public class VilleVisiste {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idVoiture;
	
	@Column(length=40)
	private String numero;
	
	@ManyToMany
	private Set<Utilisateur> utilisateur;

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
	public Set<Utilisateur> getUtilisateur() {
		return utilisateur;
	}

	/**
	 * @param utilisateur the utilisateur to set
	 */
	public void setUtilisateur(Set<Utilisateur> utilisateur) {
		this.utilisateur = utilisateur;
	}

	/**
	 * @return the idVoiture
	 */
	public Integer getIdVoiture() {
		return idVoiture;
	}
	
}
