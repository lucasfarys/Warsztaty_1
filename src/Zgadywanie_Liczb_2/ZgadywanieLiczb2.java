package Zgadywanie_Liczb_2;

import java.util.Scanner;

public class ZgadywanieLiczb2 {
    public static void main(String[] args) {
        playCheckNumber();
    }

    //Gra zgadywanie liczb
    static void playCheckNumber() {
        int number = getNumber();
        askUser(number);
    }

    //Szukanie liczby podanej przez Użytkownika
    static void askUser(int number) {
        int min = 0;
        int max = 1000;
        int num;
        int checkNumber = checkFoundNumber(min, max);
        while (checkNumber != number) {
            System.out.println("Szukana liczba jest wieksza czy mniejsza od: " + checkNumber);
            System.out.println("1 - mniejsza");
            System.out.println("2 - większa");
            // Pobranie informacji od Użytkownika
            // czy szukana liczba jest większa czy mniejsza
            num = getAnswer();
            //Przesunięcie szukanego zakresu min, max
            if (num == 1) {
                max = checkNumber;
            }
            if (num == 2) {
                min = checkNumber;
            }
            //Wytypowanie nowej liczby
            checkNumber = checkFoundNumber(min, max);
        }
        System.out.println("Trafiony zatopiony");
        System.out.println("Szukana liczba to: " + checkNumber);

    }

    // Pobranie odpowiedzi od Użytkownika czy szukana
    // liczba jest większa czy mniejsza
    static int getAnswer() {
        int result = 0;
        int number;
        boolean torf = false;
        Scanner scan = new Scanner(System.in);
        while (!torf) {
            while (!scan.hasNextInt()) {
                System.out.println("To nie jest liczba");
                scan.nextLine();
            }
            number = scan.nextInt();
            if (number == 1 || number == 2) {
                result = number;
                torf = true;
            } else {
                System.out.println("Podaj liczbą 1 lub 2");
            }
        }
        return result;
    }

    static int checkFoundNumber(int min, int max) {
        return min + (max - min) / 2;
    }

    // Pobranie liczby od Użytkownika
    static int getNumber() {
        int number = 0;
        boolean torf = false;
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj liczbę");
        while (!torf) {
            while (!scan.hasNextInt()) {
                System.out.println("To nie jest liczba");
                scan.nextLine();
            }
            number = scan.nextInt();
            if (number > 0 && number <= 1000) {
                torf = true;
            } else {
                System.out.println("Podaj liczbe z zakresu 1 - 1000");
            }
        }
        return number;
    }

}
