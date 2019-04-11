package agents.behaviours;

import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class SendBehaviour extends OneShotBehaviour {
	private static final long serialVersionUID = -8311112726407849971L;

	private ACLMessage message = null;
	
	private String receiver = null;
	private String content = null;
	
	public SendBehaviour(String receiver, String content) {
		this.receiver = receiver;
		this.content = content;
	}
	
	@Override
	public void action() {
		message = new ACLMessage(ACLMessage.INFORM);
		message.addReceiver(new AID(receiver, AID.ISLOCALNAME));
		message.setContent(content);
		
		getAgent().send(message);
	}

}
