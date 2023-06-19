
import javafx.beans.binding.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Insets;

public class FenVueSimpleEmploye extends Stage {
	
	Employe emp = new Employe(7369,"LECLERC","SECRETAIRE", 20);
	
	// les composants de la fenetre
	private GridPane	racine			= new GridPane();
	private HBox		zoneBoutons		= new HBox();
	private Label 		lblMatricule	= new Label("Matricule :");
	private Label 		lblNom			= new Label("Nom employe :");
	private Label 		lblPoste		= new Label("Poste :");
	private Label 		lblDepartement	= new Label("Departement :");
	private TextField	txtMatricule	= new TextField();
	private TextField	txtNom			= new TextField();
	private TextField	txtPoste		= new TextField();
	private TextField	txtDepartement	= new TextField();
	private Button		bnChangerNom	= new Button("changer Nom");
	private Button		bnChangerPoste	= new Button("changer Poste");
	
	// constructeur : initialisation de la fenetre
	public FenVueSimpleEmploye(){
		this.setTitle("Detail d'un employe");
		this.setResizable(true);
		this.sizeToScene();
		this.setResizable(false);
		this.setScene(new Scene(creerContenu()));	
	}
	
	// creation du Scene graph
	private Parent creerContenu() {
		
		txtMatricule.textProperty().bind(Bindings.createStringBinding(()->String.valueOf(emp.getMatricule()), emp.matriculeProperty()));
		txtNom.textProperty().bind(emp.nomProperty());
		txtPoste.textProperty().bind(emp.posteProperty());
		txtDepartement.textProperty().bind(Bindings.createStringBinding(()->String.valueOf(emp.getDept()), emp.deptProperty()));
		
		bnChangerNom.setPrefWidth(100);
		bnChangerNom.setOnAction(e -> {
			emp.setNom("BIRAUD");
		});
		
		bnChangerPoste.setPrefWidth(100);
		bnChangerPoste.setOnAction(e -> {
			emp.setPoste("INGENIEUR");
		});

		racine.addRow(0, lblMatricule, txtMatricule);
		racine.addRow(1, lblNom, txtNom);
		racine.addRow(2, lblPoste, txtPoste);
		racine.addRow(3, lblDepartement, txtDepartement);
		zoneBoutons.getChildren().addAll(bnChangerNom, bnChangerPoste);
		racine.add(zoneBoutons, 1, 4);
		racine.setHgap(10);
		racine.setVgap(10);
		racine.setPadding(new Insets(10));
		return racine;
	}
}