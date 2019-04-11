package agents;

import agents.behaviours.ReceiveBehaviour;
import core.TextProcessing;
import jade.core.Agent;

public class TextProcessingAgent extends Agent {
	private static final long serialVersionUID = 7927331478692585274L;

	private TextProcessing processing = null;
	
	@Override
	protected void setup() {
		System.out.println("TextProcessingAgent.setup");
		
		processing = TextProcessing("C:\\hlocal\\workspace-4.7-64bits\\DASI\\lib\\gate-developer-8.5.1");
		
		addBehaviour(new ReceiveBehaviour());
	}

	@Override
	protected void takeDown() {
		System.out.println("TextProcessingAgent.takeDown");
	}
	
}
