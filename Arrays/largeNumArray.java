package Arrays;

class largeNumArray{
    static void largestElementArray(int arr[]){
            int max = arr[0];
            for(int i=1;i<arr.length;i++){
                if(arr[i] > max){
                    max=arr[i];
                }
            }
            System.out.println(max);
            }
    
    public static void main(String[] args){
        int arr [] = {5,10,15,20};
        int arr1[] = {10,20,30,40};

        largestElementArray(arr);
        largestElementArray(arr1);
        
    }
}
