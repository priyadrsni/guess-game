package com.example.guessgame;

import java.util.Scanner;

public class Game {

    //fields
    private final Scanner scanner = new Scanner(System.in);
    private char[] guessedLetters = new char[20];
    public String gl = new String(guessedLetters);
    private char ch;

    //methods
    public char input() {
        System.out.println("\nGuess a letter:");
        return scanner.next().charAt(0);
    }

    public char guessedletter(char c) {
        CharSequence f = Character.toString(c);
        String l = Character.toString(c);
        if (gl.contains(f)) {
            //char let =
            alreadyExist();
            String lets = Character.toString(ch);
            char ch1 = guessedletter(ch);
            gl = gl.concat(lets);
            return ch1;
        } else {
            gl = gl.concat(l);
            return c;
        }
    }

    private void alreadyExist() {

        System.out.println("You guessed this letter already..Guess again");
        ch = input();

    }

    public void wrongGuess(int number) {
        System.out.println("You guessed " + number + " letter wrongly");
        System.out.println("\nYou have " + (10 - number) + " chances remaining.");

    }
}
