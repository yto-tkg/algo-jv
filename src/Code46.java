import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Code46 {
    // func(i, w, a) の答えをメモ化する配列
    static int[][] memo;

    // 0：false、1: true
    static int func(int i, int w, final List<Integer> a) {
        // ベースケース
        if (i == 0) {
            if (w == 0) {
                return 1;
            }
            else return 0;
        }

        // メモをチェック (すでに計算済みならば答えをリターンする)
        if (memo[i][w] != -1) return memo[i][w];

        // a[i - 1] を選ばない場合
        if (func(i - 1, w, a) == 1) {
            return memo[i][w] = 1;
        }

        // a[i - 1] を選ぶ場合
        if (func(i - 1, w - a.get(i - 1), a) == 1) {
            return memo[i][w] = 1;
        }

        // どちらも false の場合は false
        return memo[i][w] = 0;
    }

    public static void main(String[] args) {
        // 入力
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int W = sc.nextInt();
        List<Integer> a = new ArrayList<Integer>();
        for (int i = 0; i < N; ++i) a.add(sc.nextInt());

        // 再帰的に解く
        memo = new int[N+1][W+1];
        for (int[] row : memo) Arrays.fill(row, -1);
        if (func(N, W, a) == 1) System.out.println("Yes");
        else System.out.println("No");
    }
}
