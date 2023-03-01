public class Code36 {
    public static void main(String[] args) {

        int K = 10;
        int N = 15;

        // O(K^3)
        int count = 0;
        for (int x = 0; x <= K; x++) {
            for (int y = 0; y <= K; y++) {
                for (int z = 0; z <= K; z++) {
                    if (x + y + z == N) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);


        // O(min^2)
        int min = Math.min(K, N);
        int cn = 0;
        for (int x = 0; x <= min; x++) {
            for (int y = 0; y <= min; y++) {
                int z = N - x - y;
                if (z >= 0 && z <= K) {
                    cn++;
                }
            }
        }

        System.out.println(cn);
    }
}
