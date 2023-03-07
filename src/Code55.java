import java.util.Arrays;
import java.util.Scanner;

public class Code55 {
    public class Main {
        static void chmax(int[] a, int b) { if (a[0] < b) a[0] = b; }
        static void chmin(int[] a, int b) { if (a[0] > b) a[0] = b; }

        public static void main(String[] args) {
            // 入力
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            int W = sc.nextInt();
            int[] a = new int[N];
            for (int i = 0; i < N; ++i) a[i] = sc.nextInt();

            // DP テーブル
            boolean[][] dp = new boolean[N+1][W+1];

            // 初期条件
            dp[0][0] = true;

            // ループ
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j <= W; ++j) {
                    if (dp[i][j]) dp[i+1][j] = true;
                    if (j >= a[i] && dp[i+1][j-a[i]]) dp[i+1][j] = true;
                }
            }

            // 答え
            if (dp[N][W]) System.out.println("Yes");
            else System.out.println("No");

            sc.close();
        }
    }
}
