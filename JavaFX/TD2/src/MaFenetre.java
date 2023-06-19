import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class MaFenetre extends Stage {
	
	private Button b1 =  new Button("Bouton 1");
	private Button b2 =  new Button("Bn 2");
	private Button b3 =  new Button("Je suis le Bouton 1");
	private Button b4 =  new Button("Bouton 4");
	private Button b5 =  new Button("Moi c'est le Bouton 5");
	private FlowPane racine = new FlowPane();
	
		
	public MaFenetre() {		
		Scene maScene = new Scene(creerRacine());
		this.setScene(maScene);
	}
	
	public Parent creerRacine() {
		racine.getChildren().addAll(b1);
		racine.getChildren().addAll(b2);
		racine.getChildren().addAll(b3);
		racine.getChildren().addAll(b4);
		racine.getChildren().addAll(b5);
		return racine;
	}
	
	
}
