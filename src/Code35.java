public class Code35 {
    public static void main(String[] args) {

        int[] nums = new int[]{8, 12, 40};

        // 線形探索
        int min = 999999;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int count = 0;
            while (num % 2 == 0) {
                count++;
                num = num / 2;
            }
            min = Math.min(min, count);
        }

        System.out.println(min);
    }
}
