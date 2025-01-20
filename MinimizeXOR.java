class Solution {
    public int minimizeXor(int num1, int num2) {
        // Function to count the number of set bits
        int count = Integer.bitCount(num2); 

        int res = 0;

        // Process bits from MSB to LSB
        for (int i = 31; i >= 0 && count > 0; i--) {
            if ((num1 & (1 << i)) != 0) {
                count--;
                res |= (1 << i);
            }
        }

        // Set additional bits from LSB to satisfy count
        for (int i = 0; i < 32 && count > 0; i++) {
            if ((num1 & (1 << i)) == 0) {
                count--;
                res |= (1 << i);
            }
        }

        return res;
    }
}
