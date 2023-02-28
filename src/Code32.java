public class Code32 {
    public static void main(String[] args) {

        int[] nums = new int[]{1,2,3,4,6,3,2};
        int v = 2;

        // 線形探索
        int found_id = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == v) {
                found_id++;
            }
        }

        System.out.println(found_id);
    }
}
