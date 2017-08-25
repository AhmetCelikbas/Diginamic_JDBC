package fr.codevallee.formation.tp;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;

import java.util.HashMap;
import java.util.Map;

import fr.codevallee.formation.tp.modele.Telephone;
import fr.codevallee.formation.tp.modele.Utilisateur;
import freemarker.template.Configuration;
import freemarker.template.Version;
import spark.ModelAndView;
import spark.servlet.SparkApplication;
import spark.template.freemarker.FreeMarkerEngine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mysql.fabric.xmlrpc.base.Data;

public class Router implements SparkApplication {

	public void init() {

		final Logger logger = LoggerFactory.getLogger(Router.class);
		
		
		/*
		 * TEST
		 */
		get("/test", (request, response) -> {
			logger.debug("start");
			Map<String, Object> attributes = new HashMap<>();
			
			
			Utilisateur utilisateur = Database.find(Utilisateur.class, 1);
			
//			Telephone telephone = new Telephone();
//			telephone.setNumero("0670433434");;
//			telephone.setUtilisateur(utilisateur);
//			
//			
//			Database.presist(telephone);
			
			Database.remove(utilisateur);
			
			
			attributes.put("VAR", "testtt");
			
			
			return new ModelAndView(attributes, "test.ftl");
		}, getFreeMarkerEngine());
		
		
		
		
		/*
		 * LIST USERS
		 */
		get("/", (request, response) -> {
			logger.debug("start");
			Map<String, Object> attributes = new HashMap<>();
			Utilisateur utilisateur = new Utilisateur();
			
			try {
				attributes.put("utilisateurs", Database.query("from Utilisateur", Utilisateur.class));
			} catch(IllegalArgumentException e) {
				attributes.put("ERROR", "[Erreur] - Erreur lors du listage des utilisateurs");
			}
			
			return new ModelAndView(attributes, "lister.ftl");
		}, getFreeMarkerEngine());
		
		
		/*
		 * CREATE USER
		 */
		get("/creerUtilisateur", (request, response) -> {
			logger.debug("start");
			Map<String, Object> attributes = new HashMap<>();
			return new ModelAndView(attributes, "creerUtilisateur.ftl");
		}, getFreeMarkerEngine());

		post("/validerCreationUtilisateur", (request, response) -> {
			logger.debug("start");
			Map<String, Object> attributes = new HashMap<>();
			
			Utilisateur utilisateur = new Utilisateur();
			utilisateur.setEmail(request.queryParams("email"));
			utilisateur.setPassword(request.queryParams("password"));
			Database.presist(utilisateur);
			
			Telephone telephone = new Telephone();
			telephone.setNumero(request.queryParams("phone"));
			telephone.setUtilisateur(Database.find(Utilisateur.class, utilisateur.getIdUser()));
			Database.presist(telephone);
			
			attributes.put("messageValidation", "Utilisateur créé");
			
			return new ModelAndView(attributes, "validation.ftl");
		}, getFreeMarkerEngine());
		
		
		/*
		 * UPDATE USER
		 */
		get("/modifierUtilisateur/:id", (request, response) -> {
			logger.debug("start");
			Map<String, Object> attributes = new HashMap<>();
			System.out.println(request.params(":id"));
			
			try {
				Utilisateur utilisateur = Database.find(Utilisateur.class, Integer.parseInt(request.params(":id")));
				
				attributes.put("utilisateur", utilisateur);
				
			} catch(IllegalArgumentException e) {
				attributes.put("ERROR", "Utilisateur '" + request.params(":id") + "' introuvable.");
			}
			return new ModelAndView(attributes, "modifierUtilisateur.ftl");
		}, getFreeMarkerEngine());

		post("/validerModificationUtilisateur/:id", (request, response) -> {
			logger.debug("start");
			Map<String, Object> attributes = new HashMap<>();
			System.out.println(request.params(":id"));
			
			try {
				Utilisateur utilisateur = Database.find(Utilisateur.class, Integer.parseInt(request.params(":id")));

				
				Database.getEntity().getTransaction().begin();
				utilisateur.setEmail(request.queryParams("email"));
				utilisateur.setPassword(request.queryParams("password"));
				Database.getEntity().getTransaction().commit();
				
				attributes.put("messageValidation", "Utilisateur modifié");
				
			} catch(IllegalArgumentException e) {
				attributes.put("ERROR", "Utilisateur '" + request.params(":id") + "' introuvable." + e);
			} 
			return new ModelAndView(attributes, "validation.ftl");
		}, getFreeMarkerEngine());
		
		
		
		get("/validerSupprimerUtilisateur/:id", (request, response) -> {
			logger.debug("start");
			Map<String, Object> attributes = new HashMap<>();
			System.out.println(request.params(":id"));
			
			try {
				Utilisateur utilisateur = Database.find(Utilisateur.class, Integer.parseInt(request.params(":id")));

				Database.remove(utilisateur);
				
				attributes.put("messageValidation", "Utilisateur supprimé");
				
			} catch(IllegalArgumentException e) {
				attributes.put("ERROR", "Utilisateur '" + request.params(":id") + "' introuvable." + e);
			} 
			return new ModelAndView(attributes, "validation.ftl");
		}, getFreeMarkerEngine());
	}

	private FreeMarkerEngine getFreeMarkerEngine() {
		FreeMarkerEngine engine = new FreeMarkerEngine();
		Configuration configuration = new Configuration(new Version(2, 3, 23));
		configuration.setTemplateUpdateDelayMilliseconds(Long.MAX_VALUE);
		configuration.setClassForTemplateLoading(FreeMarkerEngine.class, "");
		engine.setConfiguration(configuration);
		return engine;
	}

}