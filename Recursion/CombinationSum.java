import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    /*
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        // Create a list to store the result
        List<List<Integer>> res = new ArrayList<>();
        
        // Sort the candidates array to ensure that we only generate unique combinations
        Arrays.sort(candidates);
        
        // Call the recursive helper function with initial parameters
        backtrack(candidates, target, 0, new ArrayList<Integer>(), res);
        
        // Return the result
        return res;
    }
    
    private static void backtrack(int[] candidates, int target, int start, List<Integer> path, List<List<Integer>> res) {
        // Base case: if the target is reached, add the current path to the result
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        
        // Loop through the candidates starting from the "start" index
        for (int i = start; i < candidates.length; i++) {
            // If the current candidate is greater than the target, break out of the loop
            if (candidates[i] > target) {
                break;
            }
            
            // Add the current candidate to the path
            path.add(candidates[i]);
            
            // Call the backtrack function recursively with the updated target and start index
            backtrack(candidates, target - candidates[i], i, path, res);
            
            // Remove the last element from the path to backtrack
            path.remove(path.size() - 1);
        }
    }
    */

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>ans=new ArrayList<>();
        solve(0,candidates,target,ans,new ArrayList<>());
        return ans;
    }
    public static void solve(int ind,int[]candidates,int target,List<List<Integer>>ans,ArrayList<Integer>temp){
        if(ind==candidates.length){
            if(target==0){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }

        if(candidates[ind]<=target){
            temp.add(candidates[ind]);
            solve(ind,candidates,target-candidates[ind],ans,temp);
            temp.remove(temp.size()-1);
        }
        solve(ind+1,candidates,target,ans,temp);

    }
    
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> res = combinationSum(candidates, target);
        System.out.println(res);
    }
}
