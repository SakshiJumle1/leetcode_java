class Solution {
    public int maxAscendingSum(int[] nums) {
        int n = nums.length;
        int r = 1;
        int sum = nums[0];
        int maxSum = nums[0];

        while (r < n) {
            while (r < n && nums[r] > nums[r - 1]) {
                sum += nums[r];
                r++;
            }
            maxSum = Math.max(maxSum, sum);
            if (r < n) {
                sum = nums[r];
            }
            r++;
        }
        return maxSum;
    }
}
