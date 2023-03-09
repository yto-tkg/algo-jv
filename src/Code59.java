import java.util.Arrays;
import java.util.Scanner;

public class Code59 {
    public class Main {
        static long INF = 1L << 60;

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            // 入力
            int N = sc.nextInt();
            long[] a = new long[N];
            for (int i = 0; i < N; i++) {
                a[i] = sc.nextLong();
            }

            // 累積和をとる
            long[] S = new long[N + 1];
            for (int i = 0; i < N; i++) {
                S[i + 1] = S[i] + a[i];
            }

            // DP
            long[][] dp = new long[N + 1][N + 1];
            for (int i = 0; i <= N; i++) {
                Arrays.fill(dp[i], INF);
            }

            // 初期条件
            for (int i = 0; i < N; i++) {
                dp[i][i + 1] = 0;
            }

            // 更新
            // ここで、kは区間[i,j)の中間点を表しており、i < k < jという条件が成立
            for (int bet = 2; bet <= N; bet++) {
                for (int i = 0; i + bet <= N; i++) {
                    int j = i + bet;

                    // dp[i][j] を更新する
                    for (int k = i + 1; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + S[j] - S[i]);
                    }
                }
            }

            System.out.println(dp[0][N]);
        }
    }
}
