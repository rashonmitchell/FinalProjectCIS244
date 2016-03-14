package ApplicationCIS244;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;

@SuppressWarnings("serial")
public class LoginWindow extends JFrame {

	public static final int UNAUTHENTICATEDUSER = -1;
	public static final int REGULARUSER = 1;
	public static final int TRAINUSER = 2;
	public static final int SUPPORTUSER = 3;
	public static final int ADMINUSER = 4;
	public static final int LOGINATTEMPS = 5;
	private String userEmail;
	private int userRole;
	private int numOfAttempt = 0;
	private Date lastAttempt;

	private JTextField textFieldEmail;
	private JPasswordField textFieldPassword;
	private JButton btnUserLogin;
	private JButton btnSignup;
	private JButton btnLogIn;
	private ActionListener callListener;
	private JButton btnUserSignup;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow frame = new LoginWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginWindow() {
		setUndecorated(true);
		setType(Type.POPUP);
		setResizable(false);
		getContentPane().setBackground(Color.DARK_GRAY);
		getContentPane().setLayout(null);

		btnSignup = new JButton("Sign Up");
		btnSignup.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSignup.setBackground(Helper.getTeal());
		btnSignup.setForeground(Color.WHITE);
		btnSignup.setBounds(161, 31, 144, 23);
		getContentPane().add(btnSignup);

		btnLogIn = new JButton("Log In");
		btnLogIn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLogIn.setBackground(Helper.getTeal());
		btnLogIn.setForeground(Color.WHITE);
		btnLogIn.setBounds(306, 31, 144, 23);
		getContentPane().add(btnLogIn);

		JLabel lblNewLabel = new JLabel("Welcome Back!");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(161, 65, 289, 31);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Email Address");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(171, 107, 87, 23);
		getContentPane().add(lblNewLabel_1);

		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldEmail.setBounds(268, 108, 182, 20);
		getContentPane().add(textFieldEmail);
		textFieldEmail.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(171, 141, 87, 23);
		getContentPane().add(lblPassword);

		textFieldPassword = new JPasswordField();
		textFieldPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(268, 142, 182, 20);
		getContentPane().add(textFieldPassword);

		btnUserLogin = new JButton("LOG IN");
		btnUserLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				loginProcess(ae);
			}
		});
		btnUserLogin.setBackground(Helper.getTeal());
		btnUserLogin.setForeground(Color.WHITE);
		btnUserLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUserLogin.setBounds(161, 198, 289, 31);
		getContentPane().add(btnUserLogin);
		
		btnUserSignup = new JButton("Sign Up");
		btnUserSignup.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				final JTextField txtFirstName = new JTextField();
				final JTextField txtLastName = new JTextField();
				final JTextField txtEmail = new JTextField();
				final JTextField txtPasswordName = new JTextField();
				
				JComponent []components = new JComponent[]{
					new JLabel("First Name: "),
					txtFirstName,
					new JLabel("Last Name: "),
					txtLastName,
					new JLabel("Email: "),
					txtEmail,
					new JLabel("Password: "),
					txtPasswordName
				};
				

				JOptionPane.showInputDialog(null, components);
				
				Helper.displayMessage(txtFirstName.getText());
			}
		});
		btnUserSignup.setBackground(Color.DARK_GRAY);
		btnUserSignup.setForeground(Color.WHITE);
		btnUserSignup.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUserSignup.setBounds(49, 266, 89, 23);
		getContentPane().add(btnUserSignup);

		setSize(600, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	void loginProcess(ActionEvent ae) {

		String email = this.textFieldEmail.getText();
		char[] password = this.textFieldPassword.getPassword();
		if (email.isEmpty()) {
			Helper.displayErrorMessage("Email is required.");
		} else if (password.length < 1) {
			Helper.displayErrorMessage("Password is required.");
		} else {
			int loginRole = Helper.isLoginValid(email, password);
			if (loginRole == UNAUTHENTICATEDUSER) {
				this.numOfAttempt++;
				if (this.numOfAttempt >= LOGINATTEMPS) {
					this.lastAttempt = new Date();
					this.numOfAttempt = 0;
				}
			} else {
				this.userEmail = email;
				this.userRole = loginRole;
				this.numOfAttempt = 0;
				this.setVisible(false); //hide this frame now
				if(this.callListener != null){
					this.callListener.actionPerformed(ae);
				}
			}
			resetFields();
		}

	}

	public String getUserEmail() {
		return userEmail;
	}

	public int getUserRole() {
		return userRole;
	}

	Date getLastAttempt() {
		return lastAttempt;
	}

	void resetFields() {
		this.textFieldEmail.setText("");
		this.textFieldPassword.setText("");
	}
	
	
	public void setActionListener(ActionListener al){
		this.callListener = al;
	}
}
