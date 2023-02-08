import java.util.ArrayList;
import java.util.HashMap;

public class UnionArray {
    static ArrayList<Integer> findUnion(int[] arr1, int[] arr2){
        HashMap<Integer, Integer> freq = new HashMap<>();
        ArrayList<Integer> union = new ArrayList<>();
        for(int i=0;i<arr1.length;i++){
            freq.put(arr1[i],freq.getOrDefault(arr1[i],0)+1);
        }
        for(int i=0;i<arr2.length;i++){
            freq.put(arr2[i],freq.getOrDefault(arr2[i],0)+1);
        }

        for(int it:freq.keySet()){
            union.add(it);
        }
        return union;
    }

    public static void main(String[] args){
        int arr1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int arr2[] = {2, 3, 4, 4, 5, 11, 12};
        ArrayList<Integer> ans = findUnion(arr1, arr2);
        System.out.print(ans);
    }
}
