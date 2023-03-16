import java.util.*;

public class Code93 {
    public class Main {
        static boolean check(String S) {
            Stack<Integer> st = new Stack<>(); // 左括弧の index を格納するスタック
            List<Pair<Integer,Integer>> ps = new ArrayList<>(); // 対応を表すペア

            // ループを回す
            for (int i = 0; i < S.length(); ++i) {
                if (S.charAt(i) == '(') st.push(i);
                else {
                    if (st.empty()) {
                        System.out.println("error");
                        return false;
                    }
                    int t = st.pop();
                    ps.add(new Pair<>(t, i));
                }
            }

            // スタックが空でなかったら左括弧が過剰
            if (!st.empty()) {
                System.out.println("too many (");
                return false;
            }

            // 整合を出力
            Collections.sort(ps, new Comparator<Pair<Integer,Integer>>() {
                @Override
                public int compare(Pair<Integer,Integer> p1, Pair<Integer,Integer> p2) {
                    return p1.getKey().compareTo(p2.getKey());
                }
            });
            for (int i = 0; i < ps.size(); ++i) {
                if (i != 0) System.out.print(", ");
                System.out.printf("(%d, %d)", ps.get(i).getKey(), ps.get(i).getValue());
            }
            System.out.println();
            return true;
        }

        public static void main(String[] args) {
            check("((()())())"); // (0, 9) (1, 6), (2, 3), (4, 5), (7, 8)
            check("())"); // error
            check("(()"); // too many (
        }
    }
}
