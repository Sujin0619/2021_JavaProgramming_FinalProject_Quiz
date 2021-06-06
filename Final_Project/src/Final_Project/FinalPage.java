package Final_Project;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;


import java.awt.Font;

public class FinalPage extends PageMoving{

	private JFrame frmFinalPage;
	private JButton StartButton;
	private JButton ExitButton;
	private JButton ScoreButton;
	private JTextArea textArea;
	private JTextField TotalScore;
	PageMoving pagemoving = new PageMoving();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinalPage window = new FinalPage();
					window.frmFinalPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the application.
	 */
	public FinalPage() {
		initialize();
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		// Insert Image to Panel 
		frmFinalPage = new JFrame();
		frmFinalPage.setTitle("Final Page");
		frmFinalPage.setBounds(100, 100, 450, 300);
		frmFinalPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImagePanel FinalPanel = new ImagePanel(new ImageIcon(".\\Final.png").getImage());
		
		frmFinalPage.setSize(new Dimension());
		frmFinalPage.setPreferredSize(FinalPanel.getDim());
		frmFinalPage.getContentPane().add(FinalPanel);
		// Fit the size of an image
		frmFinalPage.pack();
		
		
		// StartButton part
		StartButton = new JButton("");
		StartButton.setBounds(66, 454, 179, 70);
		StartButton.setContentAreaFilled(false);
		StartButton.setBorderPainted(false);
		FinalPanel.add(StartButton);
		StartButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// If user clicks the start button, move to the start page
				frmFinalPage.dispose();
				pagemoving.StartPage();
			}
		});
		
		
		// ExitButton part
		ExitButton = new JButton("");
		ExitButton.setBounds(342, 454, 179, 70);
		ExitButton.setContentAreaFilled(false);
		ExitButton.setBorderPainted(false);
		FinalPanel.add(ExitButton);
		ExitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// If user clicks the exit button, the game ends
				frmFinalPage.dispose();
			}
		});
		
		
		// Textarea that shows level score
		textArea = new JTextArea();
		textArea.setFont(new Font("210 ÇÏ¾áºÐÇÊ R", Font.PLAIN, 15));
		textArea.setBounds(12, 10, 562, 270);
		textArea.setOpaque(false);
		FinalPanel.add(textArea);
		
		
		// Textfield that shows totol score
		TotalScore = new JTextField();
		TotalScore.setFont(new Font("210 ÇÏ¾áºÐÇÊ R", Font.PLAIN, 17));
		TotalScore.setHorizontalAlignment(SwingConstants.CENTER);
		TotalScore.setBounds(149, 282, 289, 40);
		TotalScore.setOpaque(false);
		TotalScore.setBorder(null);
		FinalPanel.add(TotalScore);
		TotalScore.setColumns(10);
		
		
		// ScoreButton Part
		ScoreButton = new JButton("");
		ScoreButton.setBounds(123, 332, 347, 70);
		ScoreButton.setContentAreaFilled(false);
		ScoreButton.setBorderPainted(false);
		FinalPanel.add(ScoreButton);
		ScoreButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				start();
			}
		});
		
	}
	
	private void start() {

		// Use SwingWorker<Void, Void> and return null from doInBackground if
		// you don't want any final result and you don't want to update the GUI
		// as the thread goes along.
		// First argument is the thread result, returned when processing
		// finished.
		// Second argument is the value to update the GUI with via publish() and
		// process()
		
		SwingWorker worker = new SwingWorker<Integer, Integer>() {
			
			@Override
			/*
			 * Note: do not update the GUI from within doInBackground.
			 */
			protected Integer doInBackground() throws Exception {
				// Simulate useful work
				int score;
				int sum=0;
				for (int i=0; i<10; i++) {
					Thread.sleep(100);
					score = UserInfo.score[i];
					publish(i);
					publish(score);
					sum += score;
					publish(sum);
					int j = i+1;  // to start with '1'
					System.out.println(j + " level : " + sum);
				}
				
				return sum;	
				
			}

			@Override
			// This will be called if you call publish() from doInBackground()
			// Can safely update the GUI here.
			protected void process(List<Integer> chunks) {
				Integer i = chunks.get(chunks.size() - 3);
				i++;  // to start with '1'
				Integer score = chunks.get(chunks.size() - 2);
				Integer sum = chunks.get(chunks.size() - 1);
				textArea.append(i + " level : " + score + "\n");
				TotalScore.setText("Total Score = " + sum);
			}

			
			@Override
			// This is called when the thread finishes.
			// Can safely update GUI here.
			protected void done() {
				try {
					Integer final_sum = get();
					TotalScore.setText("Total Score = " + final_sum);
					UserInfo.initialize(); // Initializing User information 
				}
				catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 

			}
		};
		
		worker.execute();
	}
	
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		// The function that shows this panel
		frmFinalPage.setVisible(true);
	}

}
