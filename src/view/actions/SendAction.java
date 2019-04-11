package view.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import view.ChatView;

public class SendAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton)e.getSource();
		ChatView view = (ChatView)source.getParent();
		
		String content = ((JTextField)view.getComponent(1)).getText();
		
		if (content != null && !content.isEmpty()) {
			System.out.println(content);
		}
	}

}
