class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;
        int xorSum = 0;
        for (int value : derived) {
            xorSum ^= value;
        }
        return xorSum == 0;
    }
}
