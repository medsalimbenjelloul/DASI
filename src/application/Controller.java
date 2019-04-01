package application;

import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Window;

public class Controller {

	@FXML
	private Pane pane;

	@FXML
	private VBox VBox1;

	@FXML
	private ToolBar Toolbar1;

	@FXML
	private Button login;

	@FXML
	private Button signup;

	@FXML
	private VBox Vbox2;

	@FXML
	private TextField username;

	@FXML
	private PasswordField password;

	@FXML
	private TextField email;

	@FXML
	private TextField phone;

	@FXML
	private TextField country;

	@FXML
	private Button submit;

	@FXML
	private Button cancel;

	@FXML
	private VBox Vbox3;

	@FXML
	private TextField usernameLogin;

	@FXML
	private PasswordField passwordLogin;

	@FXML
	private TextField emailLogin;

	@FXML
	private Button LoginAccount;

	@FXML
	private Button ExitLoginPage;

	@FXML
	void LoadInscriptionPage(ActionEvent event) {
		// Go to Insctiption page
		if (event.getSource() == signup) {
			Vbox2.setDisable(false);
			Vbox2.setOpacity(1);

			VBox1.setDisable(true);
			VBox1.setOpacity(0);

		}

		// Go to Login page
		if (event.getSource() == login) {
			Vbox3.setDisable(false);
			Vbox3.setOpacity(1);
			Vbox2.setDisable(true);
			Vbox2.setOpacity(0);
			VBox1.setDisable(true);
			VBox1.setOpacity(0);

		}

		// Go to Home page
		if (event.getSource() == cancel || event.getSource() == ExitLoginPage) {

			Vbox2.setDisable(true);
			Vbox2.setOpacity(0);
			Vbox3.setDisable(true);
			Vbox3.setOpacity(0);
			VBox1.setDisable(false);
			VBox1.setOpacity(1);

		}
	}

	@FXML
	void Submit(ActionEvent event) {
		if (event.getSource() == submit) {

			if (username.getText().isEmpty()) {
				showAlert(Alert.AlertType.ERROR, pane.getScene().getWindow(), "Form Error!", "Please enter your name");
				return;
			}
			if (password.getText().isEmpty()) {
				showAlert(Alert.AlertType.ERROR, pane.getScene().getWindow(), "Form Error!",
						"Please enter your password");
				return;
			}
			if (email.getText().isEmpty() || !isValid(email.getText())) {
				showAlert(Alert.AlertType.ERROR, pane.getScene().getWindow(), "Form Error!", "Please enter your email");
				return;
			}
			if (phone.getText().isEmpty() || !isNumber(phone.getText())) {
				showAlert(Alert.AlertType.ERROR, pane.getScene().getWindow(), "Form Error!",
						"Please enter your phone number");
				return;
			}
			if (country.getText().isEmpty()) {
				showAlert(Alert.AlertType.ERROR, pane.getScene().getWindow(), "Form Error!",
						"Please enter your country");
				return;
			}

			showAlert(Alert.AlertType.CONFIRMATION, pane.getScene().getWindow(), "Registration Successful!",
					"Welcome " + username.getText());

		}
	}

	private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {

		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.initOwner(owner);
		alert.show();
	}

	// Verify email input
	public static boolean isValid(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}

	// Verify phone input
	public static boolean isNumber(String phone) {
		String PhoneRegex = "\\d+";

		Pattern pa = Pattern.compile(PhoneRegex);
		if (phone == null)
			return false;
		return pa.matcher(phone).matches();
	}
}
