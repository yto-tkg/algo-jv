import java.util.*;

public class Code62 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 入力
        int N = sc.nextInt();
        List<Long> a = new ArrayList<>();
        List<Long> b = new ArrayList<>();
        List<Long> c = new ArrayList<>();
        for (int i = 0; i < N; ++i) a.add(sc.nextLong());
        for (int i = 0; i < N; ++i) b.add(sc.nextLong());
        for (int i = 0; i < N; ++i) c.add(sc.nextLong());

        // ソートする
        Collections.sort(a);
        Collections.sort(b);
        Collections.sort(c);

        // b[j] を固定して考える
        long res = 0;
        for (int j = 0; j < N; ++j) {
            int Aj = Collections.binarySearch(a, b.get(j));
            if (Aj < 0) Aj = -(Aj + 1); // 二分探索の仕様により
            int Cj = N - (Collections.binarySearch(c, b.get(j)) + 1);
            res += Aj * Cj;
        }
        System.out.println(res);
    }
}
