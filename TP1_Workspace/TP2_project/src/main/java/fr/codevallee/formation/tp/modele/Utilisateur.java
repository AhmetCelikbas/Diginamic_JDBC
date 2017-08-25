/**
 * 
 */
package fr.codevallee.formation.tp.modele;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Utilisateur")

/**
 * @author keylan
 *
 */
public class Utilisateur {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idUser;
	
	private String email;
	private String password;
	
	@OneToOne(fetch=FetchType.EAGER, mappedBy="utilisateur", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	private Telephone telephone;
	
	
	@ManyToMany(fetch=FetchType.EAGER, mappedBy="utilisateur")
	private Set<VilleVisiste> villeVisiste;
	
	/**
	 * @return the idUser
	 */
	public Integer getIdUser() {
		return idUser;
	}
	/**
	 * @param idUser the idUser to set
	 */
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
}
