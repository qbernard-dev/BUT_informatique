import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
 	  
public class FenConvertisseur extends Stage {
	private final float tauxDeChange = (float) 1.07;
	
	private VBox 		racine 			= new VBox();
	private HBox 		zoneSaisie		= new HBox();
	private TextField 	txtEuros 		= new TextField();
	private TextField 	txtDollars		= new TextField();
	private Label 		lblEuro 		= new Label("euros");
	private Label 		lblDollar		= new Label("dollars");
	private Label 		message			= new Label();
	private Button 		bnConvertir 	= new Button("Convertir >");
	
	public FenConvertisseur(){ 
		this.setTitle("Convertisseur"); 
		this.setResizable(false);
		Scene laScene = new Scene(creerScene());
		this.setScene(laScene);
		this.sizeToScene();
		
		zoneSaisie.setOnKeyReleased(e -> {
			if(! this.isNumeric(txtEuros.getText())) {
				message.setText("Invalide");
			}
			else {
				message.setText("");
			}
		});
		
		bnConvertir.setOnAction(e -> {
			if(! this.isNumeric(txtEuros.getText())) {
				message.setText("Impossible de convertir");
			}
			else {
				if(txtEuros.getText().length() == 0) {
					message.setText("Le champs de saisie est vide");
				}
				else {
					txtDollars.setText(""+Float.parseFloat(txtEuros.getText()) * tauxDeChange);
				}
			}
		});
	}
	
	private Parent creerScene(){
		txtDollars.setEditable(false);
		message.setTextFill(Color.RED);
			
		zoneSaisie.setSpacing(10);
		zoneSaisie.setPadding(new Insets(10));
		zoneSaisie.setAlignment(Pos.CENTER);
		zoneSaisie.getChildren().addAll(txtEuros, lblEuro,bnConvertir, txtDollars, lblDollar);
		
		racine.setPadding(new Insets(10));
		racine.getChildren().addAll(zoneSaisie, message);
		racine.setAlignment(Pos.CENTER);
		
		return racine;
	}
	
	
	
	
	
	private boolean isNumeric(String str) {
		// renvoie true si la chaine str correspond à un nombre positif et éventuellement à virgule
		return str.matches("\\d*(\\.\\d+)?");  //match a number with optionnal decimal.
	}
}