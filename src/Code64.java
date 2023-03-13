import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Code64 {
    public static void main(String[] args) {
        // 入力
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        List<Long> a = new ArrayList<>();
        for (int i = 0; i < N; ++i) a.add(sc.nextLong());
        Collections.sort(a);

        // 「すべての間隔を x 以上にして M 個の小屋を選べるか？」という判定問題を解く
        // Yes であるような最大の x を求める
        long INF = (1L << 50);
        long left = 0, right = INF;
        while (right - left > 1) {
            long x = (left + right) / 2;

            int cnt = 1; // 何個の小屋が取れたか (最初の小屋は選ぶ)
            int prev = 0; // 前回の小屋の index
            for (int i = 0; i < N; ++i) {
                // x 以上の間隔が空いたら採用する
                if (a.get(i) - a.get(prev) >= x) {
                    ++cnt;
                    prev = i;
                }
            }

            // 判定問題が Yes か No か
            if (cnt >= M) left = x;
            else right = x;
        }
        System.out.println(left);
    }
}
