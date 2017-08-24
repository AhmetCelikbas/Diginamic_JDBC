/**
 * 
 */
package fr.codevallee.formation.tp.modele;

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
	private Integer idVoiture;
	
	@Column(length=40)
	private String numero;
	
	@OneToOne
	private Utilisateur utilisateur;
	
}
