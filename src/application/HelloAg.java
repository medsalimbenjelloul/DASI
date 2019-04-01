package application;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import javafx.stage.Stage;

public class HelloAg extends Agent {
	private static final long serialVersionUID = 6204292838025790277L;

	@Override
	protected void setup() {
		System.out.println("hello");
		setEnabledO2ACommunication(true, 0);
	addBehaviour(new CyclicBehaviour(this) {
		private static final long serialVersionUID = 1931070331769839967L;

		@Override
		public void action() {
		    Object info =  myAgent.getO2AObject();
            if (info != null){
            	Stage primaryStage = null;
            	test s = new test();
            	try {
					s.tii(primaryStage);
				} catch (Exception e) {
					e.printStackTrace();
				}
           
            }else{
                block();
            }
		}
	});
		System.out.println("Hello" + getLocalName());

	} 
}
