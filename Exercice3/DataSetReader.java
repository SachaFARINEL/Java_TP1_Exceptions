package Exercice3;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class DataSetReader {

    double[] data;

    public DataSetReader() {
        super();
    }

    public double[] readFile(String filename) throws IOException {
        int i = 0;
        FileInputStream file = new FileInputStream(filename);
        Scanner scanner = new Scanner(file);
        try {
            if (!scanner.hasNextInt())
                throw new BadDataException("catpure : readFile() : Le taille du fichier n'est pas donné");
            this.data = new double[scanner.nextInt()];
            readData(scanner);
            while (scanner.hasNextLine()) {
                this.data[i] = scanner.nextDouble();
                i++;
            }
        } finally {
            scanner.close();
        }
        return this.data;
    }

    private void readData(Scanner in) throws BadDataException {
        if (!in.hasNextInt())
            throw new BadDataException("catpure : readData() : La donnée n'est pas correct");
        int tailleTableau = in.nextInt();
        for (int i = 0; i < tailleTableau; i++) {
            readValue(in, i);
        }
    }

    private void readValue(Scanner in, int i) throws BadDataException {
        if (!in.hasNextDouble())
            throw new BadDataException("catpure : readValue() : La donnée n'est pas correct");
        this.data[i] = in.nextDouble();

    }
}
