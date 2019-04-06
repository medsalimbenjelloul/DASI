package agents;

import jade.core.Agent;

public class BookingAgent extends Agent {
	private static final long serialVersionUID = -133429524377467791L;

	@Override
	protected void setup() {
		System.out.println("BookingAgent.setup");
	}

	@Override
	protected void takeDown() {
		System.out.println("BookingAgent.takeDown");
	}

}
