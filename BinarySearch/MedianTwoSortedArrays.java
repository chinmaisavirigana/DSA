public class MedianTwoSortedArrays {
    public static double findMedianSortedArrays(int[] a, int[] b) {
        if(a.length>b.length){
            int[] temp = a;
            a = b;
            b = temp;
        }
        int low=0,high = a.length, te = a.length+b.length;
        while(low<=high){
            int aleft = low+(high-low)/2;
            int bleft = (te+1)/2-aleft;

            int alm1 = (aleft==0) ? Integer.MIN_VALUE:a[aleft-1];
            int al = (aleft==a.length) ? Integer.MAX_VALUE:a[aleft];
            int blm1 = (bleft==0) ? Integer.MIN_VALUE:b[bleft-1];
            int bl = (bleft==b.length) ? Integer.MAX_VALUE:b[bleft];

            //valid segregation
            if(alm1 <= bl && blm1 <=al){
                double median = 0.0;
                if(te%2==0){
                    int lmax = Math.max(alm1,blm1);
                    int rmin = Math.min(al,bl);
                    median = (lmax+rmin)/2.0;
                }else{
                    int lmax = Math.max(alm1,blm1);
                    median = lmax;
                }
                  return median;
                }
                else if(alm1 > bl){
                //there are more elements to be picked in left part of 'b' array. 
                high = aleft-1;
                }
                else if(blm1 > al){
                //there are more element to be picked in left part of 'a' array.
                low = aleft+1;
                }
            }
        return 0;

        }
    public static void main(String[] Args){
        int[] a = {3,9,12,13,14};
        int[] b = {7,17,20,24,26,28,30,32};

        double median = findMedianSortedArrays(a,b);
        System.out.print(median);

    }
}
 /*
         * ex:
         * a --> [ 3,9,12,13,14,||19] - Valid segregation 
         * b --> [7,17,||20,24,26,28,30,32]
         * we took a.length instead of a.length - 1 
         *      because there are some case where you won't find valid segregation i.e., it goes beyond a.length. In other words, we need to consider infinite value Integer.MAX_VALUE
         *  
         * 
         * 
         * 
         */
