package Simple;

public class Solution383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] magaArr = new int[26];
        if (magazine != null) {
            for (char c : magazine.toCharArray()) {
                magaArr[c - 'a']++;
            }
        }
        if (ransomNote != null) {
            for (char r : ransomNote.toCharArray()) {
                if (magaArr[r - 'a'] == 0) {
                    return false;
                }
                magaArr[r - 'a']--;
            }
        }
        return true;
    }
}
