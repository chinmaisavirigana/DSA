public class MoveZerosEnd {
    public static void main(String[] args){
        int[] arr = {1,2,0,1,0,4,0};
        zerosToEnd(arr);
    }

    static void zerosToEnd(int[] nums){

        //To find the first occurence of zero
        int k = 0;
        while(k<nums.length){
            if(nums[k]==0){
                break;
            }
            k = k + 1;
        }

        //Finding zero and non-zero element to Swap
        int i = k, j = k + 1;
        while(i < nums.length && j < nums.length){
            if(nums[j]!=0){
                int temp = nums[i];
                nums[i]=nums[j];
                nums[j] = temp;
            i++;
            }
            j++;
        }

        for(i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }

    }

}

