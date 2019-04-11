package com.ineat;

import com.ineat.input.InputFetcher;
import com.ineat.output.OutputWriter;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        new App().startGame();
    }

    private Integer tries;
    private Integer secretNumber;
    private Scanner scanner = new Scanner(System.in);
    private OutputWriter writer = System.out::println;

    private void startGame() {
        secretNumber = generateSecretNumber();
        writer.write("I'm thinking of a secret number from 1 to 100...");
        while(getGuess(() -> scanner.nextInt()) != secretNumber);
        writer.write("You got the answer in " + tries + " tries");
    }

    private int getGuess(InputFetcher fetcher) {
        System.out.print("Take a guess: ");
        return fetcher.fetch();
    }

    private int generateSecretNumber() {
        return (int) (Math.random() * 100);
    }
}
