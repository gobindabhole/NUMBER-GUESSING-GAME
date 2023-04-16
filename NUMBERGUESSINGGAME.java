import java.util.Random;
import javax.swing.JOptionPane;

public class NUMBERGUESSINGGAME {
    public static void main(String[] args) {
        int attempts = 0;
        int score = 0;
        int rounds = 0;
        int maxAttempts = 10;
        int rangeMin = 1;
        int rangeMax = 100;
        boolean playAgain = true;

        JOptionPane.showMessageDialog(null, "Welcome to Guess the Number Game!");

        while (playAgain) {
            // Generate a random number
            Random random = new Random();
            int randomNumber = random.nextInt(rangeMax - rangeMin + 1) + rangeMin;
            attempts = 0;
            rounds++;

            // Game loop
            while (true) {
                // Prompt user to enter guess
                String input = JOptionPane.showInputDialog(null, "Guess the number (between " + rangeMin + " and " + rangeMax + "):");
                int guess = Integer.parseInt(input);
                attempts++;

                // Compare guess with random number
                if (guess == randomNumber) {
                    JOptionPane.showMessageDialog(null, "Congratulations! You guessed the correct number " + randomNumber + " in " + attempts + " attempts.");
                    score += maxAttempts - attempts + 1;
                    break;
                } else if (guess < randomNumber) {
                    JOptionPane.showMessageDialog(null, "Nope! The number is higher. Attempts: " + attempts);
                } else {
                    JOptionPane.showMessageDialog(null, "Nope! The number is lower. Attempts: " + attempts);
                }

                // Check if max attempts reached
                if (attempts == maxAttempts) {
                    JOptionPane.showMessageDialog(null, "Oops! You reached the maximum attempts. The correct number was " + randomNumber + ".");
                    break;
                }
            }

            // Ask user if they want to play again
            int option = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Play Again?", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.NO_OPTION) {
                playAgain = false;
            }
        }

        // Display game statistics
        JOptionPane.showMessageDialog(null, "Game Over! You played " + rounds + " rounds with a total score of " + score + " points.");
    }
}
