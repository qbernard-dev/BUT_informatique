
import javafx.beans.binding.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.event.*;

public class FenTableEmployes extends Stage {
	// les donn�es
	ObservableList<Employe> liste = FXCollections.observableArrayList();
	// les composants de la fenêtre
	private AnchorPane  		racine	= new AnchorPane();
	private TableView<Employe> 	tableEmployes= new TableView<Employe>();
	private Button 				bnAjouter 	= new Button("Ajouter");
	private Button 				bnSupprimer = new Button("Supprimer");

	// constructeur : initialisation de la fenetre
	public FenTableEmployes(){
		
		liste.add(new Employe(7369,"LECLERC","SECRETAIRE", 20) );
		liste.add(new Employe(7499,"BIRAUD","COMMERCIAL", 30) );
		liste.add(new Employe(7521,"BERGER","COMMERCIAL", 30) );
		liste.add(new Employe(7566,"MERCIER","DIRECTEUR", 20) );
		liste.add(new Employe(7654,"MARTIN","COMMERCIAL", 30) );
		liste.add(new Employe(7698,"NOIRET","DIRECTEUR", 30) );
		liste.add(new Employe(7782,"LESAGE","DIRECTEUR", 10) );
		
		this.setTitle("Liste des employes");
		this.setMinWidth(300);
		this.setMinHeight(300);
		this.setResizable(true);
		this.setScene(new Scene(creerContenu()));	
	}
	
	// creation du Scene graph
	private Parent creerContenu() {
		TableColumn<Employe,Integer> colonne1 = new TableColumn<Employe,Integer>("Matricule");
		colonne1.setCellValueFactory(new PropertyValueFactory<Employe,Integer>("matricule"));
		tableEmployes.getColumns().add(colonne1);
		
		TableColumn<Employe,Integer> colonne2 = new TableColumn<Employe,Integer>("Nom");
		colonne2.setCellValueFactory(new PropertyValueFactory<Employe,Integer>("nom"));
		tableEmployes.getColumns().add(colonne2);

		TableColumn<Employe,Integer> colonne3 = new TableColumn<Employe,Integer>("Poste");
		colonne3.setCellValueFactory(new PropertyValueFactory<Employe,Integer>("poste"));
		tableEmployes.getColumns().add(colonne3);
		
		TableColumn<Employe,Integer> colonne4 = new TableColumn<Employe,Integer>("Departement");
		colonne4.setCellValueFactory(new PropertyValueFactory<Employe,Integer>("departement"));
		tableEmployes.getColumns().add(colonne4);
		
		tableEmployes.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		
		tableEmployes.setItems(liste);		
		
		// detection et traitement des evenements
		bnAjouter.setPrefWidth(100);
		bnAjouter.setOnAction(e -> liste.add(new Employe(111, "Clint Eastwood", "INGENIEUR", 10)));
		
		bnSupprimer.setPrefWidth(100);
		bnSupprimer.setOnAction(e -> { int index = tableEmployes.getSelectionModel().getSelectedIndex();
										if (index != -1) {
											liste.remove(index);
										}
								});
		
		
			
		AnchorPane.setTopAnchor(bnAjouter, 10.0);
		AnchorPane.setRightAnchor(bnAjouter, 10.0);
		AnchorPane.setTopAnchor(bnSupprimer, 50.0);
		AnchorPane.setRightAnchor(bnSupprimer, 10.0);
		AnchorPane.setTopAnchor(tableEmployes, 10.0);
		AnchorPane.setLeftAnchor(tableEmployes, 10.0);
		AnchorPane.setRightAnchor(tableEmployes, 150.0);
		AnchorPane.setBottomAnchor(tableEmployes, 10.0);	
		racine.getChildren().addAll(tableEmployes, bnAjouter, bnSupprimer);
		return racine;
	}
}
