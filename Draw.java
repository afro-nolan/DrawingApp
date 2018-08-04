//Displays Draw's Gui

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Draw extends Application {

	@Override
	public void start(Stage stage) throws Exception {

		Parent root  = FXMLLoader.load(getClass().getResource("Draw.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Draw");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}