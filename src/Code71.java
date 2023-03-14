import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class Code71 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 入力
        int N = sc.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];
        for (int i = 0; i < N; ++i) A[i] = sc.nextInt();
        for (int i = 0; i < N; ++i) B[i] = sc.nextInt();

        // それぞれソートする
        Arrays.sort(A);
        Arrays.sort(B);

        // B を順に見ていく
        int i = 0;
        for (int j = 0; j < N; ++j) {
            if (A[i] < B[j]) ++i;
        }

        // i が答え
        System.out.println(i);
    }
}
