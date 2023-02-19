public class KokoBananas {
    
    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int H = 8;
        int bananas = minEatingSpeed(piles, H);
        System.out.println(bananas);
    }
    
    public static int minEatingSpeed(int[] piles, int H) {
        int left = 1;
        int right = (int)1e9;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            int hours = 0;
            for (int pile : piles) {
                hours += (pile + mid - 1) / mid;
            }
            if (hours <= H) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
}

/*
 * class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for (int val : piles)
        {
             max = Math.max(val,max);
        }
        if(h == piles.length)
        {
            return max;
        }
        int lo = 0;
        int hi = max;
        int speed = Integer.MAX_VALUE;

        while(lo <= hi){
            int sp = lo + (hi-lo)/2;

            if(isPossible(piles,sp,h) == true){
                speed = sp;
                hi = sp - 1;
            }
            else{
                lo = sp + 1;
            }
        }
        
        return speed;
    }
    public boolean isPossible(int[] piles, int sp, int h){
        int time = 0;

        for(int i = 0; i< piles.length;i++){
            //Ceil the number
            time += (int)Math.ceil(piles[i]*1.0/sp);
        }
        return time <=h;
    }
}
 */