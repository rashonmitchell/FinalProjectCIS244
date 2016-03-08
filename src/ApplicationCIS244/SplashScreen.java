package ApplicationCIS244;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.*;

public class SplashScreen extends JWindow {

    static boolean isRegistered;
    private static JProgressBar progressBar = new JProgressBar();
    private static SplashScreen execute;
    private static int count;
    private static Timer timer1;

    public SplashScreen() {

        Container container = getContentPane();
        container.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new javax.swing.border.EtchedBorder());
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(0, 0, 800, 566);
        panel.setLayout(null);
        container.add(panel);

        JLabel label = new JLabel("Final Project");
        label.setFont(new Font("Verdana", Font.BOLD, 14));
        label.setBounds(340, 300, 400, 30);
        panel.add(label);

        progressBar.setMaximum(100);
        progressBar.setBounds(0, 565, 799, 34);
        container.add(progressBar);
        loadProgressBar();
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void loadProgressBar() {
        ActionListener al = new ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                count++;

                progressBar.setValue(count);

                System.out.println(count);

                if (count == 100) {

                    createFrame();

                    execute.setVisible(false);//swapped this around with timer1.stop()

                    timer1.stop();
                }
            }

            private void createFrame() throws HeadlessException {
                JFrame frame = new JFrame("Main Menu");
                
                createMenuBar();
                frame.setSize(800, 600);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }

			private void createMenuBar() {
				final JMenuBar menubar = new JMenuBar();
				
				JMenu fileMenu = new JMenu("File");
				JMenu viewMenu = new JMenu("View");
				JMenu toolsMenu = new JMenu("Tools");
				JMenu readMenu = new JMenu("Read");
				JMenu helpMenu = new JMenu("Help");
				
				
				menubar.add(fileMenu);
				menubar.add(viewMenu);
				menubar.add(toolsMenu);
				menubar.add(readMenu);
				menubar.add(helpMenu);
				
				//setJMenuBar(menubar);
			}
        };
        timer1 = new Timer(50, al);
        timer1.start();
    }
    public static void main(String[] args) {
        execute = new SplashScreen();
    }
};

