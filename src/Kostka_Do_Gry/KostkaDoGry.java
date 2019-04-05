package Kostka_Do_Gry;

import java.util.Random;

public class KostkaDoGry {
    public static void main(String[] args) {
        throwsCube("4D10+12");
    }
    // Rzuty kostką
    static void throwsCube(String str) {
        int numberOfThrow;
        int kindOfCube;
        int modifier;
        int[] rzuty;
        String[] data = str.split("D");
        if (!data[0].equalsIgnoreCase("")) {
            numberOfThrow = Integer.parseInt(data[0]);
        }else{
            numberOfThrow = 1;
        }
        if (data[1].contains("+")) {
            data = data[1].split("\\+");
        } else if (data[1].contains("-")) {
            data = data[1].split("\\-");
        }
        kindOfCube = Integer.parseInt(data[0]);
        modifier = Integer.parseInt(data[1]);
        rzuty = rzut(numberOfThrow, kindOfCube, modifier);
    }
    // Obliczenie wartości rzutów
    static int[] rzut(int numberOfThrow, int kindOfCube, int modifier) {
        int[] result = new int[numberOfThrow];
        Random random = new Random();
        for (int i = 0; i < numberOfThrow; i++) {
            result[i] = random.nextInt(kindOfCube) + modifier;
            System.out.println(result[i]);
        }
        return result;
    }
}
