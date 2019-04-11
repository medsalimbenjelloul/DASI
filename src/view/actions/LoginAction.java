package view.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import view.LoginView;
import view.Window;

public class LoginAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton)e.getSource();
		LoginView view = (LoginView)source.getParent();
		Window window = (Window)view.getParent().getParent().getParent().getParent();	// Przebicie siê przez wszystkie warstwy

		window.setView("ChatView");
	}

}
