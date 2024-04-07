package _0Softuniada._2024;

import java.util.Arrays;
import java.util.Scanner;

public class _05ArithmeticProgression {
    static final int MAX = 1000001;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = arr.length;
        System.out.printf("%d",numofAP(arr, n));
    }

    static int numofAP(int a[], int n) {
        int minarr = Integer.MAX_VALUE;
        int maxarr = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            minarr = Math.min(minarr, a[i]);
            maxarr = Math.max(maxarr, a[i]);
        }
        int dp[] = new int[n];
        int sum[] = new int[MAX];
        int ans = n + 1;
        for (int d = (minarr - maxarr); d <= (maxarr - minarr); d++) {
            Arrays.fill(sum, 0);
            for (int i = 0; i < n; i++) {
                dp[i] = 1;
                if (a[i] - d >= 1 && a[i] - d <= 1000000)
                    dp[i] += sum[a[i] - d];
                ans += dp[i] - 1;
                sum[a[i]] += dp[i];
            }
        }
        return ans;
    }
}