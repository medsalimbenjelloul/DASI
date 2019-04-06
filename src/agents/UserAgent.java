package agents;

import java.util.ArrayList;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import core.Listener;
import jade.core.AID;
import jade.core.Agent;
import view.Window;

public class UserAgent extends Agent {
	private static final long serialVersionUID = -4477365032710457655L;

	private ArrayList<Listener> observers = null;
	private ArrayList<AID> aids = null;

	private Window mainWindow = null;

	public UserAgent() {
		this.observers = new ArrayList<>();
		this.aids = new ArrayList<>();
	}

	@Override
	protected void setup() {
		// TODO Behaviours for first actions of agent, before creating Window, e.g.
		// checking the connection between agents
		// addBehaviour()
		
		createGUI();
	}

	private void createGUI() {
		System.out.println("Building GUI...");
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		this.mainWindow = new Window(this);
		addObserver(mainWindow);
	}

	@Override
	protected void takeDown() {
		mainWindow.dispose();

		System.out.println("Closing GUI...");
	}

	public void addObserver(Listener observer) {
		if (!this.observers.contains(observer)) {
			this.observers.add(observer);
		}
	}

	public ArrayList<Listener> getObservers() {
		return observers;
	}

	public void addAID(AID aid) {
		if (!this.aids.contains(aid)) {
			this.aids.add(aid);
		}
	}

	public ArrayList<AID> getAIDs() {
		return aids;
	}

	public Window getMainWindow() {
		return mainWindow;
	}
}
