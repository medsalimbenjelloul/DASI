package agents;

import jade.core.Agent;

public class ProfileAgent extends Agent {
	private static final long serialVersionUID = 4364179695237178397L;

	@Override
	protected void setup() {
		System.out.println("ProfileAgent.setup");
	}

	@Override
	protected void takeDown() {
		System.out.println("ProfileAgent.takeDown");
	}

}
