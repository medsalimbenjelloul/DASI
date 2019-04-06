package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class ChatView extends JPanel {
	private static final long serialVersionUID = -9208148801434136681L;

	private static final Font FONT = new Font("", Font.LAYOUT_LEFT_TO_RIGHT, 12);

	private JPanel mainPanel = null;
	private static JPanel conversationPanel = null;
	private static JPanel inputPanel = null;

	private static JTextArea conversationArea = null;
	private static JTextField messageField = null;

	private static JTextField inputField = null;
	private static JButton sendButton = null;

	public ChatView() {
		this.mainPanel = new JPanel();
		this.mainPanel.add(initConversationPanel(), BorderLayout.NORTH);
		this.mainPanel.add(initInputPanel(), BorderLayout.SOUTH);

		this.setBorder(UIManager.getBorder("TitledBorder.border"));
		this.setLayout(new BorderLayout());
		this.setBackground(Color.LIGHT_GRAY);
		this.add(mainPanel);
	}

	private JPanel initConversationPanel() {
		conversationArea = new JTextArea();
		
		GridBagConstraints right = new GridBagConstraints();
		right.anchor = GridBagConstraints.EAST;
		GridBagConstraints left = new GridBagConstraints();
		left.anchor = GridBagConstraints.WEST;
		
		messageField = new JTextField();
		
		
		conversationPanel = new JPanel();
		conversationPanel.setLayout(new GridBagLayout());
		conversationPanel.add(conversationArea, BorderLayout.NORTH);
		conversationPanel.add(messageField, BorderLayout.SOUTH);
		
		return conversationPanel;
	}

	private JPanel initInputPanel() {
		inputPanel = new JPanel();

		return inputPanel;
	}
}
