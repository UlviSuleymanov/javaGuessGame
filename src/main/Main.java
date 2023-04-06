package main;

import java.util.Random;
import java.util.Scanner;

public class Main {// Pojo
    private static Scanner scanner = null;
    public static int score = 0;
    public static boolean isGameStarted = false;

    public static Scanner getScanner() { // Singleton design patterni.
        if (scanner == null) {
            scanner = new Scanner(System.in);
            return scanner;
        }
        return scanner;
    }

    public static void continueGame() {
        System.out.println("Do you want to continue the game? please enter Yes/No");
        String answer = getScanner().next();
        if (answer.equalsIgnoreCase("Yes")) {
            if (isGameStarted == true) {
                isGameStarted = false;
            }
            startGame();
        } else if (answer.equalsIgnoreCase("No")) {
            System.out.println("Exiting the game...");
            if (score > 0) {
                System.out.println("You have gained this amount of points: " + score + " " + " Good Job!");
            } else if (score < 0) {
                System.out.println("You have 0 points better luck next time!");
            }
        }
    }

    public static void startGame() {
        if (isGameStarted == false) {
            isGameStarted = true;
        }
        Random random = new Random();
        if (isGameStarted) {
            System.out.println("Guess the random number. number is between 0-5. good luck!");
        }
        int x = 0;
        while (x < 5) {
            int randomInt = random.nextInt(5);
            System.out.println("Please enter the number");
            int userInput = getScanner().nextInt();
            if (userInput == randomInt) {
                System.out.println("You guessed it right! your number : " + userInput + " targeted number :" + randomInt);
                score = score + 10;
            } else if (userInput != randomInt) {
                System.out.println("You guessed it wrong your number : " + userInput + " targeted number :" + randomInt);
                score = score - 2;
            }
            x++;
        }
        continueGame();
    }

    public static void main(String[] args) {
        startGame();
    }
}