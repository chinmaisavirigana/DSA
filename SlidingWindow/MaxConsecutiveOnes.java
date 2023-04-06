class Solution {
    public int longestOnes(int[] nums, int k) {
        //Three variables needed for our sliding window
        int left = 0;
        int current = 0;
        int ans = 0;
        //iterate through the length of our array to find an update
        //our longest subarray
        for(int right = 0;right<nums.length;right++){
            //if we find a 0, we update our current
            if(nums[right]==0){
                current += 1;
            }
            //if we find more than 2 0's, we need to adjust window
            while(current > k){
                if(nums[left]==0){
                    current -= 1;
                }
                left++;
            }
            //update the lenght of our subarray every iteration to
            //to find the maximum length
            ans = Math.max(ans, right-left+1);
        }
        
        return ans;
        
    }
}
