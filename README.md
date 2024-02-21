# Number Guessing Game

This is a simple Java Number Guessing Game with a graphical user interface (GUI). The game allows the player to guess a number between 1 and 9 within a limited number of attempts and a specified time frame.

## Features

- **Graphical User Interface (GUI):** The game has a user-friendly GUI built using Java Swing, providing an interactive experience.

- **Limited Attempts:** Players have a limited number of attempts (default: 3) to guess the correct number.

- **Time Limit:** There is a time limit (default: 30 seconds) within which the player must make their guesses.

## How to Play

1. Run the `NumberGuessingGame` class to start the game.
2. A window will appear with the game title and instructions.
3. Enter your guess in the provided text field.
4. Click the "Guess" button to submit your guess.
5. Receive feedback on whether your guess is too high, too low, or correct.
6. Keep guessing within the given attempts and time limit.

## Implementation Details

- The game generates a random target number between 1 and 9 for the player to guess.
- The GUI includes a countdown timer indicating the time remaining for the player to make guesses.
- The player is informed of the outcome after each guess, including whether they guessed the correct number or if the time/attempts ran out.
- The game ends when the player either guesses the correct number, runs out of attempts, or the time limit is reached.

## Code Structure

- The main game logic and GUI elements are encapsulated in the `GameUI` class.
- The `NumberGuessingGame` class contains the `main` method, which initializes the game by creating an instance of `GameUI`.

## How to Run

1. Clone the repository.
2. Open the project in your preferred Java development environment.
3. Run the `NumberGuessingGame` class.

Feel free to explore, modify, and enhance the game as you see fit!
