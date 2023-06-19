import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

	public class MaFenetre extends Stage {
		private int nbClics = 0;
		private HBox root = new HBox();
		private Button boutonOK = new Button("OK");
		private Label texte = new Label("Nombre de clics = " + nbClics);


	
		
	public MaFenetre() {	
		Scene laScene;
		
		boutonOK.setPrefWidth(80);
		root.setSpacing(20);
		root.setPadding(new Insets(10));
		root.getChildren().addAll(boutonOK, texte);
		
		laScene = new Scene(root);
		this.setScene(laScene);
		this.setTitle("Exemple");
		this.show();
		
		boutonOK.setOnAction(e -> {
			nbClics++;
			texte.setText("Nombre de clics = "+nbClics);
		});
	}
}
