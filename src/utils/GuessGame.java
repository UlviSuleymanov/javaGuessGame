package utils;

import java.util.Random;
import java.util.Scanner;

public class GuessGame {
    public static int rightScore;
    public static int wrongScore;
    public static int score;
    public static boolean isGameStarted = false;
    private static Scanner scanner = null;

    public static Scanner getScanner() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }

    public static void printText(String text) {
        System.out.println(text);
    }

    public static void continueGame() {
        printText("Do you want to continue game? please enter Yes or No as answer");
        scanner = getScanner();
        String answer = scanner.next();
        if (isGameStarted == true) {
            isGameStarted = false;
        }
        if (answer.equalsIgnoreCase("Yes")) {
            startGame();
        } else if (answer.equalsIgnoreCase("No")) {
            if (score > 0) {
                printText("Quiting the game.... your total score is : " + score);
            } else if (score < 0) {
                printText("Quitting the game .... your total score is : 0");
            } else {
                printText("Something went wrong. Quiting the game. your total score is : 0");
            }
        }
    }

    public static void startGame() {
        if (isGameStarted) {
            isGameStarted = true;
        }
        printText("Welcome to the Guess game! guess the number it's between 0-5 good luck!");
        Scanner scanner = getScanner();
        Random randomGenerator = new Random();
        int x = 0;
        while (x < 5) {
            int randomNumber = randomGenerator.nextInt(5);
            printText("Please enter your guessed number.");
            int guessedNumber = scanner.nextInt();
            if (guessedNumber == randomNumber) {
                printText("You have guessed it right! targeted number :" + randomNumber + " Your answer: " + guessedNumber);
                rightScore++;
            } else if (guessedNumber != randomNumber) {
                printText("Wrong answer. targeted number :" + randomNumber + " Your answer :" + guessedNumber);
                wrongScore++;
            }
            x++;
        }
        score = rightScore - wrongScore;
        if (x == 5) {
            continueGame();
        }
    }

}
