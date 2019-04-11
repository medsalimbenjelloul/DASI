package view;

import javax.swing.JFrame;
import jade.core.Agent;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;

public class Window extends JFrame {
	private static final long serialVersionUID = 2421674596716583817L;
	
	private static final int WINDOW_WIDTH = 640;
	private static final int WINDOW_HEIGHT = 480;
	
	private Agent agent = null;
	
	public Window(Agent agent) {
		super();
		
		this.getContentPane().setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		this.getContentPane().setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0};
		gridBagLayout.rowHeights = new int[]{0};
		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		this.getContentPane().setLayout(gridBagLayout);
		
		this.setTitle("VirtualVuelos");
		this.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		this.setForeground(Color.WHITE);
		this.setBackground(Color.WHITE);
		this.setBounds(100, 100, WINDOW_WIDTH, WINDOW_HEIGHT);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setVisible(true);
	}

	public void setView(String panelName) {
		this.setVisible(false);
		this.getContentPane().removeAll();
		
		if (panelName.equals("LoginView")) {
			this.getContentPane().add(new LoginView(this));
		} else if (panelName.equals("ChatView")) {
			this.getContentPane().add(new ChatView(this));
		}

		this.setVisible(true);
	}
	
}
