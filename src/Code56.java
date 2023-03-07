import java.util.Arrays;
import java.util.Scanner;

public class Code56 {
    public class Main {
        public static void main(String[] args) {
            // 入力
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            int W = sc.nextInt();
            int[] a = new int[N];
            int[] m = new int[N];
            for (int i = 0; i < N; ++i) {
                a[i] = sc.nextInt();
                m[i] = sc.nextInt();
            }

            // DP
            int INF = 1 << 29;
            int[][] dp = new int[N+1][W+1];

            // 初期条件
            for (int[] row : dp) {
                Arrays.fill(row, INF);
            }
            dp[0][0] = 0;

            // ループ
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j <= W; ++j) {
                    // i 個ですでに j が作れる場合
                    if (dp[i][j] < INF) {
                        dp[i+1][j] = Math.min(dp[i+1][j], 0);
                    }

                    // i+1 個で m[i] 個未満で j-a[i] が作れるなら j も作れる
                    if (j >= a[i] && dp[i+1][j-a[i]] < m[i]) {
                        dp[i+1][j] = Math.min(dp[i+1][j], dp[i+1][j-a[i]]+1);
                    }
                }
            }

            // 答え
            if (dp[N][W] < INF) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
