//import java.util.*;

class LeftRotateArraybyOne{
    public static void main(String[] Args){
        int n=5;
        int []arr = {1,2,3,4,5};
        resolve(arr,n);
    }  
    static void resolve(int[] arr, int n){
        int temp = arr[0];
        for(int i = 0;i < n - 1; i++){
            arr[i]=arr[i+1];
        }
        arr[n-1]=temp;

        for(int i=0;i<=arr.length-1;i++){
            System.out.print(arr[i]+" ");
        }
    
    }
}