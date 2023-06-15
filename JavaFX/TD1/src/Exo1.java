

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Exo1 extends Application{
	
	public void start(Stage maFenetre){

		maFenetre.setTitle("Les loulous");
		maFenetre.setX(10);
		maFenetre.setY(200);
		
		maFenetre.setWidth(500);
		maFenetre.setHeight(300);
		
		maFenetre.setMinWidth(300);
		maFenetre.setMinHeight(100);
		

		Rectangle carre = new Rectangle(10, 10, 100,100);
		carre.setFill(Color.LIGHTBLUE);
		Circle rond = new Circle(200,200,40); // Attention, il s'agit des
		rond.setFill(Color.ORANGE); // coordonnées du centre du cercle
		Group racine = new Group(); // racine du Scene Graph
		racine.getChildren().add(rond); // les composants sont ajoutés un à un
		racine.getChildren().add(carre); // à leur nœud parent (la racine ici)
		
		Scene maScene = new Scene(racine);
		maFenetre.setScene(maScene);
		
		
		maFenetre.show();
	}
	
	public static void main(String[] args) {
		Application.launch();
	}
	
	
}
