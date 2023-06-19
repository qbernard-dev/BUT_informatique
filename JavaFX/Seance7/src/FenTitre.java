
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class FenTitre extends Stage{



	public FenTitre() {
		Label lblTexte1 = new Label("Texte :");
		TextField tfChamp1 = new TextField();
		Button bnFermer = new Button("Fermer");
		bnFermer.setOnAction(e -> this.close() );
		
		this.titleProperty().bind(tfChamp1.textProperty());
		
		
		
		GridPane grid = new GridPane();
		grid.addRow(0, lblTexte1, tfChamp1);
		grid.add(bnFermer, 1, 1);
		grid.setVgap(10);
		grid.setHgap(10);
		grid.setPadding(new Insets(10));
		Scene scene = new Scene(grid);
		this.setScene(scene);
		this.show();	
	}
}
























