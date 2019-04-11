package application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SignUp {
	Stage window;
	Scene scene1, scene2;

	public static void signup() throws Exception {
		try {

			Stage primaryStage = new Stage();
			// resolution of stage
			primaryStage.setMinHeight(600);
			primaryStage.setMinWidth(1024);
			primaryStage.setMaxHeight(600);
			primaryStage.setMaxWidth(1024);
			//
			// Grid of home screen
			GridPane grid = new GridPane();
			grid.setPadding(new Insets(10, 10, 10, 10));
			grid.setVgap(8);
			grid.setHgap(8);
			//

			// Form
			// Username
			Label nameLabel = new Label("Username:");
			GridPane.setConstraints(nameLabel, 0, 0);

			// Username Input
			TextField nameInput = new TextField("username");
			GridPane.setConstraints(nameInput, 1, 0);

			// Email
			@SuppressWarnings("unused")
			Label email = new Label("Email:");
			GridPane.setConstraints(nameLabel, 0, 1);

			// Email Label
			Label emailLabel = new Label("for example: salim@example.com");
			GridPane.setConstraints(emailLabel, 1, 1);

			// Password Label
			Label passLabel = new Label("Password:");
			GridPane.setConstraints(passLabel, 0, 2);

			// Password Input
			TextField passInput = new TextField();
			passInput.setPromptText("password");
			GridPane.setConstraints(passInput, 1, 2);

			// Add Buttons and names to grid
			// grid.getChildren().addAll(loginButton, InscriptionButton,Description);
			//

			// Scene Properieties
			Scene scene1 = new Scene(grid, 1024, 600);
			primaryStage.setScene(scene1);
			primaryStage.setTitle("Sistema de vuelos"); // Name of App
			primaryStage.show();
			//

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
