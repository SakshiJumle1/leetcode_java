class Solution {
    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 != 0) return false;

        int n = s.length();
        int balance = 0;

        // First pass: Check if we can balance from left to right
        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '1' && s.charAt(i) == ')') {
                balance--;
            } else {
                balance++;
            }
            if (balance < 0) return false;
        }

        balance = 0;

        // Second pass: Check if we can balance from right to left
        for (int i = n - 1; i >= 0; i--) {
            if (locked.charAt(i) == '1' && s.charAt(i) == '(') {
                balance--;
            } else {
                balance++;
            }
            if (balance < 0) return false;
        }

        return true;
    
    }
}
