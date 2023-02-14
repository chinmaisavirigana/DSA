import java.util.HashMap;

class LargeSubArray0sum{
static int maxLen(int A[], int n)
    {
        // Your code here
        HashMap<Integer, Integer> mpp = new HashMap<Integer, Integer>();

        int maxi = 0;
        int sum = 0; 

        for(int i = 0;i<n;i++) {

            sum += A[i]; 

            if(sum == 0) {
                maxi = i + 1; 
            }
            else {
                if(mpp.get(sum) != null) {

                    maxi = Math.max(maxi, i - mpp.get(sum)); 
                }
                else {

                    mpp.put(sum, i); 
                }
            }
        }
        return maxi; 
    }

    public static void main(String[] args){
        int A[] = {1, 2, -2, 4, -4};
        System.out.println(maxLen(A,A.length));

    }
}