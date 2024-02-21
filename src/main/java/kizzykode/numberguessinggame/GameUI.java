/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kizzykode.numberguessinggame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Kizzy
 */
public class GameUI {
    private JFrame frame;
    private JLabel titleLabel, promptLabel, resultLabel, timerLabel;
    private JTextField guessField;
    private JButton guessButton;
    private int targetNumber;
    private int attemptsLeft;
    private int timeRemaining;

    public void initialize() {
        frame = new JFrame("Number Guessing Game");
        frame.setLayout(new GridLayout(6, 1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.BLACK);

        titleLabel = new JLabel("Number Guessing Game");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.RED);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(titleLabel);

        targetNumber = generateRandomNumber();
        attemptsLeft = 3; // 3 attempts allowed
        timeRemaining = 30; // 30 seconds allowed

        promptLabel = new JLabel("Guess a number between 1 and 9:");
        promptLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        promptLabel.setForeground(Color.RED);
        frame.add(promptLabel);

        guessField = new JTextField(10);
        guessField.setFont(new Font("Arial", Font.PLAIN, 18));
        frame.add(guessField);

        guessButton = new JButton("Guess");
        guessButton.setFont(new Font("Arial", Font.BOLD, 18));
        guessButton.setForeground(Color.BLACK);
        guessButton.setBackground(Color.RED);
        frame.add(guessButton);

        resultLabel = new JLabel("");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 18));
        resultLabel.setForeground(Color.RED);
        frame.add(resultLabel);

        timerLabel = new JLabel("Time remaining: " + timeRemaining + " seconds");
        timerLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        timerLabel.setForeground(Color.RED);
        frame.add(timerLabel);

        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleGuess();
            }
        });
        
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                updateTimeRemaining();
            }
        }, 1000, 1000);

        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null); // Center the window
        frame.setVisible(true);
    }

    

    private void handleGuess() {
        try {
            int guess = Integer.parseInt(guessField.getText());
            if (guess < 1 || guess > 9) {
                resultLabel.setText("Please enter a valid number between 1 and 9.");
            } else {
                attemptsLeft--;
                if (guess == targetNumber) {
                    resultLabel.setText("Congratulations! You guessed the correct number.");
                    guessButton.setEnabled(false);
                } else if (guess < targetNumber) {
                    resultLabel.setText("Too Low. Attempts left: " + attemptsLeft);
                } else {
                    resultLabel.setText("Too High. Attempts left: " + attemptsLeft);
                }
                if (attemptsLeft == 0) {
                    revealNumber();
                }
            }
        } catch (NumberFormatException ex) {
            resultLabel.setText("Please enter a valid number.");
        }
        guessField.setText("");
    }

    private void updateTimeRemaining() {
        if (attemptsLeft > 0) {
            timeRemaining--;
            timerLabel.setText("Time remaining: " + timeRemaining + " seconds");
            if (timeRemaining == 0) {
                revealNumber();
            }
        }
    }

    private void revealNumber() {
        resultLabel.setText("Out of attempts. The number was: " + targetNumber);
        guessButton.setEnabled(false);
    }

    private int generateRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(9) + 1;
    }
}
