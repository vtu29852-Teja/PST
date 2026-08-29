import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (matches(word, pattern)) {
                result.add(word);
            }
        }
        return result;
    }

    private boolean matches(String word, String pattern) {
        int[] pToW = new int[256];
        int[] wToP = new int[256];

        for (int i = 0; i < pattern.length(); i++) {
            char pChar = pattern.charAt(i);
            char wChar = word.charAt(i);

            if (pToW[pChar] == 0 && wToP[wChar] == 0) {
                pToW[pChar] = wChar;
                wToP[wChar] = pChar;
            } else if (pToW[pChar] != wChar || wToP[wChar] != pChar) {
                return false;
            }
        }
        return true;
    }
}