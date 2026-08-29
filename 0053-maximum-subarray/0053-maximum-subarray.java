class Solution {
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int currentSum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            // Either add current number to running subarray sum, 
            // or start a new subarray from the current number
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            
            // Track the global maximum sum found so far
            maxSoFar = Math.max(maxSoFar, currentSum);
        }
        
        return maxSoFar;
    }
}