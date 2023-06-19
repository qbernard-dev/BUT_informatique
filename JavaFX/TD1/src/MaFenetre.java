

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MaFenetre extends Stage{
	
	private Rectangle r1 = new Rectangle();
	private Rectangle r2 = new Rectangle();
	private Rectangle r3 = new Rectangle();
	private Rectangle r4 = new Rectangle();
	private Circle c1 = new Circle();
	
	private Group horizon = new Group();
	private Group plage = new Group();
	private Group racine = new Group();
	
	public MaFenetre() {
		
		this.setTitle("Figure");
		this.setX(100);
		this.setY(100);
		this.setResizable(false);
		
		Scene laScene = new Scene(creerContenu());
		this.setScene(laScene);
		this.sizeToScene();
	}
	
	public Parent creerContenu(){
		
		c1.setFill(Color.ORANGE);
		r1.setFill(Color.CYAN);
		r2.setFill(Color.BLUE);
		r3.setFill(Color.YELLOW);
		r4.setFill(Color.PURPLE);
		
		horizon.getChildren().addAll(c1, r1);
		 return horizon;
		
	}
}
