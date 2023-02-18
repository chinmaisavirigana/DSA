//import java.util.Arrays;

public class MinimumInRotatedSortedArray {
    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;

            // check if the right half of the array is sorted
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else { // the left half of the array is sorted
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2}; // rotated sorted array
        int min = findMin(arr); // call the findMin() function
        System.out.println("The minimum element in the array is " + min);
    }
}
