import java.util.Scanner;

public class Code53 {
    public class Main {
        public static void main(String[] args) {
            // 入力
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            long[] a = new long[N];
            for (int i = 0; i < N; ++i) a[i] = sc.nextLong();

            // DP テーブル
            int W = 10000;
            boolean[][] dp = new boolean[N+1][W+1];
            dp[0][0] = true;

            // ループ
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j <= W; ++j) {
                    if (!dp[i][j]) continue;
                    dp[i+1][j] = true;
                    if (j+a[i] <= W) dp[i+1][(int) (j+a[i])] = true;
                }
            }

            // 答え
            int res = 0;
            for (int j = 0; j <= W; ++j) {
                if (dp[N][j]) ++res;
            }
            System.out.println(res);
        }
    }
}
