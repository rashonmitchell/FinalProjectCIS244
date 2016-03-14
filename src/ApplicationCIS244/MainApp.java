package ApplicationCIS244;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class MainApp extends JFrame {

	public MainApp() {
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setMenu();
	}

	public void setMenu() {
		JMenuBar menuBar = new JMenuBar();

		JMenu fileMenu = new JMenu("File");

		JMenuItem openMenuItem = new JMenuItem("Open");
		fileMenu.add(openMenuItem);
		
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (JOptionPane.showConfirmDialog(null,
						"Are you sure you want to exit the application?",
						"Please confirm", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					System.exit(0);
				}

			}
		});

		fileMenu.add(exitMenuItem);

		menuBar.add(fileMenu);
		
		JMenu helpMenu = new JMenu("Help");
		JMenuItem supportMenuItem = new JMenuItem("Support");
		supportMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		helpMenu.add(supportMenuItem);
		
		JMenuItem aboutMenuItem = new JMenuItem("About");
		aboutMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, 
						"Built by CIS244 Spring 2016 - Group 2\nVersion 1.1.2","About", JOptionPane.INFORMATION_MESSAGE );
				
			}
		});
		helpMenu.add(aboutMenuItem);
		
		
		menuBar.add(helpMenu);

		this.setJMenuBar(menuBar);
	}

}
