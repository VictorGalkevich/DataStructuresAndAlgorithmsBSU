import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < k; i++) {
            builder.append(solver(arr, scanner.nextInt())).append("\n");
        }
        System.out.println(builder.toString().trim());
    }


    public static int lower(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int mid = (low + high) >>> 1;
            int midVal = arr[mid];

            if (midVal < key) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        return low;
    }
    public static int upper(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int mid = (low + high) >>> 1;
            int midVal = arr[mid];

            if (midVal <= key) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        return low;
    }

    public static String solver(int[] arr, int key) {
        if (arr.length == 0) {
            return "0 0 0";
        }
        int first = lower(arr, key);
        int afterLast = upper(arr, key);
        int v2 = arr[afterLast] > key ? afterLast : arr.length;
        int v1 = arr[first] >= key ? first : arr.length;
        int v0 = arr[first] == key ? 1 : 0;
        return v0 + " " + v1 + " " + v2;
    }
}
