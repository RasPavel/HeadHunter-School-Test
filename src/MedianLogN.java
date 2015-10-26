import java.util.Scanner;

/**
 * Created by pavel on 26.10.15.
 */
public class MedianLogN {
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

        int aIndex = N / 2;
        int l = 0;
        int r = N - 1;
        int cmp = compareIndex(aIndex, array1, array2);
        while (cmp != 0) {
            if (cmp > 0) {
                l = aIndex + 1;
            } else {
                r = aIndex - 1;
            }
            aIndex = (r + l) / 2;
            cmp = compareIndex(aIndex, array1, array2);
        }

        int bIndex = N - aIndex - 1;
        int a = array1[aIndex];
        int b = array2[bIndex];
        int preA = (aIndex > 0) ? array1[aIndex - 1] : Integer.MIN_VALUE;
        int preB = (bIndex > 0) ? array2[bIndex - 1] : Integer.MIN_VALUE;

        float median =  Math.max(preA, b) / 2f + Math.max(preB, a) / 2f;
        System.out.println(median);
    }

    private static int compareIndex(int aIndex, int[] a, int[] b) {
        int N = a.length;
        int bIndex = N - aIndex - 1;
        if ((bIndex < N - 1) && (a[aIndex] > b[bIndex + 1])) {
            return -1;
        }
        if ((aIndex < N - 1) && (b[bIndex] > a[aIndex + 1])) {
            return 1;
        }
        return 0;
    }
}
