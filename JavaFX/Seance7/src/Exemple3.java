import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Exemple3 {
	
	public static void main(String[] args) {
		
		IntegerProperty rayon = new SimpleIntegerProperty(10);
		DoubleBinding perimetre = rayon.multiply(2*Math.PI);
		
		System.out.println(perimetre.get());
		rayon.setValue(100);
		System.out.println(perimetre.get());
		
		
		
		IntegerProperty p1 = new SimpleIntegerProperty(10);
		IntegerProperty p2 = new SimpleIntegerProperty(20);
		NumberBinding total = p1.add(p2);
		System.out.println(total.getValue());
		p1.setValue(15);
		p2.setValue(25);
		System.out.println(total.getValue());
	}

}
