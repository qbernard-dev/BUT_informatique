import javafx.application.Application;
import javafx.stage.Stage;

public class MainFenCalulette extends Application{
	public void start(Stage primaryStage){
		primaryStage = new FenCalculette ();
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		Application.launch();
	}
}