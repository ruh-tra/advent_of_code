package D2.U2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

public class Main {
    public static void main(String[] arg) {
        File file = new File("./inputs/2.input");

        ArrayList<Set<Long>> invalid = new ArrayList<Set<Long>>();

        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                String[] ranges = data.split(",");
                for (String range : ranges) {
                    String[] ids = range.split("-");
                    long lower = Long.parseLong(ids[0]);
                    long higher = Long.parseLong(ids[1]);

                    invalid.add(find_invalid_ids(lower, higher));
                }
            }

            long answer = invalid.stream().mapToLong(set -> set.stream().mapToLong(Long::longValue).sum()).sum();
            System.out.println(answer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Set<Long> find_invalid_ids(long lower, long higher) {
        Set<Long> invalids = new HashSet<Long>();
        Set<Integer> primes = new HashSet<Integer>();

        for (int n = 2; n < Math.ceil(Math.log10(higher) + 1); n++) {
            for (int p : primes) {
                if (n % p == 0) {
                    break;
                }
            }
            primes.add(n);
        }

        for (long n = lower; n < higher; n++) {
            for (int p : primes) {
                if (p > Math.ceil(Math.log10(n))) {
                    continue;
                }

                int endIdx = (int)Math.ceil(Math.log10(n) / p);
                long partition = Long.parseLong(Long.toString(n).substring(0, endIdx).repeat(p));

                if (partition == n) {
                    invalids.add(partition);
                }
            }
        }

        return invalids;
    }
}
