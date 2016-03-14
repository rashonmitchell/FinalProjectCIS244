package ApplicationCIS244;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import java.awt.Cursor;

@SuppressWarnings("serial")
public class SplashScreen extends JFrame {

	private static final int SPEED = 50;
	private JProgressBar progressBar = new JProgressBar();
	private int count = 1;

	public SplashScreen() {
		setUndecorated(true);
		setType(Type.POPUP);
		setResizable(false);

		Container container = getContentPane();
		container.setLayout(null);

		JPanel panel = new JPanel();
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		panel.setBorder(new javax.swing.border.EtchedBorder());
		panel.setBackground(new Color(19, 35, 47));
		panel.setBounds(0, 0, 800, 566);
		panel.setLayout(null);
		container.add(panel);

		JLabel lblFinalProject = new JLabel("Final Project - Group 2");
		lblFinalProject.setHorizontalAlignment(SwingConstants.CENTER);
		lblFinalProject.setFont(new Font("Verdana", Font.BOLD, 32));
		lblFinalProject.setForeground(Color.WHITE);
		lblFinalProject.setBounds(199, 300, 531, 55);
		panel.add(lblFinalProject);
		progressBar.setBounds(-1, 566, 801, 34);
		getContentPane().add(progressBar);

		progressBar.setMaximum(100);
		progressBar.setForeground(Helper.getTeal());

		setSize(800, 600);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void loadProgressBar() {
		Timer timer = new Timer(SPEED, new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				count = count + (count % 10);
				progressBar.setValue(count);
				//System.out.println(count);

				if (count >= 100) {
					//loadMainApp();
					loadLoginGUI();

					Timer t = (Timer) evt.getSource();

					t.stop();

					return;
				}
			}
		});

		timer.start();
	}
	private void loadMainApp(LoginWindow lw) {
		this.setVisible(false); // hide itself which is the SplashScreen window
		MainApp mainApp = new MainApp();
		mainApp.setVisible(true);
		mainApp.setTitle("Welcome " + lw.getUserEmail());

	}
	private void loadLoginGUI() {
		this.setVisible(false); // hide itself which is the SplashScreen window
		final LoginWindow lw = new LoginWindow();
		lw.setActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//make sure you are here because of user logged in successfully
				//Helper.displayMessage("Logged in as: " + lw.getUserRole());
				loadMainApp(lw);
			}
		});
		lw.setVisible(true);

	}

	public static void main(String[] args) {
		SplashScreen ss = new SplashScreen();
		ss.loadProgressBar();

	}
}
