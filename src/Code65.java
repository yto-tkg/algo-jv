import java.util.*;
import java.util.function.Predicate;

public class Code65 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long K = sc.nextLong();
        long[] a = new long[(int) N];
        long[] b = new long[(int) N];
        for (int i = 0; i < N; ++i) {
            a[i] = sc.nextLong();
        }
        for (int i = 0; i < N; ++i) {
            b[i] = sc.nextLong();
        }

        // b はあらかじめソートしておく
        Arrays.sort(b);

        // 判定問題
        Predicate<Long> check = x -> {
            long cnt = 0;
            for (int i = 0; i < N; ++i) {
                cnt += upperBound(b, x / a[i]) - 0;
            }
            return (cnt >= K);
        };

        // 二分探索 (right は十分大きな値に設定)
        long left = 0, right = 1L << 60;
        while (right - left > 1) {
            long mid = (left + right) / 2;
            if (check.test(mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        System.out.println(right);
    }

    // upper_bound と同じ動作をするメソッド
    static int upperBound(long[] a, long value) {
        int left = 0, right = a.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (a[mid] <= value) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
