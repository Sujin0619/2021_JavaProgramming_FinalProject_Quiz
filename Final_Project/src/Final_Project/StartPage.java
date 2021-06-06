package Final_Project;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;

public class StartPage extends PageMoving{

	private JFrame frmStartpage;
	private JTextField Username;
	private JComboBox Category;
	private JButton StartButton;
	PageMoving pagemoving = new PageMoving();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartPage window = new StartPage();
					window.frmStartpage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the application.
	 */
	public StartPage() {
		initialize();
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		// Insert Image to Panel 
		frmStartpage = new JFrame();
		frmStartpage.setTitle("Start Page");
		frmStartpage.setBounds(100, 100, 450, 300);
		frmStartpage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImagePanel startPanel = new ImagePanel(new ImageIcon(".\\Start.png").getImage());
		
		frmStartpage.setSize(startPanel.getDim());
		frmStartpage.setPreferredSize(startPanel.getDim());
		frmStartpage.getContentPane().add(startPanel);
		// Fit the size of an image
		frmStartpage.pack(); 
				
		
		// Textfield that receives a username
		Username = new JTextField();
		Username.setFont(new Font("210 ÇÏ¾áºÐÇÊ R", Font.PLAIN, 20));
		Username.setBounds(276, 249, 201, 43);
		startPanel.add(Username);
		Username.setColumns(10);
		
		
		// Combobox that receives a category
		Category = new JComboBox();
		Category.setFont(new Font("210 ÇÏ¾áºÐÇÊ R", Font.PLAIN, 20));
		Category.setBounds(276, 320, 201, 43);
		startPanel.add(Category);
		Category.setModel(new DefaultComboBoxModel(new String[] {"Movie", "CommonSense", "KoreanFigure"}));
		Category.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// If user selects category
				String category = Category.getSelectedItem().toString(); 
				UserInfo.category = category;
			}
		});
		
		
		// startbutton part
		StartButton = new JButton("");
		StartButton.setBounds(124, 415, 344, 69);
		startPanel.add(StartButton);
		StartButton.setContentAreaFilled(false);  // transparent button
		StartButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) throws NullPointerException{
				// TODO Auto-generated method stub
				try {
					// if username is null
					if (Username.getText().equals(""))
						name_popup();
					else {
						UserInfo.username = Username.getText();
						
						// Write to the file
						FileOutputStream fileStream = new FileOutputStream("Quiz.txt", true);
						PrintWriter writer = new PrintWriter(fileStream);
						writer.print("Username : " + UserInfo.username + "\n");
						writer.print("Category : " + UserInfo.category + "\n");
						writer.close();
						fileStream.close();
						
						if (UserInfo.category.equals("Movie")) {
							frmStartpage.dispose();
							UserInfo.genre = 0;
							pagemoving.GameOn();
						
						}
						
						else if(UserInfo.category.equals("CommonSense")) {
							frmStartpage.dispose();
							UserInfo.genre = 2;
							pagemoving.GameOn();
						}
						
						else {
							frmStartpage.dispose();
							UserInfo.genre = 3;
							pagemoving.GameOn();
						}
					}
				
				}
				
				catch (NullPointerException e1) {
					// if user don't select the category
					category_popup();
					
				}
				
				catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			private void category_popup() {
				// Pop-up window that pops up when no category is selected
				JOptionPane.showMessageDialog(null, "Please click your categry!", "Error Message", frmStartpage.EXIT_ON_CLOSE);
			}
		});
	}
	
	private void name_popup() {  
		// Pop-up window that pops up when no username is entered
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "Please enter your name!", "Error Message", frmStartpage.EXIT_ON_CLOSE);
		
	}


	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		// The function that shows this panel
		frmStartpage.setVisible(true);
	}
}
