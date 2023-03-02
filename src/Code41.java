public class Code41 {
    public static void main(String[] args) {
        System.out.println(func(6));
    }

    public static int func(int N) {
        if (N == 0) {
            return 0;
        } else if (N == 1) {
            return 0;
        } else if (N == 2) {
            return 1;
        }

        return func(N - 1) + (N - 2) + (N - 3);
    }
}
