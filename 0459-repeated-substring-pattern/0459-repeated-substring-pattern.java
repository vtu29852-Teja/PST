class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String doubled = s + s;
        // Search for s in doubled, excluding the very first and last characters
        return doubled.substring(1, doubled.length() - 1).contains(s);
    }
}