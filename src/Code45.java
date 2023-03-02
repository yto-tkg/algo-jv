import java.util.List;
import java.util.Scanner;

public class Code45 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long N = scanner.nextLong();
        long[] counter = new long[1];
        func(N, 0, 0, counter);
        System.out.println(counter[0]);
    }

    public static void func(long N, long cur, int use, long[] counter) {
        if (cur > N) return; // ベースケース
        if (use == 0b111) ++counter[0]; // 答えを増やす

        // 7 を付け加える
        func(N, cur * 10 + 7, use | 0b001, counter);

        // 5 を付け加える
        func(N, cur * 10 + 5, use | 0b010, counter);

        // 3 を付け加える
        func(N, cur * 10 + 3, use | 0b100, counter);
    }
}
