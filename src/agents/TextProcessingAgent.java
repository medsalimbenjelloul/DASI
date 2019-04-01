package agents;

import jade.core.Agent;

public class TextProcessingAgent extends Agent {
	private static final long serialVersionUID = 7927331478692585274L;

	@Override
	protected void setup() {
		System.out.println("TextProcessingAgent.setup");
	}

	@Override
	protected void takeDown() {
		System.out.println("TextProcessingAgent.takeDown");
	}
	
}
