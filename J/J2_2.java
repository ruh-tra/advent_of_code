package J;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class J2_2 {
    public static void main(String[] args) {
        File file = new File("./inputs/1.input");
        int password = 0;
        float current = 50;
        float prev = 50;

        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                
                if (data.charAt(0) == 'L') {
                    current -= Integer.parseInt(data.substring(1));
                } else if (data.charAt(0) == 'R') {
                    current += Integer.parseInt(data.substring(1));
                }

                if (prev != 0 || Integer.parseInt(data.substring(1)) >= 100) {
                    password += Math.abs(Math.floor(current / 100));
                    if (prev == 0 && Integer.parseInt(data.substring(1)) > 100 && data.charAt(0) == 'L') {
                        password--;
                    }
                }

                if (current <= 0 && Math.abs(current) % 100 == 0) {
                    password++;
                }

                current = ((current % 100) + 100) % 100;
                prev = current;
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        System.out.println(password);
    }
}
