class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int sum=0;
        for(int i=0; i< k; i++) {
            sum+= cardPoints[i];
        }
        if(n == k) {
            return sum;
        }
        int p1 = k-1;
        int p2 = n-1;
        int res = sum;
        while(p1 >= 0) {
            sum -= cardPoints[p1--];
            sum += cardPoints[p2--];
            res = Math.max(res, sum);
        }
        return res;
    }
}
