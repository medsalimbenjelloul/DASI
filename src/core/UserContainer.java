package core;

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
	
	public AgentController addAgent(String name, String className, Object[] objs) throws StaleProxyException {
		AgentController agent = mainContainer.createNewAgent(name, className, objs);
		agent.start();
		
		return agent;
	}
	
	public AgentController addAgent(String name, String className) throws StaleProxyException {
		AgentController agent = mainContainer.createNewAgent(name, className, new Object[0]);
		agent.start();
		
		return agent;
	}

	public void kill() {
		try {
			mainContainer.kill();
		} catch (StaleProxyException e) {
			e.printStackTrace();
		}
	}
	
}
