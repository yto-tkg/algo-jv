import java.util.*;

public class Code72 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 入力
        int N = sc.nextInt();
        List<Point> red = new ArrayList<>(N);
        List<Point> blue = new ArrayList<>(N);
        for (int i = 0; i < N; ++i) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            red.add(new Point(x, y));
        }
        for (int i = 0; i < N; ++i) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            blue.add(new Point(x, y));
        }

        // 青い点を x 座標が小さい順にソートする (デフォルトで第一引数の辞書順比較)
        Collections.sort(blue);

        // 各赤い点が使用済みかどうか
        boolean[] used = new boolean[N];

        // 青い点を順番に見ていく
        int res = 0;
        for (int i = 0; i < N; ++i) {
            // 使用済みでなく、y 座標最大の赤い点を探す
            int maxy = -1, maxid = -1;
            for (int j = 0; j < N; ++j) {
                // 使用済みの赤い点は不可
                if (used[j]) continue;

                // x 座標, y 座標がより大きい赤い点は不可
                if (red.get(j).x >= blue.get(i).x) continue;
                if (red.get(j).y >= blue.get(i).y) continue;

                // 最大値を更新
                if (maxy < red.get(j).y) {
                    maxy = red.get(j).y;
                    maxid = j;
                }
            }

            // 存在しない場合はスキップ
            if (maxid == -1) continue;

            // ペアリングする
            ++res;
            used[maxid] = true;
        }
        System.out.println(res);
    }

    // 二次元座標を定義
    static class Point implements Comparable<Point> {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            return Integer.compare(x, o.x);
        }
    }
}
