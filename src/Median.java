
import java.util.Scanner;


public class Median {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] ints1 = scanner.nextLine().split(" ");
        String[] ints2 = scanner.nextLine().split(" ");

        int N = ints1.length;
        int[] array1 = new int[N];
        int[] array2 = new int[N];
        for (int i = 0; i < N; i++) {
            array1[i] = Integer.parseInt(ints1[i]);
            array2[i] = Integer.parseInt(ints2[i]);
        }

        int j = -1, k = -1;
        int a = 0, b = 0;
        for (int i = 0; i < N + 1; i++) {
            if (j == N - 1) {
                k++;
                a = b;
                b = array1[k];
                continue;
            }
            if (k == N - 1) {
                j++;
                a = b;
                b = array2[j];
                continue;
            }

            if (array1[k + 1] < array2[j + 1]) {
                k++;
                a = b;
                b = array1[k];
            } else {
                j++;
                a = b;
                b = array2[j];
            }
        }

        float median = a / 2f + b / 2f;
        System.out.println(median);
    }
}
