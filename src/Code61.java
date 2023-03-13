import java.util.Arrays;
import java.util.Scanner;

public class Code61 {
    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            // 入力
            int N = sc.nextInt();
            int[] a = new int[N];
            for (int i = 0; i < N; i++) {
                a[i] = sc.nextInt();
            }

            // a をコピーした配列を作ってソートする
            int[] b = a.clone();
            Arrays.sort(b);

            // 各 a について b の中で何番目か
            int[] res = new int[N];
            for (int i = 0; i < N; i++) {
                res[i] = Arrays.binarySearch(b, a[i]);
            }

            // 出力
            for (int i = 0; i < N; i++) {
                System.out.println(res[i]);
            }
        }
    }
}
