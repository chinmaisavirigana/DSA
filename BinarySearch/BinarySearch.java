class BinarySearch{
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8};
        int target = 8;
        int ans = binarySearch(arr,target);
        System.out.println(ans);
    }
    static int binarySearch(int[] arr, int target){
        int lo = 0, hi = arr.length -1;
        int mid;
        while(lo<=hi){
            mid = (hi - lo)/2 + lo;
            if(target == arr[mid]) return mid;
            else if(target > mid) lo = mid + 1;
            else { hi = mid - 1; }
        }
        return -1;
    }
}
