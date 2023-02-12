import java.util.HashSet;

public class LongestSeqinArray {
    public static int LongArray(int[] nums){
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            hs.add(nums[i]);
        }
       int longStreak = 1;
        for(int num: nums){
            if(!hs.contains(num-1)){
               int currentNum = num;
               int currentStreak = 1;
            
            
                while(hs.contains(currentNum+1)){
                    currentNum+=1;
                    currentStreak+=1;
                }
                longStreak = Math.max(currentStreak, longStreak);
            }
        }
        return longStreak;

    }
    public static void main(String[] args){
        int arr[]={100,200,1,2,3,4};
        int lon = LongArray(arr);
        System.out.println("The longest consecutive sequence is " + lon);
    }
}
