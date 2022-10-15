package Exercice3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class DataAnalyzer {

    public static void main(String[] args) throws IOException {
        DataSetReader dataSetReader = new DataSetReader();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel est le nom du fichier à analyser ?");
        try {
            String nomFichier = scanner.nextLine();
            dataSetReader.readFile("Exercice3/" + nomFichier);
        } catch (FileNotFoundException | BadDataException e) {
            System.out.println(e.getMessage());
            System.out.println("Veuillez ressaisir le nom du fichier : ");
            String nomFichier = scanner.nextLine();
            dataSetReader.readFile("Exercice3/" + nomFichier);
        } finally {
            scanner.close();
        }
    }
}
