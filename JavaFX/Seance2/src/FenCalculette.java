import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class FenCalculette extends Stage{
	private final String libelles[] 	= {"7","8","9","+","4","5","6","-","1","2","3","x","C","0","=","/"};
	private Button 		 lesBoutons[][]	= new Button[4][4];
	private TextField 	 ecran 			= new TextField("0");
	private BorderPane	root			= new BorderPane();
	private GridPane	root1			= new GridPane();

	
	public FenCalculette(){ 
		this.setTitle("Calculette"); 
		this.setResizable(true);
		Scene laScene = new Scene(creerContenu());
		this.setScene(laScene);
		this.sizeToScene();
	}
	
	// Méthode à écrire dans le cadre du TP2, en utilisant les Layout Pane les plus adaptés
	private Parent creerContenu(){
		int k = 0;
		for(int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				lesBoutons[i][j] = new Button(libelles[k]);
				k++;
				lesBoutons[i][j].setMinSize(50, 50);
				lesBoutons[i][j].setMaxSize(500, 500);
				GridPane.setHgrow(lesBoutons[i][j], Priority.ALWAYS);
				GridPane.setVgrow(lesBoutons[i][j], Priority.ALWAYS);
				root1.add(lesBoutons[i][j], j, i);
			}
		}
		
		root.setTop(ecran);
		BorderPane.setAlignment(ecran, Pos.CENTER);
		root.setCenter(root1);
		root.setPadding(new Insets(10));
		root1.setPadding(new Insets(10));
		/*BorderPane.setAlignment(root1, Pos.CENTER);*/
		
		return root;
		
	}
}