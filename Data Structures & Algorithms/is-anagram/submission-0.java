class Solution {
    public boolean isAnagram(String s, String t) {
        
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        // Order both char arrays and compare
        Arrays.sort(sChar);
        Arrays.sort(tChar);

        return true ? Arrays.equals(sChar, tChar) : false;

    }
}
