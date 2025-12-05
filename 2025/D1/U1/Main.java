package D1.U1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("./inputs/1.input");
        int password = 0;
        int current = 50;

        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                if (data.charAt(0) == 'L') {
                    current = (current - Integer.parseInt(data.substring(1))) % 100;
                } else if (data.charAt(0) == 'R') {
                    current = (current + Integer.parseInt(data.substring(1))) % 100;
                }
                if (current == 0) {
                    password++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        System.out.println(password);
    }
}