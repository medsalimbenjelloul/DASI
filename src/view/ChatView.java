package view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import view.actions.SendAction;

public class ChatView extends JPanel {
	private static final long serialVersionUID = -9208148801434136681L;

	private Window parentWindow;
	private JTextField requestText;

	public ChatView(Window window) {
		setBackground(Color.WHITE);
		setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {62, 62, 62, 62, 62, 62, 62, 62, 62, 62};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		setLayout(gridBagLayout);
		
		JScrollPane conversationArea = new JScrollPane();
		conversationArea.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_conversationArea = new GridBagConstraints();
		gbc_conversationArea.fill = GridBagConstraints.BOTH;
		gbc_conversationArea.gridheight = 9;
		gbc_conversationArea.gridwidth = 10;
		gbc_conversationArea.gridx = 0;
		gbc_conversationArea.gridy = 0;
		add(conversationArea, gbc_conversationArea);
		
		requestText = new JTextField();
		requestText.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		GridBagConstraints gbc_requestText = new GridBagConstraints();
		gbc_requestText.gridwidth = 9;
		gbc_requestText.fill = GridBagConstraints.BOTH;
		gbc_requestText.gridx = 0;
		gbc_requestText.gridy = 9;
		add(requestText, gbc_requestText);
		requestText.setColumns(10);
		
		JButton sendButton = new JButton("SEND");
		sendButton.addActionListener(new SendAction());
		sendButton.setBackground(Color.WHITE);
		sendButton.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 11));
		GridBagConstraints gbc_sendButton = new GridBagConstraints();
		gbc_sendButton.fill = GridBagConstraints.BOTH;
		gbc_sendButton.gridx = 9;
		gbc_sendButton.gridy = 9;
		add(sendButton, gbc_sendButton);
		parentWindow = window;
		
	}

	public Window getWindow() {
		return parentWindow;
	}
	
}
