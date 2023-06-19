import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.ToggleGroup;

public class Formulaire2 extends Stage {
	
	
	private HBox	root = new HBox();
	private VBox	root1 = new VBox();
	
	private VBox	iden = new VBox();
	private VBox	abo = new VBox();
	private VBox	paye = new VBox();
	
	private Button		bnok = new Button("OK");
	private Button		bnannuler = new Button("Annuler");
	private Label		identite = new Label("Identité");
	private Label		abonnement = new Label("Abonnement");
	private Label		paiment	= new Label("Moyen de paiment");
	
	private Label		nom = new Label("Nom* :");
	private Label		prenom = new Label("Prenom* :");
	private Label		adresse = new Label("Adresse* :");
	private Label		code = new Label("Code Postal* :");
	private Label		ville = new Label("Ville* :");
	private Label		tel = new Label("Téléphone* :");
	private Label		mail = new Label("E-mail* :");
	private Label		videL = new Label("");
	
	private TextField	textNom = new TextField();
	private TextField	textPrenom = new TextField();
	private TextField	textAdresse = new TextField();
	private TextField	textAdresse1= new TextField();
	private TextField	textCode = new TextField();
	private TextField	textVille = new TextField();
	private TextField	textTel = new TextField();
	private TextField	textMail = new TextField();
	
	private HBox		pre_nom = new HBox();
	private HBox		habite = new HBox();
	private HBox		videH = new HBox();
	private HBox		lieu = new HBox();
	private HBox		phone = new HBox();
	private HBox		email = new HBox();
	
	private HBox		HF_duo	= new HBox();
	private HBox		HF_num	= new HBox();
	private RadioButton		F_duo = new RadioButton();
	private RadioButton		F_num = new RadioButton();
	private Label	textFduo	= new Label("Formule DUO (81.40 euros)");
	private Label 	textFnum	= new Label("Formule NUMERIQUE (76.40 euro)");
	private ToggleGroup		formule = new ToggleGroup();
	
	private HBox	carte	= new HBox();
	private HBox	cheque	= new HBox();
	private RadioButton	prev	= new RadioButton();
	private RadioButton cheq	= new RadioButton();
	private Label	text_prev	= new Label("Prélèvement");
	private Label 	text_cheque	= new Label("Chèque");
	private ToggleGroup		mode_paye = new ToggleGroup();
	
	private CheckBox B_pub	= new CheckBox("Accepte de recevoir des informations");
	
	//message erreur
	private Label	message = new Label("Format Incorrect. Ne saisir que des chiffres");

	
	public Formulaire2() {
		this.setTitle("Formulaire");
		this.setResizable(false);
		this.initModality(Modality.APPLICATION_MODAL);
		Scene laScene = new Scene(creerContenu());
		this.setScene(laScene);
		this.sizeToScene();
	}
	
	private Parent creerContenu() {
		
		iden.setBackground(new Background(new BackgroundFill(Color.HOTPINK,new CornerRadii(0),new Insets(0))));
		abo.setBackground(new Background(new BackgroundFill(Color.HOTPINK,new CornerRadii(0),new Insets(0))));
		paye.setBackground(new Background(new BackgroundFill(Color.HOTPINK,new CornerRadii(0),new Insets(0))));
		
		bnok.setPrefWidth(80);
		bnannuler.setPrefWidth(80);
		nom.setPrefWidth(120);
		prenom.setPrefWidth(80);
		mail.setPrefWidth(120);
		adresse.setPrefWidth(120);
		videL.setPrefWidth(120);
		tel.setPrefWidth(120);
		code.setPrefWidth(120);
		ville.setPrefWidth(80);
		
		root.setAlignment(Pos.CENTER_RIGHT);
		root.setSpacing(10);
		root1.setSpacing(15);		
		root1.setPadding(new Insets(20));
		
		iden.setPadding(new Insets(10));
		iden.setSpacing(10);
		HBox.setMargin(prenom, new Insets(0,0,0,10));
		HBox.setMargin(ville, new Insets(0,0,0,10));
		textMail.setPrefWidth(280);
		textCode.setPrefWidth(70);
		textTel.setPrefWidth(110);
		textNom.setPrefWidth(140);
		textPrenom.setPrefWidth(140);
		textAdresse.setPrefWidth(280);
		textAdresse1.setPrefWidth(280);
		
		abo.setPadding(new Insets(10));
		abo.setSpacing(10);
		
		paye.setPadding(new Insets(10));
		paye.setSpacing(10);
		
		//Gestion erreur
		textNom.setOnKeyReleased(e ->{
			if (textNom.getText().length() >=16){
			textNom.deletePreviousChar();
			}
		});
		
		textPrenom.setOnKeyReleased(e ->{
			if (textPrenom.getText().length() >=16){
			textPrenom.deletePreviousChar();
			}
		});
				
		this.textAdresse.setOnKeyTyped(e -> {
			if (textAdresse.getText().length() >= 39) {
				e.consume();
				Alert erreur = new Alert(AlertType.ERROR, "Le doit être sur max 38 caractères. Veuillez modifier ce champ.", ButtonType.OK);
				erreur.setTitle("Adresse (zone1) : format incorrect");
				erreur.showAndWait();
				textAdresse.deletePreviousChar();
			}
		});
		
		this.textAdresse1.setOnKeyTyped(e -> {
			if (textAdresse1.getText().length() >= 39) {
				e.consume();
				Alert erreur = new Alert(AlertType.ERROR, "Le doit être sur max 38 caractères. Veuillez modifier ce champ.", ButtonType.OK);
				erreur.setTitle("Adresse (zone2) : format incorrect");
				erreur.showAndWait();
				textAdresse1.deletePreviousChar();
			}
		});
		
		this.textVille.setOnKeyTyped(e -> {
			if (textVille.getText().length() >= 33) {
				e.consume();
				Alert erreur = new Alert(AlertType.ERROR, "Le doit être sur max 32 caractères. Veuillez modifier ce champ.", ButtonType.OK);
				erreur.setTitle("Adresse (zone2) : format incorrect");
				erreur.showAndWait();
				textVille.deletePreviousChar();
			}
		});
		
		message.setStyle("-fx-font-size:10 ; -fx-text-fill:RED");
		textCode.setOnKeyReleased(e ->{
			if (estValide(textCode.getText()) ) {
				message.setVisible(false);
				} else {
				message.setVisible(true);
			}
		});

		this.textCode.setOnKeyTyped(e -> {
			if (textCode.getText().length() >= 6) {
				e.consume();
				Alert erreur = new Alert(AlertType.ERROR, "Le doit être sur 5 caractères. Veuillez modifier ce champ.", ButtonType.OK);
				erreur.setTitle("Adresse (zone2) : format incorrect");
				erreur.showAndWait();
				textCode.deletePreviousChar();
			}
		});
		
		//Gerer les clicks sur les boutons 
		bnannuler.setOnAction(e -> this.close() );
		
		bnok.setOnAction(e -> {
			
			if(!mailValide()) {
				Alert erreur = new Alert(AlertType.ERROR, "Le mail doit contenir '@'. Veuillez modifier ce champ.", ButtonType.OK);
				erreur.setTitle("Mail : format incorrect");
				erreur.showAndWait();
				textMail.clear();
			}
			
			
			
			Abonnement nv_abo = new Abonnement(
					textNom.getText(),
					textPrenom.getText(),
					textAdresse.getText(),
					textAdresse1.getText(),
					textCode.getText(),
					textVille.getText(),
					telephone,
					textMail.getText(),
					form,
					modeRegl);
		});
		
		//Ajout des enfants (structure de la page)
		
		pre_nom.getChildren().addAll(nom,textNom,prenom,textPrenom);
		habite.getChildren().addAll(adresse,textAdresse);
		videH.getChildren().addAll(videL,textAdresse1);
		lieu.getChildren().addAll(code,textCode,ville,textVille);
		phone.getChildren().addAll(tel,textTel);
		email.getChildren().addAll(mail,textMail);
		iden.getChildren().addAll(pre_nom,habite,videH,lieu,phone,email);
		
		formule.getToggles().addAll(F_duo, F_num);
		HF_duo.getChildren().addAll(F_duo, textFduo);
		HF_num.getChildren().addAll(F_num, textFnum);
		abo.getChildren().addAll(HF_duo, HF_num);
		
		mode_paye.getToggles().addAll(prev, cheq);
		carte.getChildren().addAll(prev, text_prev);
		cheque.getChildren().addAll(cheq, text_cheque);
		paye.getChildren().addAll(carte, cheque);
		
		root.getChildren().addAll(bnok, bnannuler);
		root1.getChildren().addAll(identite,iden,abonnement,abo,paiment,paye,B_pub,root);	
		
		return root1;
	}

	// test de validité d’un code postal (considéré comme une série de chiffres5)
	private boolean estValide(String str) {
	return str.matches("\\d+");
	}
	
	//test email
	private boolean mailValide() {
		return textMail.getText().contains("@");
	}
}
