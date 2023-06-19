import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

public class Exemple4 {

	public static void main(String[] args) {
		/*
		//BIDIRECTIONNEL
		SimpleIntegerProperty nb = new SimpleIntegerProperty();
		SimpleStringProperty texte = new SimpleStringProperty();
		
		// création du "converter" nombre <-> chaine
		StringConverter<Number> converter = new NumberStringConverter();
		
		// liaison bidirectionnelle qui utilise le "converter"
		Bindings.bindBidirectional(texte, nb, converter);
		
		nb.setValue(10);
		System.out.println(texte.get());
		
		texte.set("123");
		System.out.println(nb.get());
		*/
		
		
		//UNIDIRECTIONNEL
		SimpleIntegerProperty nb = new SimpleIntegerProperty();
		SimpleStringProperty texte = new SimpleStringProperty();
		
		// création d’une liaison : convert est liée à nb moyennant une conversion
		// de type : la valeur de nb est transformée en chaine
		
		StringBinding convert = Bindings.createStringBinding( () -> String.valueOf(nb.get()), nb);
		
		// liaison avec cette nouvelle "Binding"
		texte.bind(convert);
		nb.setValue(10);
		System.out.println(texte.get());
		texte.set("20");
		System.out.println(nb.get());
	}

}
