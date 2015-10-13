
import java.util.Scanner;


public class Median {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] ints1 = scanner.nextLine().split(" ");
        String[] ints2 = scanner.nextLine().split(" ");

        int N = ints1.length;
        int[] array1 = new int[ints1.length];
        int[] array2 = new int[ints2.length];
        for (int i = 0; i < N; i++) {
            array1[i] = Integer.parseInt(ints1[i]);
            array2[i] = Integer.parseInt(ints2[i]);
        }

        int j = -1;
        int k = -1;
        for (int i = 0; i < N + 1; i++) {
            if (j == N - 1) {
                k++;
                continue;
            }
            if (k == N - 1) {
                j++;
                continue;
            }
            if (array1[j + 1] < array2[k + 1]) {
                j++;
            } else {
                k++;
            }
        }

        int middleA = (j != -1) ? array1[j] : array2[k + 1];
        int middleB = (k != -1) ? array2[k] : array1[j + 1];
        double median = middleA / 2.0 + middleB / 2.0;

        System.out.println(median);
    }
}
