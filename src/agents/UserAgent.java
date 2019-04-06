package agents;

import java.util.ArrayList;

import core.Listener;
import jade.core.AID;
import jade.core.Agent;
import view.Window;

public class UserAgent extends Agent {
	private static final long serialVersionUID = -4477365032710457655L;
	
	private ArrayList<Listener> observers = null;
	private ArrayList<AID> aids = null;
	
	private Window gui = null;
	
	public UserAgent() {
		this.observers = new ArrayList<>();
		this.aids = new ArrayList<>();
	}

	@Override
	protected void setup() {
		System.out.println("UserAgent.setup");
		
//		addBehaviour(new Behaviour());
		
		gui = new Window(this);
		addObserver(gui);
	}

	@Override
	protected void takeDown() {
		System.out.println("UserAgent.takeDown");
	}
	
	public void addObserver(Listener observer) {
		if (!observers.contains(observer)) {
			this.observers.add(observer);
		}
	}
	
	public ArrayList<Listener> getObservers() {
		return this.observers;
	}
	
	public void addAID(AID aid) {
		if (!aids.contains(aid)) {
			this.aids.add(aid);
		}
	}
	
	public ArrayList<AID> getAIDs() {
		return this.aids;
	}

}
