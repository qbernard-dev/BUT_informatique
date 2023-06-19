
import javafx.beans.binding.*;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;

public class FenAddition extends Stage{
	public FenAddition() {
		// les composants du formulaire
		Label 		label1 		= new Label("Montant 1 : ");
		TextField 	montant1	= new TextField("0");
		Label 		label2 		= new Label("Montant 2 : ");
		TextField 	montant2 	= new TextField("0");
		Label 		label3 		= new Label("TOTAL : ");
		TextField 	total 		= new TextField();
		Button 		bnFermer 	= new Button("Fermer");

		// les propriétés
		SimpleIntegerProperty mtt1 	= new SimpleIntegerProperty();
		SimpleIntegerProperty mtt2 	= new SimpleIntegerProperty();
		SimpleIntegerProperty tt 	= new SimpleIntegerProperty();

		// les liaisons
		tt.bind(mtt1.add(mtt2));
		
		mtt1.bind(Bindings.createDoubleBinding(()->Double.parseDouble(montant1.getText()), montant1.textProperty()));
	
		mtt2.bind(Bindings.createDoubleBinding(()->Double.parseDouble(montant2.getText()), montant2.textProperty()));
		
		total.textProperty().bind(Bindings.createStringBinding( () -> String.valueOf(tt.get()), tt));
		
		bnFermer.setOnAction(e -> this.close() );
		total.setEditable(false);
		GridPane root = new GridPane();
		root.addRow(0, label1, montant1);
		root.addRow(1, label2, montant2);
		root.addRow(2, label3, total);
		root.add(bnFermer, 1, 3);
		root.setPadding(new Insets(10));
		root.setVgap(10);
		Scene scene = new Scene(root);
		this.setTitle("Addition");
		this.setResizable(false);
		this.setScene(scene);
		this.show();
	}
}




















