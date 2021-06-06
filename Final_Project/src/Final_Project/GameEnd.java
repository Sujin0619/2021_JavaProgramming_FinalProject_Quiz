package Final_Project;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;

public class GameEnd extends PageMoving{

	private JFrame frmGameEnd;
	private JButton StartButton;
	private JButton ExitButton;
	PageMoving pagemoving = new PageMoving();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameEnd window = new GameEnd();
					window.frmGameEnd.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the application.
	 */
	public GameEnd() {
		initialize();
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		// Insert Image to Panel 
		frmGameEnd = new JFrame();
		frmGameEnd.setTitle("Game End");
		frmGameEnd.setBounds(100, 100, 450, 300);
		frmGameEnd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImagePanel GameEndPanel = new ImagePanel(new ImageIcon(".\\End.png").getImage());
		
		frmGameEnd.setSize(new Dimension());
		frmGameEnd.setPreferredSize(GameEndPanel.getDim());
		frmGameEnd.getContentPane().add(GameEndPanel);
		// Fit the size of an image
		frmGameEnd.pack();
		
		
		// StartButton Part
		StartButton = new JButton("");
		StartButton.setBounds(77, 421, 173, 46);
		StartButton.setContentAreaFilled(false);
		StartButton.setBorderPainted(false);
		GameEndPanel.add(StartButton);
		StartButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Move to startpage
				frmGameEnd.dispose();
				pagemoving.StartPage();
			}
		});
		
		
		// ExitButton Part
		ExitButton = new JButton("");
		ExitButton.setBounds(325, 421, 173, 46);
		ExitButton.setContentAreaFilled(false);
		ExitButton.setBorderPainted(false);
		GameEndPanel.add(ExitButton);
		ExitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// The game ends
				frmGameEnd.dispose();
			}
		});
		
		
		// Write to file
		FileOutputStream fileStream;
		try {
			fileStream = new FileOutputStream("Quiz.txt", true);
			PrintWriter writer = new PrintWriter(fileStream);
			writer.print("You are Dead!" + "\n" + "----------------------------------------" + "\n");
			writer.close();
			fileStream.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		// Initiallizing user information
		UserInfo.current_level=0;
		UserInfo.sum=0;
		for (int i=0; i<10; i++)
			UserInfo.score[i]=0;
	}

	
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		// The function that shows this panel
		frmGameEnd.setVisible(true);
		
	}

}
