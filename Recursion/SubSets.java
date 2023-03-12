import java.util.ArrayList;
import java.util.List;

public class SubSets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }
    
    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        result.add(new ArrayList<>(tempList)); // Add current subset to result
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]); // Add current element to subset
            backtrack(result, tempList, nums, i + 1); // Recursively generate next subset
            tempList.remove(tempList.size() - 1); // Remove current element from subset to backtrack
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = subsets(nums);
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }



}
