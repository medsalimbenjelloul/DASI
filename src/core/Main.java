package core;

import agents.TextProcessingAgent;
import agents.UserAgent;

public class Main {

	public static void main(String[] args) {
		UserContainer userContainer = new UserContainer();

		userContainer.run(args);
		try {
// 			Initialization of all main agents
			userContainer.addAgent("TextProcessing", TextProcessingAgent.class.getName());

// 			Initialization of user/server agent
			userContainer.addAgent("UserAgent", UserAgent.class.getName());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//			userContainer.kill();
		}
	}

}
