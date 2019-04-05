package Lotto;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lotto {
    public static void main(String[] args) {
        lotto();
    }
    //Gra Lotto
    static void lotto(){
        System.out.println("Podaj 6 liczb:");
        int[] numbersFromUser = getNumbers();
        int[] randomNumbers = randomNumbers();
        int winNumbers = checkWin(numbersFromUser, randomNumbers);
        sortNumbers(numbersFromUser);
        //sortNumbers(randomNumbers);
        System.out.println("\nWytypowane liczby");
        System.out.println(Arrays.toString(numbersFromUser));
        System.out.println("Wylosowane liczby");
        System.out.println(Arrays.toString(randomNumbers));
        if(winNumbers != -1) {
            System.out.println("Gratuluje trafiłeś " + winNumbers);
        }else{
            System.out.println("Tym razem nie udało się wygrać");
        }

    }
    // Sprawdzenie ilości trafień
    static int checkWin (int[] numbersFromUser, int[] randomNumbers){
        int winNumber = 0;
        for (int i = 0; i <numbersFromUser.length ; i++) {
            for (int j = 0; j <randomNumbers.length ; j++) {
                if(numbersFromUser[i] == randomNumbers[j])
                {
                    winNumber++;
                }
            }
        }
        if( winNumber >= 3){
            return winNumber;
        }
        return -1;
    }
    // Losowanie 6 liczb
    static int[] randomNumbers(){
        Random generator = new Random();
        int[] randomNumbers = new int[6];
        int number;
        int index = 1;
        boolean torf = false;
        while(index <= 6){
            number = generator.nextInt(49) + 1;
            for (int i = 0; i <index-1; i++) {
                if(number == randomNumbers[i]){
                    torf = true;
                }
            }
            if(!torf){
                randomNumbers[index-1] = number;
                index +=1;
            }
        }
        return randomNumbers;
    }
    // Pobranie typowanych liczb od Użytkownika
    static int[] getNumbers(){
        int index = 0;
        int number;
        int[] numbersFromUser = new int[6];
        boolean torf = false;
        Scanner scan = new Scanner(System.in);
        while(index < 6){
            while(!scan.hasNextInt()){
                System.out.println("To nie jest liczba");
                scan.nextLine();
            }
            number = scan.nextInt();
            if(number > 0 && number <= 49){
                for (int i = 0; i <index ; i++) {
                    if(number == numbersFromUser[i]){
                        torf = true;
                    }
                }
                if (!torf) {
                    numbersFromUser[index] = number;
                    index += 1;
                    if(index < 6) {
                        System.out.println("Podaj kolejną liczbę");
                    }
                }else{
                    System.out.println("Tą liczbę już podałeś");
                    torf = false;
                }
            }else{
                System.out.println("Podaj liczbę z zakresu 1 - 49");
            }
        }
        return numbersFromUser;
    }
    //Sortowanie rosnąco
    public static int[] sortNumbers (int[] numbers){
        Arrays.sort(numbers);
        return numbers;
    }
}
