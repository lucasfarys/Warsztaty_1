package Wyszukiwarka;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Wyszukiwarka {
    public static void main(String[] args) {
        Connection connect = Jsoup.connect("http://www.onet.pl/");
        StringBuilder strBuild = new StringBuilder();
        StringBuilder strBuildFilter;
        String str;
        String[] words = {"oraz", "ponieważ"};
        try {
            //Tworzenie połączenia
            Document document = connect.get();
            Elements links = document.select("span.title");
            //Sortowanie słów.
            for (Element elem : links) {
                str = belowThreeLetter(elem);
                strBuild.append(str);
            }
            //Filtrowanie ze słów kluczowych
            strBuildFilter = filteredWords(strBuild, words);
            writeFile(strBuild, "popular_words.txt");
            writeFile(strBuildFilter, "filtered_popular_words.txt");
            //System.out.println(readFile("popular_words.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // Usunięcie wyrazów krótszych niż 3 znaki.
    static String belowThreeLetter(Element elem) {
        String str = elem.text();
        String[] tab = str.split(" ");
        StringBuilder strBuild = new StringBuilder();
        for (int i = 0; i < tab.length; i++) {
            if (tab[i].length() >= 3) {
                strBuild.append(tab[i] + "\n");
            }
        }
        return strBuild.toString();
    }

    //Zapis do pliku.
    static void writeFile(StringBuilder strBuild, String str) {
        try {
            FileWriter fwr = new FileWriter(str);
            fwr.write(strBuild.toString());
            fwr.close();
        } catch (IOException e) {
            System.out.println("Nie można zapisać do pliku");
        }
    }

    //Wczytywanie z pliku txt.
    static String readFile(String str) {
        File file = new File(str);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                stringBuilder.append(scanner.nextLine() + "\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nie można otworzyć pliku");
        }
        return stringBuilder.toString();
    }

    //Filtrowanie ze słów kluczowych
    static StringBuilder filteredWords(StringBuilder strBuild, String[] excluded_words) {
        String[] tab = strBuild.toString().split("\n");
        StringBuilder stringFilterBuild = new StringBuilder();
        for (String val1 : tab) {
            for (String val2 : excluded_words) {
                if (val1 != val2) {
                    stringFilterBuild.append(val1 + "\n");
                }
            }

        }
        return stringFilterBuild;
    }
}
