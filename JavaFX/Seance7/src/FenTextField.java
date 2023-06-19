import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.effect.*;

public class FenTextField extends Stage{
	private Label lblTexte1 = new Label("Texte :");
	private TextField saisie = new TextField();
	private Label lblTexte2 = new Label("Aperçu :");
	private TextField apercu = new TextField();
	private Button bnFermer = new Button("Fermer");
	
	public FenTextField() {
		bnFermer.setOnAction(e -> this.close() );
		apercu.setStyle("-fx-text-fill:red;-fx-font-weight:bold;-fx-font-size:36");
		
		apercu.textProperty().bindBidirectional(saisie.textProperty());
	
		GridPane grid = new GridPane();
		grid.addRow(0, lblTexte1, saisie);
		grid.addRow(1, lblTexte2, apercu);
		grid.add(bnFermer, 2, 2);
		grid.setVgap(30);
		grid.setHgap(10);
		grid.setPadding(new Insets(10));
		Scene scene = new Scene(grid);
		this.setScene(scene);
		this.setTitle("Aperçu");
		this.show();	
	}
}