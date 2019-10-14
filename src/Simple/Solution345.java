package Simple;

public class Solution345 {
    public String reverseVowels(String s) {
        if (s == null) {
            return s;
        }
        char[] array = s.toCharArray();
        int len = s.length();
        int i = 0;
        int j = len - 1;
        while (i < j) {
            while (i < j && !containsYY(array[i])) {
                i++;
            }
            while (i < j && !containsYY(array[j])) {
                j--;
            }
            if (i < j){
                char t = array[i];
                array[i] = array[j];
                array[j] = t;
                i++;
                j--;
            }
        }
        return String.valueOf(array);
    }
    public boolean containsYY (char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'e' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'E' || c == 'U');
    }
}

