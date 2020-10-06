import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;



import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class GuessingGame extends JFrame {
	private JButton btnPlayAgain;
	private JButton btnNewButton;
	private JTextField txtGuess;
	private JLabel lblOutput;
	private int theNumber;
	private int numberOfTries = 10;
	private JLabel lblTriesCount;
	public void checkGuess() {
		String guessText = txtGuess.getText();
		String message = "";
		try {
			int guess = Integer.parseInt(guessText);
			numberOfTries--;
				if (guess < theNumber)
				message = guess + " is too low. Try again!";
				else if (guess > theNumber)
				message = guess + " is too high. Try again!";
				else {
				message = guess + " is correct! You win after " + numberOfTries + " tries! Good work! Let's play again!";
				btnPlayAgain.setVisible(true);
				btnNewButton.setVisible(false);
				lblTriesCount.setVisible(false);
				}
				if (numberOfTries <= 0) {
					message = "You are a LOSER! Right number is " + theNumber + ".";
					btnPlayAgain.setVisible(true);
					btnNewButton.setVisible(false);
					lblTriesCount.setVisible(false);
				}
		} 
		catch(Exception e) {
			message = "Enter a whole number between 1 and 100!";
		}
		finally {
			lblOutput.setText(message);
			lblOutput.setVisible(true);
			lblTriesCount.setText("You have " + numberOfTries + " tries left!");
			txtGuess.requestFocus();
			txtGuess.selectAll();
		}	
	}
	public void newGame() {
		theNumber = (int) (Math.random() * 100 + 1);
		numberOfTries = 10;
		lblTriesCount.setText("You have " + numberOfTries + " tries to guess the number");
		lblOutput.setText("Enter a number above and click \"Guess!\"");
		lblTriesCount.setVisible(true);
		
	}
	public GuessingGame() {
		getContentPane().setBackground(new Color(152, 251, 152));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Vovan's Hi-Lo Guessing Game.");
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Vovan's Hi-Lo Guessing Game.");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Snap ITC", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 28, 414, 27);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Guess a number between 1 and 100:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(47, 83, 255, 14);
		getContentPane().add(lblNewLabel_1);

		txtGuess = new JTextField();
		txtGuess.setForeground(new Color(0, 0, 0));
		txtGuess.setHorizontalAlignment(SwingConstants.CENTER);
		txtGuess.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkGuess();
			}
		});
		txtGuess.setBounds(312, 74, 38, 32);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);

		btnNewButton = new JButton("Guess!");
		btnNewButton.setBackground(new Color(46, 139, 87));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				checkGuess();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(176, 125, 89, 23);
		getContentPane().add(btnNewButton);

		lblOutput = new JLabel("Enter a number above and click \"Guess!\"");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOutput.setBounds(10, 176, 414, 14);
		getContentPane().add(lblOutput);
		
		btnPlayAgain = new JButton("Play again!");
		btnPlayAgain.setBackground(new Color(60, 179, 113));
		btnPlayAgain.setForeground(new Color(255, 0, 0));
		btnPlayAgain.setVisible(false);
		btnPlayAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent again) {
				newGame();
				btnPlayAgain.setVisible(false);
				btnNewButton.setVisible(true);
			}
		});
		btnPlayAgain.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPlayAgain.setBounds(159, 125, 120, 23);
		getContentPane().add(btnPlayAgain);
		
		lblTriesCount = new JLabel("You've got " + numberOfTries + " tries to guess the number");
		lblTriesCount.setForeground(new Color(0, 0, 0));
		lblTriesCount.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
			}
			public void ancestorMoved(AncestorEvent arg0) {
			}
			public void ancestorRemoved(AncestorEvent arg0) {
			}
		});
		lblTriesCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblTriesCount.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTriesCount.setBounds(10, 218, 414, 14);
		getContentPane().add(lblTriesCount);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(450,300));
		theGame.setVisible(true);
	}
}
