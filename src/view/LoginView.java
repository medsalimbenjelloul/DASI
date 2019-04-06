package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class LoginView extends JPanel {
	private static final long serialVersionUID = -4972101784603327025L;

	private static final Font FONT = new Font("", Font.CENTER_BASELINE, 14);
	
	private JPanel mainPanel = null;
	
	private static JPanel loginPanel = null;
//	private static JPanel signupPanel = null;
	private static JTextField nameField = null;
	private static JPasswordField pswdField = null;
	private static JButton loginButton = null;
	
	public LoginView() {
		LoginView.loginPanel = new JPanel();
		
		LoginView.loginPanel.add(UsernameField());
		LoginView.loginPanel.add(PasswordField());
		LoginView.loginPanel.add(LoginButton());

		this.mainPanel = new JPanel();
		this.mainPanel.add(loginPanel, BorderLayout.SOUTH);
		
		this.setBorder(UIManager.getBorder("TitledBorder.border"));
		this.setLayout(new BorderLayout(0, 0));
		this.setBackground(Color.LIGHT_GRAY);
		this.add(mainPanel);
	}

	private static JTextField UsernameField() {
		nameField = new JTextField();

		nameField.setText("Username");
		nameField.setToolTipText("Username");
		nameField.setFont(FONT);
		nameField.setBackground(Color.WHITE);
		
		nameField.setColumns(15);
		
		return nameField;
	}

	private static JPasswordField PasswordField() {
		pswdField = new JPasswordField();

		pswdField.setText("Password");
		pswdField.setToolTipText("Password");
		pswdField.setFont(FONT);
		pswdField.setBackground(Color.WHITE);
		
		pswdField.setColumns(15);
		
		return pswdField;
	}

	private static JButton LoginButton() {
		loginButton = new JButton("Send");
		
		loginButton.setToolTipText("Click to login");
		loginButton.setHorizontalAlignment(AbstractButton.RIGHT);
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!nameField.getText().isEmpty() && pswdField.getPassword().length != 0) {
					System.out.println("qwerty");
				}
			}
		});
		
		return loginButton;
	}
	
}
