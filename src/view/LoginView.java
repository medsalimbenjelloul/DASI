package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import view.actions.LoginAction;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.DropMode;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.KeyEvent;

import javax.swing.JButton;

public class LoginView extends JPanel {
	private static final long serialVersionUID = -4972101784603327025L;
	
	private JTextField usernameField;
	private JPasswordField passwordField;
	
	private Window parentWindow;
	
	public LoginView(Window window) {
		parentWindow = window;
		
//		Layout initialization
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {30};
		gridBagLayout.rowHeights = new int[] {30, 30, 20, 30, 30, 30, 30, 30};
		gridBagLayout.columnWeights = new double[]{0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		setLayout(gridBagLayout);
		setBackground(Color.WHITE);

//		Username label initialization
		JLabel usernameLabel = new JLabel("Username (or email)");
		usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		usernameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		usernameLabel.setBackground(Color.WHITE);
		usernameLabel.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		GridBagConstraints gbc_usernameLabel = new GridBagConstraints();
		gbc_usernameLabel.fill = GridBagConstraints.BOTH;
		gbc_usernameLabel.insets = new Insets(0, 0, 5, 0);
		gbc_usernameLabel.gridx = 0;
		gbc_usernameLabel.gridy = 0;
		add(usernameLabel, gbc_usernameLabel);

//		Username field initialization
		usernameField = new JTextField();
		usernameField.setToolTipText("Type username or email");
		usernameField.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
		usernameField.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_usernameField = new GridBagConstraints();
		gbc_usernameField.fill = GridBagConstraints.BOTH;
		gbc_usernameField.insets = new Insets(0, 0, 5, 0);
		gbc_usernameField.gridx = 0;
		gbc_usernameField.gridy = 1;
		add(usernameField, gbc_usernameField);
		usernameField.setColumns(10);

//		Password label initialization
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		passwordLabel.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLabel.setBackground(Color.WHITE);
		GridBagConstraints gbc_passwordLabel = new GridBagConstraints();
		gbc_passwordLabel.fill = GridBagConstraints.BOTH;
		gbc_passwordLabel.insets = new Insets(0, 0, 5, 0);
		gbc_passwordLabel.gridx = 0;
		gbc_passwordLabel.gridy = 3;
		add(passwordLabel, gbc_passwordLabel);

//		Password field initialization
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Type password");
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
		passwordField.setDropMode(DropMode.USE_SELECTION);
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.fill = GridBagConstraints.BOTH;
		gbc_passwordField.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField.gridx = 0;
		gbc_passwordField.gridy = 4;
		add(passwordField, gbc_passwordField);
		
		JButton loginButton = new JButton("LOGIN");
		loginButton.addActionListener(new LoginAction());
//		loginButton.setAction(new LoginAction());
		loginButton.setMnemonic(KeyEvent.VK_ENTER);
		loginButton.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		loginButton.setBackground(Color.WHITE);
		loginButton.setForeground(Color.BLACK);
		GridBagConstraints gbc_loginButton = new GridBagConstraints();
		gbc_loginButton.fill = GridBagConstraints.BOTH;
		gbc_loginButton.insets = new Insets(0, 0, 5, 0);
		gbc_loginButton.gridx = 0;
		gbc_loginButton.gridy = 6;
		add(loginButton, gbc_loginButton);
		
		JButton signupButton = new JButton("SIGN UP");
		signupButton.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		signupButton.setForeground(Color.DARK_GRAY);
		signupButton.setBackground(Color.WHITE);
		GridBagConstraints gbc_signupButton = new GridBagConstraints();
		gbc_signupButton.fill = GridBagConstraints.BOTH;
		gbc_signupButton.gridx = 0;
		gbc_signupButton.gridy = 7;
		add(signupButton, gbc_signupButton);
		
	}
	
	public Window getWindow() {
		return parentWindow;
	}
	
}
