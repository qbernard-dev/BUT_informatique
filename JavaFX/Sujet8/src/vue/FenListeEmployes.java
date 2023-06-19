package vue;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.ArrayList;
import java.util.Optional;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modele.AccesDonnees;
import presentation.*;

public class FenListeEmployes extends Stage {
	static private ObservableList<Employe> lesEmployes = FXCollections.observableArrayList();
	// les composants de la fenetre
	private AnchorPane  		racine			= new AnchorPane();
	private TableView<Employe> 	tableEmployes	= new TableView<Employe>();
	private Button 				bnAjouter 		= new Button("Ajouter...");
	private Button 				bnModifier 		= new Button("Modifier...");
	private Button 				bnSupprimer 	= new Button("Supprimer");
	private Button 				bnFermer 		= new Button("Fermer");
	
	private MenuItem optionAjouter = new MenuItem("Ajouter...");
	private MenuItem optionModifier = new MenuItem("Modifier...");
	private MenuItem optionSupprimer = new MenuItem("Supprimer");
	private ContextMenu menu = new ContextMenu( optionAjouter,
			new SeparatorMenuItem(),
			optionModifier,
			new SeparatorMenuItem(),
			optionSupprimer);
	
	// constructeur : initialisation de la fenetre
	public FenListeEmployes(){
		this.setTitle("Gestion des employés");
		this.setResizable(true);
		this.sizeToScene();
		this.setScene(new Scene(creerContenu()));	
		this.setMinHeight(450);
		this.setMinWidth(500);
	}
	
	// creation du Scene graph
	private Parent creerContenu() {
		
		tableEmployes.setContextMenu(menu);
			
		TableColumn<Employe,Integer> colonne1 = new TableColumn<Employe,Integer>("Matricule");
		colonne1.setCellValueFactory(new PropertyValueFactory<Employe,Integer>("matricule"));	
		tableEmployes.getColumns().add(colonne1);
		TableColumn<Employe, String> colonne2 = new TableColumn<Employe,String>("Nom");
		colonne2.setCellValueFactory(new PropertyValueFactory<Employe, String>("nom"));
		tableEmployes.getColumns().add(colonne2);
		TableColumn<Employe, String> colonne3 = new TableColumn<Employe,String>("Poste");
		colonne3.setCellValueFactory(new PropertyValueFactory<Employe, String>("poste"));
		tableEmployes.getColumns().add(colonne3);
		TableColumn<Employe,Integer> colonne4 = new TableColumn<Employe,Integer>("Département");
		colonne4.setCellValueFactory(new PropertyValueFactory<Employe, Integer>("dept"));
		tableEmployes.getColumns().add(colonne4);
				
		tableEmployes.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		
		
		BooleanBinding rien = Bindings.equal(tableEmployes.getSelectionModel().selectedIndexProperty(), -1);
		
		bnAjouter.setPrefWidth(100);
		bnAjouter.setOnAction(e ->{
			Principale.ouvrirNouvelEmploye();	
		});
		
		bnModifier.setPrefWidth(100);
		bnModifier.disableProperty().bind(Bindings.when(rien).then(true).otherwise(false));
		bnModifier.setOnAction(e ->{
			Principale.ouvrirDetailEmploye(tableEmployes.getSelectionModel().getSelectedItem());
		});
		
		bnSupprimer.setPrefWidth(100);
		bnSupprimer.disableProperty().bind(Bindings.when(rien).then(true).otherwise(false));
		bnSupprimer.setOnAction(e ->{
			Alert erreur = new Alert(AlertType.ERROR, "Etes-vous sur ?", ButtonType.NO, ButtonType.YES);
			Optional<ButtonType> result = erreur.showAndWait();
			if(result.isPresent() && result.get() == ButtonType.YES) {
				Principale.supprimerEmploye(tableEmployes.getSelectionModel().getSelectedItem());
			}
			//supprimerEmploye();
		});

		bnFermer.setPrefWidth(100);
		bnFermer.setOnAction(e ->{
			System.exit(0);
		});
		
		optionAjouter.setOnAction( e -> {
			Principale.ouvrirNouvelEmploye();
		});
		
		optionModifier.setOnAction(e -> {
			Principale.ouvrirDetailEmploye(tableEmployes.getSelectionModel().getSelectedItem());
		});

		optionSupprimer.setOnAction(e -> {
			Alert erreur = new Alert(AlertType.ERROR, "Etes-vous sur ?", ButtonType.NO, ButtonType.YES);
			Optional<ButtonType> result = erreur.showAndWait();
			if(result.isPresent() && result.get() == ButtonType.YES) {
				Principale.supprimerEmploye(tableEmployes.getSelectionModel().getSelectedItem());
			}
			//supprimerEmploye();
		});
		
		tableEmployes.setOnMouseClicked( e -> {
			if ( e.getClickCount()==2 && e.getButton()==MouseButton.PRIMARY && e.getTarget() instanceof Text){
				Principale.ouvrirDetailEmploye(tableEmployes.getSelectionModel().getSelectedItem());
			}
		});
		
		AnchorPane.setTopAnchor(tableEmployes, 10.0);
		AnchorPane.setLeftAnchor(tableEmployes, 10.0);
		AnchorPane.setRightAnchor(tableEmployes, 120.0);
		AnchorPane.setBottomAnchor(tableEmployes, 10.0);
		AnchorPane.setTopAnchor(bnAjouter, 30.0);
		AnchorPane.setRightAnchor(bnAjouter, 10.0);
		AnchorPane.setTopAnchor(bnModifier, 80.0);
		AnchorPane.setRightAnchor(bnModifier, 10.0);
		AnchorPane.setTopAnchor(bnSupprimer, 130.0);
		AnchorPane.setRightAnchor(bnSupprimer, 10.0);
		AnchorPane.setBottomAnchor(bnFermer, 10.0);
		AnchorPane.setRightAnchor(bnFermer, 10.0);
		racine.getChildren().addAll(tableEmployes, bnAjouter, bnModifier, bnSupprimer, bnFermer);
		return racine;
	}
	
	public void init(ArrayList<Employe> liste) {
		lesEmployes.clear();
		for (int i=0; i<liste.size() ; i++) {
			lesEmployes.add(liste.get(i));
		}
		tableEmployes.setItems(lesEmployes);

	}
	public void ajouterEmploye(Employe e) {
		lesEmployes.add(e);
	}
	public void modifierEmploye(Employe e) {
		boolean trouve = false;
		int i=0;
		while (!trouve && i<lesEmployes.size()) {
			if (lesEmployes.get(i).getMatricule()==e.getMatricule()){
				lesEmployes.set(i, e);
				trouve = true;
			}
			i++;
		}
	}
	public void supprimerEmploye(Employe e) {
		lesEmployes.remove(e);
	}
}
