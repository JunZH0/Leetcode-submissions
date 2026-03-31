class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;

        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }

            while (r > l && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }

            char lChar = s.charAt(l);
            char rChar = s.charAt(r);
            if (Character.toLowerCase(lChar) != Character.toLowerCase(rChar)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
