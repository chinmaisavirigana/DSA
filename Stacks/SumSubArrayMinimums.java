import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int sumSubarrayMins(int[] arr) {
	    Deque<Integer> stack = new ArrayDeque<>();
        
        // left bound we set of -1
        stack.push(-1);
        long res = 0;
        for(int i = 0; i < arr.length; i++) {
            while(stack.size() > 1 && arr[stack.peek()] > arr[i]) {
                int currElemIndex = stack.pop();
                /* Note that after the above line, stack.peek() will give us the index of left next smallest element.
                   We monotonically order the stack always in an increasing order at all the times, because of that this
                   argument holds true.
                   'i' will be the next right smallest element index. (The while loop condition is designed such way).
                */
                res += ((long) arr[currElemIndex] * (currElemIndex - stack.peek()) * ( i - currElemIndex)) % 1000000007;
                res = res % 1000000007;
            }
            stack.push(i);
        }
    
        // right bound we set to array length;
        int rightBoundary = arr.length;
    
        while(stack.size() > 1) {
            int currElemIndex = stack.pop();
            res += ((long) arr[currElemIndex] * (currElemIndex - stack.peek()) * (rightBoundary - currElemIndex)) % 1000000007;
            res = res % 1000000007;
        }
        
        return (int) res;
        
    }
}