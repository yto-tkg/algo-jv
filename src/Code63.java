import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Code63 {
    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            long M = sc.nextLong();
            List<Long> P = new ArrayList<>();
            for (int i = 0; i < N; ++i) {
                P.add(sc.nextLong());
            }
            P.add(0L);
            List<Long> S = new ArrayList<>();
            for (int i = 0; i < P.size(); ++i) {
                for (int j = 0; j < P.size(); ++j) {
                    S.add(P.get(i) + P.get(j));
                }
            }
            Collections.sort(S);

            long res = 0;
            for (long a : S) {
                int index = Collections.binarySearch(S, M - a);
                if (index < 0) {
                    index = -index - 2;
                }
                if (index < 0) {
                    continue;
                }
                long b = S.get(index);
                res = Math.max(res, a + b);
            }
            System.out.println(res);
        }
    }
}
