package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("loginScene.fxml"));
		Scene scene = new Scene(root);		
		stage.setScene(scene);
		stage.show();
	}
}


//stage.setFullScreen(true);
//stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("x"));

//stage.setTitle("WORKSHOP MANAGEMENT");
//Image icon = new Image("bmw_x6.jpg");
//stage.getIcons().add(icon); 
//@Override
//public void start(Stage primaryStage) {
//	try {
//		BorderPane root = new BorderPane();
//		Scene scene = new Scene(root,400,400);
//		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//		primaryStage.setScene(scene);
//		primaryStage.show();
//	} catch(Exception e) {
//		e.printStackTrace();
//	}
//}
