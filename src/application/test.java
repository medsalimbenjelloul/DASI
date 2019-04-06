package application;

import jade.wrapper.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class test {
	public void tii(Stage primaryStage) throws Exception {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
			primaryStage.setTitle("Sistemas de vuelos");
			primaryStage.setScene(new Scene(root, 1366, 768));
			primaryStage.show();
			
			HelloAg agentController = new HelloAg();
			jade.util.Event event = new jade.util.Event(-1, this, new HelloAg());
			agentController.putO2AObject(event, AgentController.ASYNC);
			
			@SuppressWarnings("unused")
			Object someObjectFromAgent = event.waitUntilProcessed(10 * 60 * 1000);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
