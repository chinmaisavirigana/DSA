import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); 
        List<List<Integer>> ans = new ArrayList<>(); 
        findSubsets(0, nums, new ArrayList<>(), ans); 
        return ans; 
    }
    public static void findSubsets(int index, int[] nums, List<Integer> ds, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(ds)); 
        for(int i = index;i<nums.length;i++) {
            if(i!=index && nums[i] == nums[i-1]) continue; 
            ds.add(nums[i]); 
            findSubsets(i+1, nums, ds, ans); 
            ds.remove(ds.size() - 1);
        }
        
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = subsetsWithDup(nums);
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }
}