import javafx.application.Application;
import javafx.stage.Stage;

public class MainConvertisseur extends Application{
	public void start(Stage primaryStage){
		primaryStage = new FenConvertisseur ();
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		Application.launch();
	}
}