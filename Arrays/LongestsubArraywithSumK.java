class LongestsubArraywithSumK{
    public static void main(String[] args) {
        int arr[] = {7,1,6,0};
        int k=7;
        System.out.println("k = "+longestSubArray(arr, k));
        
    }
    public static int longestSubArray(int arr[],int k){
        int start = 0, end = -1, sum = 0, maxLen = 0;
        while(start<arr.length){
            while((end+1<arr.length) && (sum + arr[end+1] <= k)){
                sum +=arr[++end];
            
            if(sum==k){
                maxLen = Math.max(maxLen,(end-start+1));
            }
            sum-=arr[start];
            start++;
            }
            
        }

        return maxLen;
    }

}