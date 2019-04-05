package Zgadywanie_Liczb;

import java.util.Random;
import java.util.Scanner;

public class ZgadywanieLiczb {
    public static void main(String[] args) {
        random();
    }

    //Sprawdzenie podanej liczby przez Użytkownika
    static void random() {
        int randomNumber;
        int checkNumber;
        Random generator = new Random();
        randomNumber = generator.nextInt(100) + 1;

        System.out.println("Zgadnij liczbę");
        checkNumber = getNumber();
        do {
            if (checkNumber > randomNumber) {
                System.out.println("Podaj mniejszą liczbę");
                checkNumber = getNumber();
            } else if (checkNumber < randomNumber) {
                System.out.println("Podaj większą liczbę");
                checkNumber = getNumber();
            }
        } while (randomNumber != checkNumber);
        System.out.println("Zgadłeś :) szukaną liczbą jest " + checkNumber);
    }

    //Pobieranie liczby od Użytkownika
    static int getNumber() {
        int number = 0;
        boolean torf = false;
        Scanner scaner = new Scanner(System.in);
        while (!torf) {
            while (!scaner.hasNextInt()) {
                System.out.println("To nie jest Liczba");
                scaner.next();
            }
            number = scaner.nextInt();
            if (number > 0 && number <= 100) {
                torf = true;
            } else {
                System.out.println("To nie jest liczba w zakresie 0 - 100");
                System.out.println("Podaj liczbę");
            }

        }
        return number;
    }
}
