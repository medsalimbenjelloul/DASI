package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import jade.wrapper.StaleProxyException;

public class MenuBar extends JMenuBar {
	private static final long serialVersionUID = -111659266189879540L;

	private Window parent = null;
	
	private JMenu mainMenu;
	private JMenuItem item1, item2, item3, closeBtn;

	public MenuBar(Window window) {
		this.parent = window;
		
		init();
	}

	private void init() {
		mainMenu = new JMenu("Menu");
		
		item1 = new JMenuItem("item1");
		item1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("item1");
				
				try {
					parent.getUserAgent().getContainerController().kill();
				} catch (StaleProxyException ex) {
					ex.printStackTrace();
				}
			}
		});
		mainMenu.add(item1);
		
		item2 = new JMenuItem("item2");
		item2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("item2");
			}
		});
		mainMenu.add(item2);
		
		item3 = new JMenuItem("item3");
		item3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("item3");
			}
		});
		mainMenu.add(item3);
		
		closeBtn = new JMenuItem("closeBtn");
		closeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("closeBtn");
				System.exit(0);
			}
		});
		mainMenu.add(closeBtn);
		
		this.add(mainMenu);
	}
}
