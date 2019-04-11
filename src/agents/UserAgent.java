package agents;

import java.awt.EventQueue;
import java.util.ArrayList;

import agents.behaviours.SendBehaviour;
import core.Listener;
import jade.core.AID;
import jade.core.Agent;
import view.Window;

public class UserAgent extends Agent {
	private static final long serialVersionUID = -4477365032710457655L;

	private ArrayList<Listener> observers = null;
	private ArrayList<AID> aids = null;

	private Window window = null;

	public UserAgent() {
		this.observers = new ArrayList<>();
		this.aids = new ArrayList<>();
		
		this.window = new Window(this);
	}

	@Override
	protected void setup() {
		createGUI();
	}

	private void createGUI() {
		System.out.println("Building GUI...");
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window.setView("LoginView");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	protected void takeDown() {
		window.dispose();

		System.out.println("Closing GUI...");
	}
	
	public void sendMessage(String receiver, String content) {
//		addBehaviour(new SendBehaviour(receiver, content));
		
		addBehaviour(new SendBehaviour(FlightAgent.class.getSimpleName(), "Madrid"));
	}
	
}
