package edu.eci.arsw.blueprints;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import edu.eci.arsw.blueprints.config.AppConfig;
import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.services.BlueprintsServices;

public class BlueprintsApplication {
	public static void main(String[] args) throws Exception {
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {

			BlueprintsServices services = context.getBean(BlueprintsServices.class);

			Point[] points = new Point[] { new Point(10, 20), new Point(30, 40) };
			Blueprint bp = new Blueprint("Jesus", "Blueprint1", points);

			services.addNewBlueprint(bp);
			System.out.println("blueprint added: " + bp);

			Point[] points2 = new Point[] { new Point(50, 60), new Point(70, 80) };
			Blueprint bp2 = new Blueprint("Natalia", "Blueprint2", points2);

			services.addNewBlueprint(bp2);
			System.out.println("blueprint added: " + bp2);

			Blueprint loaded = services.getBlueprint("Jesus", "Blueprint1");
			System.out.println("blueprint loaded: " + loaded);


			System.out.println("Jesus blueprints:");
			services.getBlueprintsByAuthor("Jesus").forEach(System.out::println);

			System.out.println("Natalia blueprints:");
			services.getBlueprintsByAuthor("Natalia").forEach(System.out::println);

			System.out.println("All blueprints:");
			services.getAllBlueprints().forEach(System.out::println);
		}
	} 
}
