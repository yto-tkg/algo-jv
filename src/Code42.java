import java.util.List;

public class Code42 {
    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            memo.add(-1L);
        }
        System.out.println(func(6));
    }

    private static List<Long> memo;
    public static long func(int N) {
        if (N == 0) {
            return 0;
        } else if (N == 1) {
            return 0;
        } else if (N == 2) {
            return 1;
        }

        if (memo.get(N) != -1) {
            return memo.get(N);
        }

        return memo.set(N, func(N - 1) + (N - 2) + (N - 3));
    }
}
