import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Code51 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 入力
        int N = sc.nextInt();
        Long[][] a = new Long[N][3];
        for (int i = 0; i < N; ++i)
            for (int j = 0; j < 3; ++j)
                a[i][j] = sc.nextLong();

        // DP テーブル
        // 最初の日の状態を0にするためにN+1
        // i.e. dp[0][0]=0
        Long[][] dp = new Long[N+1][3];
        for (Long[] row : dp) Arrays.fill(row, 0L);

        // i 日目から i+1 日目へ
        for (int i = 0; i < N; ++i) {
            // i 日目の状態は j、i+1 日目の状態は k
            for (int j = 0; j < 3; ++j) {
                for (int k = 0; k < 3; ++k) {
                    // 同じ状態を弾く
                    if (j == k) continue;
                    // i日目の状態にどの状態を加算すれば幸福度が最大になるか
                    // 最大になる状態をi+1日目に加算
                    chmax(dp[i + 1], dp[i][j] + a[i][k]);
                }
            }
        }

        // 答え
        Long res = 0L;
        for (int j = 0; j < 3; ++j) {
            chmax(new Long[]{res}, dp[N][j]);
        }
        System.out.println(res);
    }

    static <T extends Comparable<T>> void chmax(T[] a, T b) {
        if (a[0].compareTo(b) < 0) a[0] = b;
    }
    static <T extends Comparable<T>> void chmin(T[] a, T b) { if (a[0].compareTo(b) > 0) a[0] = b; }
}
