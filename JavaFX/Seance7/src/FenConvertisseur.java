
import javafx.beans.binding.*;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;

public class FenConvertisseur extends Stage{
	static private final double TAUX_DE_CHANGE = 1.07;
	
	public FenConvertisseur() {
		// les composants du formulaire
		Label 		labelEuro 	= new Label("Euros :");
		TextField 	txtEuros 	= new TextField("0.00");
		Label 		labelDollar = new Label("Dollars :");
		TextField 	txtDollar 	= new TextField("0.00");
		Button 		bnFermer 	= new Button("Fermer");

		// les propriétés
		SimpleDoubleProperty euros 	= new SimpleDoubleProperty();
		SimpleDoubleProperty calcul 	= new SimpleDoubleProperty();

		// les liaisons
		calcul.bind(euros.multiply(TAUX_DE_CHANGE));
		euros.bind(Bindings.createDoubleBinding(()->Double.parseDouble(txtEuros.getText()), txtEuros.textProperty()));
		txtDollar.textProperty().bind(Bindings.createStringBinding( () -> String.valueOf(calcul.get()), calcul));

		
		

		bnFermer.setOnAction(e -> this.close());
		GridPane grid = new GridPane();
		grid.addRow(0, labelEuro, txtEuros);
		grid.addRow(1, labelDollar, txtDollar);
		grid.add(bnFermer, 3, 2);
		grid.setPadding(new Insets(10));
		grid.setVgap(10);
		Scene scene = new Scene(grid);
		this.setTitle("Convertisseur");
		this.setScene(scene);
		this.setResizable(false);
		this.show();
	}
}
