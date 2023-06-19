import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Exemple {
	
	public static void main(String[] args) {
	IntegerProperty p1 = new SimpleIntegerProperty(100);
	IntegerProperty p2 = new SimpleIntegerProperty();
	// p2 est liée à p1
	p2.bind(p1);
	// toute modification de p1 entraîne la modification de p2
	System.out.println(p2.get());
	p1.setValue(204.13);
	System.out.println(p2.get());
	}
}