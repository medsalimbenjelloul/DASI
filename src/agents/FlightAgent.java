package agents;

import agents.behaviours.FlightBehaviour;
import agents.behaviours.ReceiveBehaviour;
import jade.core.Agent;

public class FlightAgent extends Agent {
	private static final long serialVersionUID = 8910303998626126172L;

	@Override
	protected void setup() {
		System.out.println("FlightAgent.setup");
		
		addBehaviour(new ReceiveBehaviour());
//		addBehaviour(new FlightBehaviour());
	}

	@Override
	protected void takeDown() {
		System.out.println("FlightAgent.takeDown");
	}

}
