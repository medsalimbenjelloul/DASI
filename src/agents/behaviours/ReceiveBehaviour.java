package agents.behaviours;

import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class ReceiveBehaviour extends CyclicBehaviour {
	private static final long serialVersionUID = -9071206855216984983L;

	private ACLMessage message = null;

	@Override
	public void action() {
		message = getAgent().receive();

		if (message != null) {
			String content = message.getContent();

			myAgent.addBehaviour(new OneShotBehaviour() {
				private static final long serialVersionUID = 1L;

				@Override
				public void action() {
					System.out.println(content);
					
//					Rest.get("https://api.flightstats.com/flex/airlines/rest/v1/schema/json");
				}
			});
		}
	}

}
