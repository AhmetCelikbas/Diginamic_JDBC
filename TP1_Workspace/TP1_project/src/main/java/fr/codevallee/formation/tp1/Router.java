package fr.codevallee.formation.tp1;

import static spark.Spark.get;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.codevallee.formation.tp1.models.Agence;
import freemarker.template.Configuration;
import freemarker.template.Version;
import spark.ModelAndView;
import spark.servlet.SparkApplication;
import spark.template.freemarker.FreeMarkerEngine;

public class Router implements SparkApplication {

	private Database db = new Database();
	
	public void init() {
		get("/exemple1", (request, response) -> {
			Map<String, Object> attributes = new HashMap<>();
			try {				
				db.connect();
				attributes.put("liste_agences", db.select_agences_executeQuery());
				
				attributes.put("agence_orpi", db.select_agences_prepared(257400));
				
			} catch(SQLException e) {
				attributes.put("ERROR", e);
			}
			
			return new ModelAndView(attributes, "home.ftl");
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