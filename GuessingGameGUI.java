import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GuessingGameGUI extends JFrame {
    private JLabel betLabel;
    private JTextField betField;
    private JLabel guessLabel;
    private JTextField guessField;
    private JButton playButton;
    private JTextArea resultArea;
    private int randomNumber;
    private int playerBet;

    public GuessingGameGUI() {
        // Set up the JFrame properties
        setTitle("Guessing Game with Betting");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2));

        // Initialize components
        betLabel = new JLabel("Enter your bet:");
        betField = new JTextField();
        guessLabel = new JLabel("Enter your guess (1-10):");
        guessField = new JTextField();
        playButton = new JButton("Play");
        resultArea = new JTextArea();
        resultArea.setEditable(false);

        // Add components to the JFrame
        add(betLabel);
        add(betField);
        add(guessLabel);
        add(guessField);
        add(playButton);
        add(resultArea);

        // Add ActionListener to the playButton
        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                playGame();
            }
        });
    }

    private void playGame() {
        // Get the player's bet and guess from the text fields
        try {
            playerBet = Integer.parseInt(betField.getText());
            int playerGuess = Integer.parseInt(guessField.getText());

            // Generate a random number between 1 and 10
            randomNumber = new Random().nextInt(10) + 1;

            // Determine if the player won or lost the bet
            if (playerGuess == randomNumber) {
                resultArea.setText("Congratulations! You guessed correctly!\nYou won " + playerBet + " coins.");
            } else {
                resultArea.setText("Sorry, the correct number was " + randomNumber + ".\nYou lost " + playerBet + " coins.");
            }
        } catch (NumberFormatException ex) {
            resultArea.setText("Please enter valid numbers for bet and guess.");
        }
    }

    public static void main(String[] args) {
        // Create and display the GUI
        SwingUtilities.invokeLater(() -> {
            GuessingGameGUI gui = new GuessingGameGUI();
            gui.setVisible(true);
        });
    }
}
