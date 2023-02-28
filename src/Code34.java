public class Code34 {
    public static void main(String[] args) {

        int[] nums = new int[]{1,2,3,4,6,7,9};

        // 線形探索
        int max = 0;
        int min = 999;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        System.out.println(max - min);
    }
}
