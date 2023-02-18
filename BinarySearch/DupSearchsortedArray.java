public class DupSearchsortedArray {
   
    static boolean search(int nums[], int target) {
        int lo = 0;
        int hi = nums.length -1;
        while(lo <= hi){
           int mid = lo + (hi - lo)/2;
            if(nums[mid] == target) return true;

            if(nums[lo] == nums[mid] && nums[mid] == nums[hi]){
                hi--;
                lo++;
            }
            else if(nums[lo]<=nums[mid]){
                if(nums[lo] <= target && target < nums[mid])
                    hi = mid - 1;
                else 
                    lo = mid + 1;
            }
            else{
                if(nums[mid] < target && target<= nums[hi]) 
                    lo = mid + 1;
                else
                    hi = mid - 1;
            }
        }
        return false;
    }
    
    public static void main(String args[]) {
        int arr[] = {4,5,6,7,0,1,2,3};
        int target = 3;
        System.out.println("Number found in the array: " + search(arr, target));
    }
}

