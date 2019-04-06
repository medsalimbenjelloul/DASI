package agents;

import jade.core.Agent;

public class FlightAgent extends Agent {
	private static final long serialVersionUID = 8910303998626126172L;

	@Override
	protected void setup() {
		System.out.println("FlightAgent.setup");
	}

	@Override
	protected void takeDown() {
		System.out.println("FlightAgent.takeDown");
	}

}
