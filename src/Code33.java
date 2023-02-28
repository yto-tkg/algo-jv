public class Code33 {
    public static void main(String[] args) {

        int[] nums = new int[]{1,2,3,4,6,7,9};

        // 線形探索
        int min = 999999999;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }

        System.out.println(min);
    }
}
