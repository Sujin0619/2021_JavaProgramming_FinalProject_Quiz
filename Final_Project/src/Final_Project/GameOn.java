package Final_Project;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import java.awt.BorderLayout;

public class GameOn extends PageMoving implements ActionListener{

	private JFrame frmGameOn;
	private JTextField QuizNum;
	private JTextArea textArea;
	private JTextField FirstAnswer;
	private JTextField SecondAnswer;
	private JTextField ThirdAnswer;
	private JTextField FourthAnswer;
	private JButton NextButton;
	private JButton FirstButton;
	private JButton SecondButton;
	private JButton ThirdButton;
	private JButton FourthButton;
	private JTextArea textArea1;
	PageMoving pagemoving = new PageMoving();

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameOn window = new GameOn();
					window.frmGameOn.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the application.
	 */
	public GameOn() {
		initialize();
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		
		// Insert Image to Panel
		frmGameOn = new JFrame();
		frmGameOn.setTitle("Game On");
		frmGameOn.setBounds(100, 100, 450, 300);
		frmGameOn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImagePanel GameOnPanel = new ImagePanel(new ImageIcon("C:\\Users\\tnwls\\eclipse-workspace\\Final_Project\\On.png").getImage());
		//ImagePanel GameOnPanel = new ImagePanel(new ImageIcon(".\\On.png").getImage());
		
		frmGameOn.setSize(new Dimension());
		frmGameOn.setPreferredSize(GameOnPanel.getDim());
		frmGameOn.getContentPane().add(GameOnPanel, BorderLayout.WEST);
		// Fit the size of an image 
		frmGameOn.pack();
			
		
		// Textfield that shows quiz number
		QuizNum = new JTextField();
		QuizNum.setForeground(new Color(245, 245, 245));
		QuizNum.setHorizontalAlignment(SwingConstants.CENTER);
		QuizNum.setFont(new Font("210 ÇÏ¾áºÐÇÊ R", Font.BOLD, 35));
		QuizNum.setBounds(284, 32, 63, 43);
		QuizNum.setBackground(new Color(0x2cd5b5));
		QuizNum.setBorder(null);
		// Set the textfield
		int level = UserInfo.current_level+1;
		QuizNum.setText("0" + level);
		GameOnPanel.add(QuizNum);
		QuizNum.setColumns(10);
		
		
		// Textarea that shows question
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setFont(new Font("210 ÇÏ¾áºÐÇÊ R", Font.PLAIN, 20));
		textArea.setBounds(45, 99, 506, 123);
		GameOnPanel.add(textArea);
		textArea.setText(setQuiz(UserInfo.current_level));  // Set the question
		
		
		// Textarea that shows if it is correct answer 
		textArea1 = new JTextArea();
		textArea1.setFont(new Font("210 ÇÏ¾áºÐÇÊ R", Font.PLAIN, 18));
		textArea1.setBounds(404, 210, 164, 106);
		GameOnPanel.add(textArea1);
		
		
		// Button part
		FirstButton = new JButton("1");
		FirstButton.setFont(new Font("210 ÇÏ¾áºÐÇÊ R", Font.BOLD, 15));
		FirstButton.setBackground(new Color(0x7fffd4));
		FirstButton.setBounds(45, 258, 58, 43);
		GameOnPanel.add(FirstButton);
		
		SecondButton = new JButton("2");
		SecondButton.setFont(new Font("210 ÇÏ¾áºÐÇÊ R", Font.BOLD, 15));
		SecondButton.setBackground(new Color(0x7fffd4));
		SecondButton.setBounds(45, 320, 58, 43);
		GameOnPanel.add(SecondButton);
		
		ThirdButton = new JButton("3");
		ThirdButton.setFont(new Font("210 ÇÏ¾áºÐÇÊ R", Font.BOLD, 15));
		ThirdButton.setBackground(new Color(0x7fffd4));
		ThirdButton.setBounds(45, 384, 58, 43);
		GameOnPanel.add(ThirdButton);
		
		FourthButton = new JButton("4");
		FourthButton.setFont(new Font("210 ÇÏ¾áºÐÇÊ R", Font.BOLD, 15));
		FourthButton.setBackground(new Color(0x7fffd4));
		FourthButton.setBounds(45, 444, 58, 43);
		GameOnPanel.add(FourthButton);
		
		
		
		// Textfield that shows 1,2,3,4 Examples 
		FirstAnswer = new JTextField();
		FirstAnswer.setFont(new Font("210 ÇÏ¾áºÐÇÊ R", Font.PLAIN, 15));
		FirstAnswer.setBounds(114, 252, 331, 51);
		FirstAnswer.setBorder(null);
		GameOnPanel.add(FirstAnswer);
		FirstAnswer.setColumns(10);
		
		SecondAnswer = new JTextField();
		SecondAnswer.setFont(new Font("210 ÇÏ¾áºÐÇÊ R", Font.PLAIN, 15));
		SecondAnswer.setBounds(114, 313, 331, 61);
		SecondAnswer.setBorder(null);
		GameOnPanel.add(SecondAnswer);
		SecondAnswer.setColumns(10);
		
		ThirdAnswer = new JTextField();
		ThirdAnswer.setFont(new Font("210 ÇÏ¾áºÐÇÊ R", Font.PLAIN, 15));
		ThirdAnswer.setBounds(114, 376, 331, 58);
		ThirdAnswer.setBorder(null);
		GameOnPanel.add(ThirdAnswer);
		ThirdAnswer.setColumns(10);
		
		FourthAnswer = new JTextField();
		FourthAnswer.setFont(new Font("210 ÇÏ¾áºÐÇÊ R", Font.PLAIN, 15));
		FourthAnswer.setBounds(115, 443, 331, 43);
		FourthAnswer.setBorder(null);
		GameOnPanel.add(FourthAnswer);
		FourthAnswer.setColumns(10);
		
		SetExample();  // The function that sets the examples
		
		
		// Button that lets you move on to the next level
		NextButton = new JButton("");
		NextButton.setFont(new Font("Arial", Font.PLAIN, 12));
		NextButton.setBounds(341, 479, 164, 36);
		NextButton.setContentAreaFilled(false);
		NextButton.setBorder(null);
		GameOnPanel.add(NextButton);
		
		NextButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					if (UserInfo.current_level==10) {
						// If this is the last level
						frmGameOn.dispose();
						pagemoving.FinalPage();
					}
						
					else {
						textArea1.setVisible(false);
						textArea.setText(setQuiz(UserInfo.current_level));
						SetExample();
					}
					
					// Set the text
					int level = UserInfo.current_level+1;
					if (level==10)
						QuizNum.setText("10");
					else
						QuizNum.setText("0" + level);
					
					
					// Change the color of example and button to the black
					FirstAnswer.setForeground(Color.black);
					FirstButton.setForeground(Color.black);
					
					SecondAnswer.setForeground(Color.black);
					SecondButton.setForeground(Color.black);
					
					ThirdAnswer.setForeground(Color.black);
					ThirdButton.setForeground(Color.black);
					
					FourthAnswer.setForeground(Color.black);
					FourthButton.setForeground(Color.black);
			}
		});
		
		FirstButton.addActionListener((ActionListener) this);
		SecondButton.addActionListener((ActionListener) this);
		ThirdButton.addActionListener((ActionListener) this);
		FourthButton.addActionListener((ActionListener) this);
		
		
		textArea.setText(setQuiz(UserInfo.current_level));  // Set the next level question to the textarea
		SetExample();  // Set the next level example to the textfield		
		
	}
	
	
	// The function that sets the next level example to the text field
	void SetExample() {
		if (UserInfo.genre==0) {
			FirstAnswer.setText(Answer_Database.Movie_Database[UserInfo.current_level][0]);
			SecondAnswer.setText(Answer_Database.Movie_Database[UserInfo.current_level][1]);
			ThirdAnswer.setText(Answer_Database.Movie_Database[UserInfo.current_level][2]);
			FourthAnswer.setText(Answer_Database.Movie_Database[UserInfo.current_level][3]);
		}
			
		else if(UserInfo.genre==2) {
			FirstAnswer.setText(Answer_Database.CommonSense_Database[UserInfo.current_level][0]);
			SecondAnswer.setText(Answer_Database.CommonSense_Database[UserInfo.current_level][1]);
			ThirdAnswer.setText(Answer_Database.CommonSense_Database[UserInfo.current_level][2]);
			FourthAnswer.setText(Answer_Database.CommonSense_Database[UserInfo.current_level][3]);
		}
			
		else {
			FirstAnswer.setText(Answer_Database.Figure_Database[UserInfo.current_level][0]);
			SecondAnswer.setText(Answer_Database.Figure_Database[UserInfo.current_level][1]);
			ThirdAnswer.setText(Answer_Database.Figure_Database[UserInfo.current_level][2]);
			FourthAnswer.setText(Answer_Database.Figure_Database[UserInfo.current_level][3]);
		}	
	}
	
	
	// Extracting problems through txt files
	String setQuiz(int num) {
		String text = "";
		ArrayList<Character> a = new ArrayList<>();
		Character[] array;
		int g = UserInfo.genre;

		try {
			FileReader fr = new FileReader("quiz_" + g + "_" + num + ".txt");
			int ch;

			while ((ch = fr.read()) != -1) {
				a.add((char) (ch));
			}
		} catch (Exception e) {
			e.getStackTrace();
		}

		array = a.toArray(new Character[a.size()]);

		for (int i = 0; i < a.size(); i++) {
			text = text + array[i];
		}

		return text;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// 'b' is the button that user clicks
		JButton b = (JButton) e.getSource();
			
		
		// The number of 'b'
		int su = Integer.parseInt(b.getText().trim());
		
		
		// 'ans' is the answer of question
		int ans = 0;
		if (UserInfo.genre==0)
			ans = Integer.parseInt(Answer_Database.Movie_Database[UserInfo.current_level][4]);
		else if (UserInfo.genre==2)
			ans = Integer.parseInt(Answer_Database.CommonSense_Database[UserInfo.current_level][4]);
		else if (UserInfo.genre==3)
			ans = Integer.parseInt(Answer_Database.Figure_Database[UserInfo.current_level][4]);
		
		
		// Set the answer to the red
		if (ans == 1) {
			FirstAnswer.setForeground(Color.red);
			FirstButton.setForeground(Color.red);
		}
		else if (ans==2) {
			SecondAnswer.setForeground(Color.red);
			SecondButton.setForeground(Color.red);
		}	
		else if (ans==3) {
			ThirdAnswer.setForeground(Color.red);
			ThirdButton.setForeground(Color.red);
		}
		else {
			FourthAnswer.setForeground(Color.red);
			FourthButton.setForeground(Color.red);
		}
			
		
		// If user clicks the correct answer
		if (su==ans) {
			UserInfo.sum += 10;
			textArea1.setVisible(true);
			textArea1.setText("\nYou're Correct!" + "\n\n" + "Total Score : " + UserInfo.sum);
			UserInfo.score[UserInfo.current_level]=10;
			UserInfo.current_level += 1;
			
			// Write to the file
			FileOutputStream fileStream;
			try {
				fileStream = new FileOutputStream("Quiz.txt", true);
				PrintWriter writer = new PrintWriter(fileStream);
				writer.print(UserInfo.current_level + " level : " + "10" + "\n");
				writer.close();
				fileStream.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
		}
		
		// If user clicks the wrong anwer
		else {
			UserInfo.sum -= 10;
			textArea1.setVisible(true);
			textArea1.setText("\nYou're Wrong!" + "\n\n" + "Total Score : " + UserInfo.sum);
			UserInfo.score[UserInfo.current_level]=-10;
			UserInfo.current_level += 1;
			
			// Write to the file
			FileOutputStream fileStream;
			try {
				fileStream = new FileOutputStream("Quiz.txt", true);
				PrintWriter writer = new PrintWriter(fileStream);
				writer.print(UserInfo.current_level + " level : " + "-10" + "\n");
				writer.close();
				fileStream.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			if(UserInfo.sum<0) { 
				// If user's total score is negative, the game ends
				frmGameOn.dispose();
				pagemoving.GameEnd(); 
			}
				  
			
		}
		
		
		FileOutputStream fileStream;
		// If this is final level
		if (UserInfo.current_level==10)
			try {
				fileStream = new FileOutputStream("Quiz.txt", true);
				PrintWriter writer = new PrintWriter(fileStream);
				writer.print("Total Score : " + UserInfo.sum + "\n" + "----------------------------------------" + "\n");
				writer.close();
				fileStream.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}		
	}
	

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		// The function that shows this panel
		frmGameOn.setVisible(true);
		
	}
}
