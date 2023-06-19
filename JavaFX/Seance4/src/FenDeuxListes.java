import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class FenDeuxListes extends Stage { 
	// Les composants de la fenêtre
		private ListView<String> 	listeGauche		= new ListView<String>();
		private ListView<String>	listeDroite		= new ListView<String>();
		private Button 				bnTransferer 	= new Button(">");
		private Button 				bnTransferer2 	= new Button("<");
		private HBox 				root 			= new HBox();
	
	public FenDeuxListes(){ 
		this.setTitle("DnD entre deux listes"); 
		this.setResizable(false);
		Scene laScene = new Scene(creerContenu());
		this.setScene(laScene);
		this.sizeToScene();
		
		listeGauche.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		listeDroite.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	}
	
	private Parent creerContenu(){
		for (int i=1 ; i<11 ; i++){
			listeGauche.getItems().add("Elément "+i);
		}
		bnTransferer.setPrefWidth(80);
		
		bnTransferer.setOnAction(e -> {
			gererClick(e);
		});
		
		bnTransferer2.setPrefWidth(80);

		bnTransferer.setOnMouseDragged(e -> {
			if(! (e.getSceneY() > this.getScene().getHeight() - 25) && e.getSceneY() >= 0) {
				bnTransferer.setTranslateY(e.getSceneY()) ;
			}
		});
		
		listeGauche.setOnDragDetected(e -> {
			// on crée le DragBoard en définissant le mode de transfert
			Dragboard db = listeGauche.startDragAndDrop(TransferMode.COPY_OR_MOVE);
			// on crée un contenu...
			ClipboardContent content = new ClipboardContent();
			
			String a = "";
			for(String it : listeGauche.getSelectionModel().getSelectedItems()) {
				a += it + "\n";
			}
			
			// ...pour y placer l'élément sélectionné dans la liste
			content.putString(a);
			db.setContent(content);
		});

		listeDroite.setOnDragOver(e -> {
			// ici la zone cible accepte les données transférées ou copiées du DnD
			e.acceptTransferModes(TransferMode.COPY_OR_MOVE);
		});
		
		listeDroite.setOnDragDropped(e -> {
			// on récupère l'élément précédemment sauvegardé dans le Dragboard...
			Dragboard db = e.getDragboard();
			String data = db.getString();
			String [] elements = data.split("\n");

			// ... et on l'ajoute à la liste de droite
			listeDroite.getItems().addAll(elements);
			// on signale la fin de l'opération. Ceci va déclencher l'événement
			// "Dragdone" (voir ci-après)
			e.setDropCompleted(true);
		});
		
		listeGauche.setOnDragDone(e -> {
			// si le mode de transfert était un MOVE, on supprime, dans la liste de
			// gauche, l'élément transféré	
			if (e.getTransferMode() == TransferMode.MOVE) {
				listeGauche.getItems().removeAll(listeGauche.getSelectionModel().getSelectedItems());
				}
		});
		
		/*
		 * Droite à gauche
		 */
		
		listeDroite.setOnDragDetected(e -> {
			// on crée le DragBoard en définissant le mode de transfert
			Dragboard db = listeDroite.startDragAndDrop(TransferMode.COPY_OR_MOVE);
			// on crée un contenu...
			ClipboardContent content = new ClipboardContent();
			
			String a = "";
			for(String it : listeDroite.getSelectionModel().getSelectedItems()) {
				a += it + "\n";
			}
			
			// ...pour y placer l'élément sélectionné dans la liste
			content.putString(a);
			db.setContent(content);
		});

		listeGauche.setOnDragOver(e -> {
			// ici la zone cible accepte les données transférées ou copiées du DnD
			e.acceptTransferModes(TransferMode.COPY_OR_MOVE);
		});
		
		listeGauche.setOnDragDropped(e -> {
			// on récupère l'élément précédemment sauvegardé dans le Dragboard...
			Dragboard db = e.getDragboard();
			String data = db.getString();
			String [] elements = data.split("\n");

			// ... et on l'ajoute à la liste de droite
			listeGauche.getItems().addAll(elements);
			// on signale la fin de l'opération. Ceci va déclencher l'événement
			// "Dragdone" (voir ci-après)
			e.setDropCompleted(true);
		});
		
		listeDroite.setOnDragDone(e -> {
			// si le mode de transfert était un MOVE, on supprime, dans la liste de
			// gauche, l'élément transféré	
			if (e.getTransferMode() == TransferMode.MOVE) {
				listeGauche.getItems().removeAll(listeDroite.getSelectionModel().getSelectedItems());
				}
		});
		root.getChildren().addAll(listeGauche, bnTransferer, listeDroite, bnTransferer2);
		return root;
	}
	
	private void gererClick(ActionEvent e) {
		listeDroite.getItems().add(listeGauche.getSelectionModel().getSelectedItem());
		listeGauche.getItems().remove(listeGauche.getSelectionModel().getSelectedItem());
	}

	
}