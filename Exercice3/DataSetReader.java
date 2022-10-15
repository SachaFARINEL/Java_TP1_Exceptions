package Exercice3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DataSetReader {

    double[] data;

    public DataSetReader() {
    }

    public double[] readFile(String filename) throws IOException {
        Scanner scanner = new Scanner(new File(filename));
        this.readData(scanner);
        return this.data;
    }

    private void readData(Scanner in) throws BadDataException {
        if (in.hasNextInt()) {
            int taille = in.nextInt();
            this.data = new double[taille];
            for (int i = 0; i < taille; i++) {
                readValue(in, i);
            }
        } else {
            throw new BadDataException("DatasetReader.readData() : La première ligne du fichier n'est pas de type Double");
        }
    }

    private void readValue(Scanner in, int i) throws BadDataException {
        if (in.hasNextDouble()) {
            this.data[i] = in.nextDouble();
        } else {
            throw new BadDataException("DatasetReader.readValue() : La donnée n°" + (i + 1) + " n'est pas de type Double");
        }
    }
}
