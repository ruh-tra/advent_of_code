package D3.U1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int joltage = 0;
        int n = 2;
        File file = new File("./inputs/3.input");

        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                for (int k = -n + 1; k < 1; k++) {
                    joltage += Integer.parseInt(getMaxChar(line.substring(0, line.length() + k))) * Math.pow(10, -k);
                    line = line.substring(line.indexOf(getMaxChar(line.substring(0, line.length() + k))) + 1);
                }
            }
            System.out.println(joltage);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String getMaxChar(String str) {
        char maxChar = str.charAt(0);
        for (char c : str.toCharArray()) {
            if (c > maxChar) {
                maxChar = c;
            }
        }
        return Character.toString(maxChar);
    }
}
