import java.util.Random;
import java.util.Scanner;

public class NumberguessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int minRange = 1;
        int maxRange = 100;
        int numberOfAttempts = 15; // You can change the number of attempts here.
        int rounds = 0;
        int score = 0;
        
        System.out.println("Welcome to the Number Guessing Game!");
        
        while (true) {
            int numberToGuess = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            
            System.out.println("I've selected a number between " + minRange + " and " + maxRange + ". Can you guess it?");
            
            while (attempts < numberOfAttempts) {
                System.out.print("Enter your guess (Attempt " + (attempts + 1) + "/" + numberOfAttempts + "): ");
                int userGuess = scanner.nextInt();
                
                if (userGuess < minRange || userGuess > maxRange) {
                    System.out.println("Please guess a number within the specified range.");
                    continue;
                }
                
                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the correct number: " + numberToGuess);
                    score++;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low. Try a higher number.");
                } else {
                    System.out.println("Too high. Try a lower number.");
                }
                
                attempts++;
            }
            
            if (attempts == numberOfAttempts) {
                System.out.println("You've run out of attempts. The correct number was: " + numberToGuess);
            }
            
            rounds++;
            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();
            
            if (!playAgain.equals("yes")) {
                break;
            }
        }
        
        System.out.println("Game Over!");
        System.out.println("Rounds played: " + rounds);
        System.out.println("Score: " + score + " rounds won.");
        
        scanner.close();
    }
}