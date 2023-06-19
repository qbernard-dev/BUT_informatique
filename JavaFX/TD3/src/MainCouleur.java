import javafx.application.Application;
import javafx.stage.Stage;

public class MainCouleur extends Application{
	public void start(Stage primaryStage){
		primaryStage = new FenCouleur ();
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		Application.launch();
	}
}