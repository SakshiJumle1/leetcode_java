class Solution {
    public long gridGame(int[][] grid) {
int n = grid[0].length;

        // Prefix sums for the top and bottom rows
        long[] prefixTop = new long[n];
        long[] prefixBottom = new long[n];

        // Fill prefix sums for the top row
        prefixTop[0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            prefixTop[i] = prefixTop[i - 1] + grid[0][i];
        }

        // Fill prefix sums for the bottom row
        prefixBottom[0] = grid[1][0];
        for (int i = 1; i < n; i++) {
            prefixBottom[i] = prefixBottom[i - 1] + grid[1][i];
        }

        long result = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            // Points remaining in the top row after the first robot moves down at column i
            long pointsTop = prefixTop[n - 1] - prefixTop[i];

            // Points collected in the bottom row before the first robot moves down at column i
            long pointsBottom = (i > 0) ? prefixBottom[i - 1] : 0;

            // The second robot's maximum possible score if the first robot goes down at column i
            long secondRobotScore = Math.max(pointsTop, pointsBottom);

            // Minimize the maximum points the second robot can collect
            result = Math.min(result, secondRobotScore);
        }

        return result;
    }
}
