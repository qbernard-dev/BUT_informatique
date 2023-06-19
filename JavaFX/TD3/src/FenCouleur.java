
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class FenCouleur extends Stage{
	private Label		message		= new Label("Choisissez une couleur :");
	private RadioButton	rbBleu		= new RadioButton("Bleu");
	private RadioButton	rbVert		= new RadioButton("Vert");
	private RadioButton	rbJaune		= new RadioButton("Jaune");
	private RadioButton	rbOrange	= new RadioButton("Orange");
	private Rectangle	rectangle	= new Rectangle();
	private Button		bnOK		= new Button("OK");
	private Button		bnAnnuler	= new Button("Annuler");
	private Color 		last = Color.BLUE;
	
	public FenCouleur(){ 
		this.setTitle("Couleur");
		this.setResizable(false);
		this.setWidth(250);
		this.setHeight(250);
		
		rbBleu.setOnAction(e -> {
			rectangle.setFill(Color.BLUE);
			last  = Color.BLUE;
		});
		
		rbVert.setOnAction(e -> {
			rectangle.setFill(Color.GREEN);
			last = Color.GREEN;
		});
		
		rbJaune.setOnAction(e -> {
			rectangle.setFill(Color.YELLOW);
			last = Color.YELLOW;
		});
		
		rbOrange.setOnAction(e -> {
			rectangle.setFill(Color.ORANGE);
			last = Color.ORANGE;
		});
		
		bnOK.setOnAction(e ->{
			close();
		});
		
		bnAnnuler.setOnAction(e ->{
			close();
		});
		
		rbVert.setOnMouseEntered(e -> {
			rectangle.setFill(Color.GREEN);
		});
		
		rbVert.setOnMouseExited(e -> {
			rectangle.setFill(last);
		});
		
		rbOrange.setOnMouseEntered(e -> {
			rectangle.setFill(Color.ORANGE);
		});
		
		rbOrange.setOnMouseExited(e -> {
			rectangle.setFill(last);
		});
		
		rbJaune.setOnMouseEntered(e -> {
			rectangle.setFill(Color.YELLOW);
		});
		
		rbJaune.setOnMouseExited(e -> {
			rectangle.setFill(last);
		});
		
		rbBleu.setOnMouseEntered(e -> {
			rectangle.setFill(Color.BLUE);
		});
		
		rbJaune.setOnMouseExited(e -> {
			rectangle.setFill(last);
		});
		
		Scene laScene = new Scene(creerContenu());
		this.setScene(laScene);
	}
		
	private Parent creerContenu(){	
		BorderPane racine = new BorderPane();
		VBox zoneBoutonsRadio = new VBox();
		HBox zoneBoutons = new HBox();
		ToggleGroup groupe = new ToggleGroup();
		
		groupe.getToggles().addAll(rbBleu, rbVert, rbJaune, rbOrange);
		groupe.selectToggle(rbBleu);   //ou bien rbBleu.setSelected(true);
		zoneBoutonsRadio.setPadding(new Insets(10));
		zoneBoutonsRadio.setSpacing(20);
		zoneBoutonsRadio.getChildren().addAll(rbBleu, rbVert, rbJaune, rbOrange);
		
		rectangle.setWidth(120);
		rectangle.setHeight(120);
		rectangle.setFill(Color.BLUE);
		
		bnAnnuler.setPrefWidth(80);
		bnOK.setPrefWidth(80);
		
		zoneBoutons.setPadding(new Insets(10));
		zoneBoutons.setSpacing(10);
		zoneBoutons.setAlignment(Pos.CENTER_RIGHT);
		zoneBoutons.getChildren().addAll(bnOK, bnAnnuler);
		
		racine.setPadding(new Insets(10));
		racine.setTop(message);
		racine.setLeft(zoneBoutonsRadio);
		racine.setCenter(rectangle);
		racine.setBottom(zoneBoutons);
		return racine;								
	}
}
