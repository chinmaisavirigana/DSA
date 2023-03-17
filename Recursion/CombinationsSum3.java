import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>(); // initialize the result list
        backtrack(res, new ArrayList<>(), k, n, 1); // call the backtrack function
        return res; // return the result list
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> tempList, int k, int remain, int start) {
        if (tempList.size() == k && remain == 0) { // if the list size equals k and the remaining sum equals 0
            res.add(new ArrayList<>(tempList)); // add the list to the result list
        } else {
            for (int i = start; i <= 9 && i <= remain; i++) { // loop through numbers from start to 9, and consider only numbers less than or equal to the remaining sum
                tempList.add(i); // add the number to the list
                backtrack(res, tempList, k, remain - i, i + 1); // call the backtrack function recursively
                tempList.remove(tempList.size() - 1); // remove the number from the list
            }
        }
    }
}

public class CombinationsSum3 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int k = 3; // the number of elements in the combination
        int n = 7; // the target sum of the combination
        List<List<Integer>> res = sol.combinationSum3(k, n); // call the combinationSum3 function
        System.out.println(res); // print the result list
    }
}
