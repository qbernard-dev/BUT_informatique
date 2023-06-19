import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FenConnexion extends Stage{
	private Label 			titre 			= new Label("Connexion à PStage");
	private Label			lblNom 			= new Label("Nom");
	private Label 			lblPass 		= new Label("Mot de passe");
	private Label 			deuxPointsNom 	= new Label(":");
	private Label 			deuxPointsPass 	= new Label(":");
	private TextField		txtNom			= new TextField();
	private PasswordField	txtPass			= new PasswordField();
	private Button 			bnOK 			= new Button("OK");
	private Button 			bnAnnuler 		= new Button("Annuler");
	private BorderPane		root			= new BorderPane();
	private GridPane		root1			= new GridPane();
	private HBox			root2			= new HBox();
	
	public FenConnexion(){ 
		this.setTitle("PStage"); 
		this.initStyle(StageStyle.UTILITY);
		this.setResizable(false);
		Scene laScene = new Scene(creerContenu());
		this.setScene(laScene);
		this.sizeToScene();
	}
	
	// Méthode à écrire dans le cadre du TP2, en utilisant les Layout Pane les plus adaptés
	private Parent creerContenu(){	
		root2.setSpacing(10);
		
		root1.add(lblNom,0,0);
		root1.add(deuxPointsNom, 1, 0);
		root1.add(txtNom, 2, 0);
		
		root1.add(lblPass, 0, 1);
		root1.add(deuxPointsPass, 1, 1);
		root1.add(txtPass, 2, 1);
		
		root.setTop(titre);
		root.setBottom(root2);
		root.setCenter(root1);
		BorderPane.setAlignment(titre, Pos.CENTER);
		root2.setAlignment(Pos.CENTER_RIGHT);
		
		root1.setVgap(5);
		root1.setHgap(5);
		titre.setPadding(new Insets(10));
		root1.setPadding(new Insets(10));
		root2.setPadding(new Insets(10));
		
		root2.getChildren().addAll(bnOK,bnAnnuler);
		
		return root;
	}
}