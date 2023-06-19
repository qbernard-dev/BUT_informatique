
import javafx.application.Application;
import javafx.beans.binding.*;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

public class FenConnexion extends Stage{
	public FenConnexion()  {
		// les composants du formulaire
		Label 			lblLogin 		= new Label("Login : ");
		TextField 		txtLogin		= new TextField();
		Label 			lblPassword 	= new Label("Password : ");
		PasswordField 	txtPassword		= new PasswordField();
		Button 			bnSeConnecter 	= new Button("Se connecter");

		//Activation ou désactivation d'un bouton avec condition	
		bnSeConnecter.disableProperty().bind(
				Bindings.when(Bindings.or(txtPassword.textProperty().isEmpty(), txtLogin.textProperty().isEmpty())).
						then(true).
						otherwise(false));
		
		bnSeConnecter.setOnAction(e -> this.close());
		GridPane grid = new GridPane();
		grid.addRow(0, lblLogin, txtLogin);
		grid.addRow(1, lblPassword, txtPassword);
		grid.add(bnSeConnecter, 3, 2);
		grid.setPadding(new Insets(10));
		grid.setVgap(10);
		Scene scene = new Scene(grid);
		this.setTitle("Connexion");
		this.setScene(scene);
		this.setResizable(false);
		this.show();
	}
}
















