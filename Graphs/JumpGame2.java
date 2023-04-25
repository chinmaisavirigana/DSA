class Solution {
    public int jump(int[] nums) {

        int steps = 0, currentStop = 0, currentReach = 0, lastIndex = nums.length - 1;

        for (int i = 0; i < lastIndex; ++i) {
            currentReach = Math.max(currentReach, i + nums[i]);
            if (i == currentStop) {
                steps += 1;
                currentStop = currentReach;
                if (currentStop >= lastIndex) return steps;
            }
        }

        return steps;
    }
}
