import javafx.application.Application;
import javafx.stage.Stage;

public class MainExo extends Application{
	public void start(Stage primaryStage){
		primaryStage = new MaFenetre ();
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		Application.launch();
	}
}