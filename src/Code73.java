import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Code73 {
    public void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 入力
        int N = sc.nextInt();
        List<Pair<Long, Long>> v = new ArrayList<>();
        for (int i = 0; i < N; ++i) v.add(new Pair<Long, Long>(sc.nextLong(), sc.nextLong()));

        // 締め切りが早い順にソート
        Collections.sort(v, (a, b) -> a.second.compareTo(b.second));

        // 締め切りが早い順に仕事をこなしていく
        boolean ok = true;
        long time = 0;
        for (int i = 0; i < N; ++i) {
            time += v.get(i).first;
            if (time > v.get(i).second) ok = false;
        }

        // 出力
        if (ok) System.out.println("Yes");
        else System.out.println("No");
    }

    class Pair<F, S> {
        public final F first;
        public final S second;

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }
}
