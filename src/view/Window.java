package view;

import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import core.Listener;
import jade.core.Agent;

public class Window extends JFrame implements Listener {
	private static final long serialVersionUID = 3172688540921699213L;

	private static final int WINDOW_WIDTH = 640;
	private static final int WINDOW_HEIGHT = 480;
	
	private Agent agent = null;
	private JPanel pane = null;

	public Window(Agent agent) {
		this.agent = agent;

		this.pane = new LoginView();

		initFrame();
		this.add(pane);
//		initPane();
		initListeners();
		
		this.setVisible(true);
	}

	private void initFrame() {
//		Window initialization
		this.setResizable(true);
		this.setSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		this.setTitle(agent.getLocalName());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void initListeners() {
//		Listeners initialization
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				agent.doDelete();
			}

		});

		addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyReleased(e);
			}

		});
	}

	@Override
	public void repaint() {
//		Repaint all components in the window, update to the new state

//		Repaint whole window
		super.repaint();
	}

	@Override
	public void dispose() {
		System.out.println("Closing GUI...");
		System.exit(0);
	}

	@Override
	public void onWindowLoad() {
		// TODO Auto-generated method stub
	}

	@Override
	public void onAgentInitialized() {
		repaint();
	}
	
	public Agent getUserAgent() {
		return agent;
	}

}
