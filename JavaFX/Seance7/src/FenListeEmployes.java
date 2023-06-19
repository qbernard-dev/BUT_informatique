
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

public class FenListeEmployes extends Stage {
	// les donn�es
	ObservableList<String> liste = FXCollections.observableArrayList();
	// les composants de la fenêtre
	private AnchorPane  		racine	= new AnchorPane();
	private ListView<String> 	listeEmployes= new ListView<String>();
	private Button 				bnAjouter 	= new Button("Ajouter");
	private Button 				bnSupprimer = new Button("Supprimer");

	// constructeur : initialisation de la fenetre
	public FenListeEmployes(){
		
		liste.add("LECLERC");
		liste.add("BIRAUD");
		liste.add("BERGER");
		liste.add("MERCIER");
		
		this.setTitle("Liste des employes");
		this.setMinWidth(300);
		this.setMinHeight(300);
		this.setResizable(true);
		this.setScene(new Scene(creerContenu()));	
	}
	
	// creation du Scene graph
	private Parent creerContenu() {
		listeEmployes.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		
		this.listeEmployes.setItems(liste);
		
		// detection et traitement des evenements
		bnAjouter.setPrefWidth(100);
		bnAjouter.setOnAction(e -> liste.add("Clint Eastwood"));
		
		
		
		bnSupprimer.setPrefWidth(100);
		bnSupprimer.setOnAction(e -> {
			int index = listeEmployes.getSelectionModel().getSelectedIndex();
			if (index!=-1) {
				liste.remove(index);
			}
		});
		
		listeEmployes.setItems(liste);
		
		BooleanBinding rien = Bindings.equal(-1, listeEmployes.getSelectionModel().selectedIndexProperty());
		bnSupprimer.disabledProperty().bind(Bindings.when(rien).then(true).otherwise(false));
		/*
		bnSupprimer.disableProperty().bind(
				Bindings.when(liste.size()).then(true).otherwise(false));
				*/
			
		AnchorPane.setTopAnchor(bnAjouter, 10.0);
		AnchorPane.setRightAnchor(bnAjouter, 10.0);
		AnchorPane.setTopAnchor(bnSupprimer, 50.0);
		AnchorPane.setRightAnchor(bnSupprimer, 10.0);
		AnchorPane.setTopAnchor(listeEmployes, 10.0);
		AnchorPane.setLeftAnchor(listeEmployes, 10.0);
		AnchorPane.setRightAnchor(listeEmployes, 150.0);
		AnchorPane.setBottomAnchor(listeEmployes, 10.0);	
		racine.getChildren().addAll(listeEmployes, bnAjouter, bnSupprimer);
		return racine;
	}
}
