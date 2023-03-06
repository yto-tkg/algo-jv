import java.util.Arrays;
import java.util.Scanner;

public class Code52 {
    public class Main {
        public static void main(String[] args) {
            // 入力
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            int W = sc.nextInt();
            int[] a = new int[N];
            for (int i = 0; i < N; ++i) {
                a[i] = sc.nextInt();
            }

            // DP
            boolean[][] dp = new boolean[N+1][W+1];
            dp[0][0] = true;
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j <= W; ++j) {
                    // a[i] を選ばない場合
                    if (dp[i][j]) {
                        dp[i+1][j] = true;
                    }

                    // a[i] を選ぶ場合
                    if (j >= a[i] && dp[i][j-a[i]]) {
                        dp[i+1][j] = true;
                    }
                }
            }

            // 答え
            if (dp[N][W]) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
