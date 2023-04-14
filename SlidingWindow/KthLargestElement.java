class Solution {
   public static boolean countElement(int mid , int number , int nums[]) {
		int count = 0;
		for(int i = 0; i < nums.length ; i++) {
			if(mid > nums[i]) {
				count++;
			}
		}
		if(count <= number) return true;
		else return false;
	}
    
    public int findKthLargest(int[] nums, int k) {
       int n = nums.length;
		int number = n-k;
		int start = Integer.MAX_VALUE;   //min element of array
		int end = Integer.MIN_VALUE;	//max element of array
		int ans = 0;
		for(int i = 0 ; i < nums.length ;i++) {
			if(nums[i] < start) start = nums[i];
			if(nums[i] > end) end = nums[i];
		}
		
		int mid = 0;
		while(start <= end) {
			mid = start + ((end-start)/2);
			
			if(countElement(mid,number,nums)) {
				ans = mid;
				start = mid+1;
				
			}else {
				end = mid - 1;
			}
		}
		return ans;
    }
} 
