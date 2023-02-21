public class SplitArrayLargestSum {
    public static int splitArray(int[] nums, int m) {
        int max = 0, sum = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }
        if (m == 1) {
            return sum;
        }
        int left = max, right = sum;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canSplit(nums, m, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    private static boolean canSplit(int[] nums, int m, int target) {
        int count = 1, sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum > target) {
                count++;
                sum = num;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        int m = 2;
        int result = splitArray(nums, m);
        System.out.println(result); // Output: 18
    }
    
    

}
