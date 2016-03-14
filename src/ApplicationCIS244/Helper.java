package ApplicationCIS244;

import java.awt.Color;

import javax.swing.JOptionPane;

public class Helper {

	public static Color getTeal(){
		return new Color(26, 177, 136);
	}
	
	public static void displayMessage(String msg){
		JOptionPane.showMessageDialog(null, msg);
	}
	
	public static void displayErrorMessage(String msg){
		JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public static int isLoginValid(String email, char[] password){
		//TODO: work with database
		
		//return LoginWindow.UNAUTHENTICATEDUSER;
		return LoginWindow.REGULARUSER;
	}
}
