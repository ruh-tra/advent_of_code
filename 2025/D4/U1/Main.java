package D4.U1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("./inputs/4.input");

        String[][] grid = new String[141][141];

        int accessible = 0;

        for (int row = 0; row < 141; row++) {
            for (int col = 0; col < 141; col++) {
                grid[col][row] = ".";
            }
        }
        try (Scanner reader = new Scanner(file)) {
            for (int col = 0; reader.hasNextLine(); col++) {
                String line = reader.nextLine();
                for (int row = 0; row < line.length(); row++) {
                    grid[col + 1][row + 1] = line.substring(row, row + 1);
                }
            }

            for (int col_idx = 1; col_idx < 140; col_idx++) {
                for (int row_idx = 1; row_idx < 140; row_idx++) {
                    int adj = 0;
                    for (int d_col = -1; d_col <= 1; d_col++) {
                        for (int d_row = -1; d_row <= 1; d_row++) {
                            if ("@x".contains(grid[col_idx + d_col][row_idx + d_row])) {
                                adj++;    
                            }
                        }
                    }
                    if (adj < 5 && grid[col_idx][row_idx].equals("@")) {
                        grid[col_idx][row_idx] = "x";
                        accessible++;
                    } 
                }
            }

            for (String[] line : grid) {
                System.out.println(String.join("",line));
            }

            System.out.println(accessible);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
