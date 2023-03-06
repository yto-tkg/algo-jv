import java.util.Arrays;
import java.util.Scanner;

public class Code54 {
    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            int K = sc.nextInt();
            int W = sc.nextInt();
            int[] a = new int[N];
            for (int i = 0; i < N; ++i) a[i] = sc.nextInt();

            // 配列 dp
            int INF = 1 << 29;
            int[][] dp = new int[N+1][W+1];
            for (int i = 0; i <= N; i++) Arrays.fill(dp[i], INF);

            // 初期条件
            dp[0][0] = 0;

            // ループ
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j <= W; ++j) {
                    // a[i] を選ばない場合
                    chmin(dp[i+1][j], dp[i][j]);

                    // a[i] を選ぶ場合
                    if (j >= a[i]) chmin(dp[i+1][j], dp[i][j-a[i]] + 1);
                }
            }

            // 最小値が K 以下ならば、Yes
            if (dp[N][W] <= K) System.out.println("Yes");
            else System.out.println("No");
        }

        // chmin関数
        public static <T extends Comparable<T>> void chmin(T[] a, T b) {
            if (a[0].compareTo(b) > 0) a[0] = b;
        }

        public static void chmin(int[] a, int b) {
            if (a[0] > b) a[0] = b;
        }
    }
}
