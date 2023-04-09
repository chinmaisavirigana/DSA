/*class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        
  LinkedList<Integer> deq = new LinkedList();
  deq.add(-1);
  int res = 0;
  for (int i = 0; i < nums.length; ++i) {
    if (nums[i] % 2 == 1) 
        deq.add(i);
    if (deq.size() > k + 1) 
        deq.pop();
    if (deq.size() == k + 1) 
        res += deq.get(1) - deq.get(0);
  }
  return res;
}
    }
*/
class Solution{
        public int numberOfSubarrays(int[] A, int k) {
        return atMost(A, k) - atMost(A, k - 1);
    }

    public int atMost(int[] A, int k) {
        int res = 0, i = 0, n = A.length;
        for (int j = 0; j < n; j++) {
            k -= A[j] % 2;
            while (k < 0)
                k += A[i++] % 2;
            res += j - i + 1;
        }
        return res;
    }

}
