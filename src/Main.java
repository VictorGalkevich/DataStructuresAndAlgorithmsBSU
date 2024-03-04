import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();

        if (str1.length() != str2.length()) {
            System.out.println(-1);
            return;
        }

        String concatenatedStr = str1 + "$" + str2;

        int[] suffixArray = buildSuffixArray(concatenatedStr);
        int shift = findMinimumShift(suffixArray, str1.length());

        System.out.println(shift);
    }

    private static int[] buildSuffixArray(String str) {
        int n = str.length();
        int[] suffixArray = new int[n];

        Suffix[] suffixes = new Suffix[n];
        for (int i = 0; i < n; i++) {
            suffixes[i] = new Suffix(i, str.substring(i));
        }

        Arrays.sort(suffixes);

        for (int i = 0; i < n; i++) {
            suffixArray[i] = suffixes[i].index;
        }

        return suffixArray;
    }

    private static int findMinimumShift(int[] suffixArray, int str1Length) {
        int n = suffixArray.length;

        for (int i = 0; i < n - 1; i++) {
            int currentSuffix = suffixArray[i];
            int nextSuffix = suffixArray[i + 1];

            if (currentSuffix < str1Length && nextSuffix > str1Length) {
                return currentSuffix;
            }
        }

        return -1;
    }

    static class Suffix implements Comparable<Suffix> {
        int index;
        String suffix;

        Suffix(int index, String suffix) {
            this.index = index;
            this.suffix = suffix;
        }

        @Override
        public int compareTo(Suffix other) {
            return this.suffix.compareTo(other.suffix);
        }
    }
}