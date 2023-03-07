import java.util.Arrays;
import java.util.Scanner;

public class Code57 {
    public class Main {
        static <T extends Comparable<T>> void chmax(Integer a, int b) {
            if (a.compareTo(b) < 0) a = b;
        }

        public static void main(String[] args) {
            // 入力
            Scanner sc = new Scanner(System.in);
            String S = sc.next();
            String T = sc.next();
            int N = S.length(), M = T.length();

            // DP テーブル
            Integer[][] dp = new Integer[N+1][M+1];
            for (Integer[] row : dp) {
                Arrays.fill(row, 0);
            }

            // ループ
            for (int i = 0; i <= N; ++i) {
                for (int j = 0; j <= M; ++j) {
                    // S の i 文字目と、T の j 文字目が等しいとき
                    if (i > 0 && j > 0) {
                        if (S.charAt(i-1) == T.charAt(j-1)) {
                            chmax(dp[i][j], dp[i-1][j-1] + 1);
                        } else {
                            chmax(dp[i][j], dp[i-1][j-1]);
                        }
                    }

                    // S に 1 文字追加
                    if (i > 0) {
                        chmax(dp[i][j], dp[i-1][j]);
                    }

                    // T に 1 文字追加
                    if (j > 0) {
                        chmax(dp[i][j], dp[i][j-1]);
                    }
                }
            }

            // LCS
            System.out.println(dp[N][M]);
        }
    }
}
