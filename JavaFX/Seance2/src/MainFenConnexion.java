import javafx.application.Application;
import javafx.stage.Stage;

public class MainFenConnexion extends Application{
	public void start(Stage primaryStage){
		primaryStage = new FenConnexion ();
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		Application.launch();
	}
}