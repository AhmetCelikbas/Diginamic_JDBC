/**
 * 
 */
package fr.codevallee.formation.tp.modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	

}
