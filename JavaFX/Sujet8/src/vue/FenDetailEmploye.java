package vue;

import java.time.LocalDate;
import java.util.ArrayList;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import presentation.Employe;
import presentation.Principale;

public class FenDetailEmploye extends Stage {
	
	// les composants du formulaire
	private GridPane			racine			= new GridPane();
	private HBox				zoneBoutons		= new HBox();
	private Label 				lblMatricule	= new Label("Matricule (*) :");
	private Label 				lblNom			= new Label("Nom employé (*) : ");
	private Label 				lblPoste		= new Label("Poste : ");
	private Label 				lblSuperieur	= new Label("Supérieur :");
	private Label 				lblEmbauche		= new Label("Date embauche : ");
	private Label 				lblSalaire		= new Label("Salaire : ");
	private Label 				lblEurosSalaire	= new Label("euros");
	private Label 				lblPrime		= new Label("Prime :");
	private Label 				lblEurosPrime	= new Label("euros");
	private Label 				lblDepartement	= new Label("Département (*) : ");
	private TextField			txtMatricule	= new TextField();
	private TextField			txtNom			= new TextField();
	private TextField			txtPoste		= new TextField();
	private ComboBox<String>	cbSuperieur		= new ComboBox<String>();
	private DatePicker			dpEmbauche		= new DatePicker();
	private TextField			txtSalaire		= new TextField();
	private TextField			txtPrime		= new TextField();
	private ComboBox<String>	cbDept			= new ComboBox<String>();
	private Button 				bnOK 			= new Button("OK");
	private Button 				bnAnnuler 		= new Button("Annuler");
	private Tooltip infoBulleSuperieur =new Tooltip("Choisissez le matricule du supérieur hiérarchique");
	
	// constructeur : initialisation de la fenetre et des données
	public FenDetailEmploye(){		
		this.setTitle("Détail employé");
		this.sizeToScene();
		this.setResizable(false);
		this.setScene(new Scene(creerContenu()));	
	}
	
	private Parent creerContenu() {
		txtMatricule.setDisable(true);	// le matricule n'est pas modifiable (c'est un identifiant)
		this.dpEmbauche.setEditable(false);
		
		cbSuperieur.setTooltip(infoBulleSuperieur);
		
		BooleanBinding manque = Bindings.or(
			Bindings.or(txtMatricule.textProperty().isEmpty(), txtNom.textProperty().isEmpty()),
			Bindings.equal(cbDept.getSelectionModel().selectedIndexProperty(), -1)
			);
			
		bnOK.setPrefWidth(100);
		bnOK.setOnAction(e -> {
			if(!estDecimal(txtPrime.getText())) {
				Alert erreur = new Alert(AlertType.ERROR, "La prime doit contenir que des entiers/décimaux  MERCI", ButtonType.OK);
				erreur.showAndWait();
			} else if(!estDecimal(txtSalaire.getText())) {
				Alert erreur = new Alert(AlertType.ERROR, "Le salaire doit contenir que des entiers/décimaux  MERCI", ButtonType.OK);
				erreur.showAndWait();
			}
			
			else {
				int matr = Integer.parseInt(txtMatricule.getText());
				String nom = txtNom.getText();
				String poste = txtPoste.getText();
				String date  = dpEmbauche.getValue().getDayOfMonth() + "/" + dpEmbauche.getValue().getMonthValue() + "/" + dpEmbauche.getValue().getYear();
				float sal = Float.parseFloat(txtSalaire.getText());
				float prime = Float.parseFloat(txtPrime.getText());
				int dept = Integer.parseInt(cbDept.getSelectionModel().getSelectedItem());
				int sup = Integer.parseInt(cbSuperieur.getSelectionModel().getSelectedItem());
				
				Employe emp = new Employe(matr, nom,  poste, sup, date, sal, prime, dept);
				Principale.modifierEmploye(emp);
				this.close();
				}
		});
		bnAnnuler.setPrefWidth(100);

		// construction du Scene Graph
		zoneBoutons.getChildren().addAll(bnOK, bnAnnuler);
		zoneBoutons.setSpacing(10);
		racine.addRow(0,  lblMatricule, txtMatricule);
		racine.addRow(1,  lblNom, txtNom);
		racine.addRow(2,  lblPoste, txtPoste);
		racine.addRow(3,  lblSuperieur, cbSuperieur);
		racine.addRow(4,  lblEmbauche, dpEmbauche);
		racine.addRow(5,  lblSalaire, txtSalaire, lblEurosSalaire);
		racine.addRow(6,  lblPrime, txtPrime, lblEurosPrime);
		racine.addRow(7,  lblDepartement, cbDept);
		racine.add(zoneBoutons, 1, 10);
		racine.setHgap(10);
		racine.setVgap(15);
		racine.setPadding(new Insets(10));
		return racine;
	}
	

	public void init(ArrayList<Integer> lesSup, ArrayList<Integer> lesDep, int mat, String nom, String poste, int sup, String emb, float sal, float prime, int dep) {
		txtMatricule.setText(""+mat);
		txtNom.setText(nom);
		txtPoste.setText(poste);
		txtSalaire.setText(String.valueOf(sal));
		if (prime == -1.0) {
			txtPrime.setText(String.valueOf(0));
		} else {
			txtPrime.setText(String.valueOf(prime));
		}
				
		this.cbSuperieur.getItems().clear();
		this.cbSuperieur.getItems().add(0, "- aucun -");
		for (int i=0; i<lesSup.size() ; i++) {
			if (lesSup.get(i) != mat) {
				this.cbSuperieur.getItems().add(""+lesSup.get(i));
			}
		}
		if(sup == -1) {
			cbSuperieur.getSelectionModel().select(0);
		} else {
			this.cbSuperieur.setValue(""+sup);
		}
		
		this.cbDept.getItems().clear();
		for (int i=0; i<lesDep.size() ; i++) {
			this.cbDept.getItems().add(""+lesDep.get(i));
		}
		this.cbDept.setValue(""+dep);
		
		String morceau[]  = emb.split("/");
		
		dpEmbauche.setValue(LocalDate.of(Integer.parseInt(morceau[0]), Integer.parseInt(morceau[1]), Integer.parseInt(morceau[2])));
		
	}
	
	private boolean estDecimal(String str) {
		return str.matches("\\d*(\\.\\d+)?");
	}
	}
