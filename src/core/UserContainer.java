package core;

import jade.core.Agent;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;

public class UserContainer {
	jade.core.Runtime runtime = null;

	static ProfileImpl profile = null;
	static AgentContainer mainContainer = null;

	private void init(String[] args) {
		runtime = jade.core.Runtime.instance();

		profile = new ProfileImpl(false);
		profile.setParameter(Profile.MAIN_HOST, "localhost");
	}

	public void run(String[] args) {
		init(args);
		
		mainContainer = runtime.createMainContainer(profile);
	}
	
	public AgentController addAgent(Agent agent) throws StaleProxyException {
		AgentController controller = mainContainer.acceptNewAgent(agent.getAID().getName(), agent);
		return controller;
	}
	
	public AgentController addAgent(String name, String className, Object[] args) throws StaleProxyException {
		AgentController controller = mainContainer.createNewAgent(name, className, args);
		controller.start();
		
		return controller;
	}

}
