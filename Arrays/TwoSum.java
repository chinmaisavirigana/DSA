import java.util.HashMap;
import java.util.Map;

class TwoSum{
    public static void main(String[] args) {
        int arr[] = {3,2,4,6};
        int target = 6;
        twoSum(arr,target);


    }   
    static public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        Map<Integer,Integer> map=new HashMap<>();
        int[] result=new int[2];
        for(int i=0;i<n;i++){
            if(map.containsKey(target-nums[i])){
                result[1]=i;
                result[0]=map.get(target-nums[i]);
                return result;
            }
            map.put(nums[i],i);
        }
        return result;
    }

}