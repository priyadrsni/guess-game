package com.example.guessgame;

import java.io.File;
import java.util.Scanner;

public class MovieGuess {

    //fields
    private static int noOfWrongGuess = 0;       //noofwrongguesses(int)
    private static boolean test = true;         //test(boolean)
    //method - main method

    public static void main(String[] args) throws Exception {
        //To read the file display the whole list...
        File file = new File("movies.txt");
        Scanner scanner = new Scanner(file);
        String[] movie = new String[30];
        //assingning each line of the text file to an array..
        while (scanner.hasNext()) {
            if (scanner.nextLine() != null) {
                for (int i = 0; i < 18; i++) {
                    movie[i] = scanner.nextLine();
                }
            }
        }
        Game game = new Game();
        System.out.println("Let's play a movie guessing game:)");
        int randomMovie = (int) (Math.random() * 18) + 1;                     //randommovie(int)
        System.out.println("You have to find the movie name hidden below.");
        String caseFree = movie[randomMovie].toLowerCase();                   // caseFree(string)
        //System.out.println(caseFree);
        String hiddenMovie = caseFree.replaceAll("[a-zA-Z0-9]", "-"); //hiddenmovie(string)
        System.out.println(hiddenMovie);
        System.out.println("No. of underscores represents the no of characters.");
        System.out.println("And you'll be provided with 10 chances for wrong guesses...GOODLUCK!");
        char[] first = caseFree.toCharArray();                                // first[](char)
        char[] second = hiddenMovie.toCharArray();                            //second[](char)
        //To read the user input...
        while (test) {            //CharSequence lcs = Character.toString(letter);String l = Character.toString(letter);
            char letter = game.input();
            //To check if the letter already exists..if so it'll read the input again..
            letter = game.guessedletter(letter);
            CharSequence lcs = Character.toString(letter);
            //to search the user input in the movie name..and when it has the particular letter..
            if (caseFree.contains(lcs)) {
                int index = caseFree.indexOf(letter);
                for (int i = index; i <= caseFree.lastIndexOf(letter); i++) {
                    if (first[i] == letter) {
                        second[i] = letter;
                    }
                }
                String stringOfSecond = new String(second);
                System.out.println("You have guessed a correct letter:)"); //String answer = new String();
                for (int i = 0; i < hiddenMovie.length(); i++) {
                    System.out.print(second[i]);
                    stringOfSecond = new String(second);
                }//when the user found all letters and WIN!...
                if (stringOfSecond.equals(caseFree)) {
                    System.out.println("\n**You win..You found the correct movie name - " + movie[randomMovie]);
                    System.out.println("guessed letters are: " + game.gl);
                    test = false;
                }
            }
            //to search the user input in the movie name..and when it doesn't has the particular letter..
            else {
                if (noOfWrongGuess < 10) {
                    noOfWrongGuess += 1;
                    game.wrongGuess(noOfWrongGuess);
                }//when the user is out of chances and LOST...
                if (noOfWrongGuess == 10) {
                    System.out.println("You lost by out of chances:(");
                    System.out.println("guessed letters are: " + game.gl);
                    test = false;
                }
            }
        }
    }
}
