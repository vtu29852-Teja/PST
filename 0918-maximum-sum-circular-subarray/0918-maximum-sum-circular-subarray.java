class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int maxSum = nums[0], currentMax = 0;
        int minSum = nums[0], currentMin = 0;

        for (int num : nums) {
            totalSum += num;

            // Standard Kadane's for Maximum Subarray
            currentMax = Math.max(num, currentMax + num);
            maxSum = Math.max(maxSum, currentMax);

            // Kadane's variant for Minimum Subarray
            currentMin = Math.min(num, currentMin + num);
            minSum = Math.min(minSum, currentMin);
        }

        // If all numbers are negative, totalSum == minSum
        if (maxSum < 0) {
            return maxSum;
        }

        return Math.max(maxSum, totalSum - minSum);
    }
}