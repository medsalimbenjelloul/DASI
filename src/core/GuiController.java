package core;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import agents.TextProcessingAgent;

public class GuiController extends JFrame {
	private static final long serialVersionUID = 1756788553851155902L;

	final static String WINDOW_TITLE = "Main Window of ";
	final static int SIZE_WIDTH = 300;
	final static int SIZE_HEIGHT = 300;

	private JPanel mainPanel = null;
	private JPanel subPanel = null;
	private JTextField msg = null;

	private TextProcessingAgent textProcessingAgent = null;

	public GuiController(TextProcessingAgent textProcessingAgent) {
		this.textProcessingAgent = textProcessingAgent;

		initUI();
		createLayout();
		
		System.out.println("GuiController");
	}

	private void initUI() {
		setTitle(WINDOW_TITLE + textProcessingAgent.getName());
		setSize(SIZE_WIDTH, SIZE_HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void createLayout() {
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
		mainPanel.setLayout(new BorderLayout(10, 10));
		getContentPane().add(mainPanel);

		subPanel = new JPanel();
		mainPanel.add(subPanel, BorderLayout.WEST);
		subPanel.setLayout(new BorderLayout(0, 16));

		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout(0, 0));
		pane.add(new JLabel("Message"), BorderLayout.NORTH);
		pane.add(msg = new JTextField("Select an action", 15));
		msg.setEditable(false);
		msg.setBackground(Color.black);
		msg.setForeground(Color.white);
		msg.setFont(new Font("Arial", Font.BOLD, 12));
		msg.setHorizontalAlignment(JTextField.CENTER);

		subPanel.add(pane, BorderLayout.NORTH);
		pane = new JPanel();
		pane.setLayout(new BorderLayout(5, 0));
	}

}
