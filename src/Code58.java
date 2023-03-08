import java.util.Arrays;
import java.util.Scanner;

public class Code58 {
    public class Main {
        static final long INF = 1L << 60;

        static void solve() {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            int M = sc.nextInt();
            long[] a = new long[N];
            for (int i = 0; i < N; ++i) {
                a[i] = sc.nextLong();
            }

            // 区間 [j, i) の平均値を前処理で求める
            double[][] f = new double[N + 1][N + 1];
            for (int i = 1; i <= N; ++i) {
                for (int j = 0; j < i; ++j) {
                    double sum = 0;
                    for (int k = j; k < i; ++k) {
                        sum += a[k];
                    }
                    f[j][i] = sum / (i - j);
                }
            }

            // DP
            double[][] dp = new double[N + 1][M + 1];
            for (int i = 0; i <= N; ++i) {
                Arrays.fill(dp[i], -INF);
            }
            dp[0][0] = 0;
            for (int i = 0; i <= N; ++i) {
                for (int j = 0; j < i; ++j) {
                    for (int k = 1; k <= M; ++k) {
                        chmax(dp[i][k], dp[j][k - 1] + f[j][i]);
                    }
                }
            }
            double res = -INF;
            for (int m = 0; m <= M; ++m) {
                chmax(res, dp[N][m]);
            }
            System.out.println(String.format("%.10f", res));
        }

        static <T extends Comparable<T>> boolean chmax(T[] a, int i, T v) {
            if (a[i].compareTo(v) < 0) {
                a[i] = v;
                return true;
            } else {
                return false;
            }
        }

        public static void main(String[] args) {
            solve();
        }
    }
}
