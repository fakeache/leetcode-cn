package Hard;

import java.util.LinkedList;
import java.util.List;

public class Solution68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> rs = new LinkedList<>();
        int left = 0, right = 0, len = words.length;
        while (right < len) {
            StringBuilder sb = new StringBuilder();
            int rowLength = 0;
            while (right < len && rowLength + words[right].length() <= maxWidth) {
                rowLength += words[right].length() + 1;
                right++;
            }
            if (right == len || right - left == 1) {
                for (int i = left; i < right; i++) {
                    sb.append(words[i] + " ");
                }
                sb.deleteCharAt(sb.length() - 1);
                int decre = maxWidth - sb.length();
                for (int i = 0; i < decre; i++) {
                    sb.append(" ");
                }
            } else {
                int space = maxWidth - rowLength + 1;
                int num = right - left;
                int rest = space % (num - 1);
                int one = space / (num - 1);
                for (int i = left; i < right - 1; i++) {
                    sb.append(words[i] + " ");
                    for (int j = 0; j < one; j++) {
                        sb.append(" ");
                    }
                    if (rest > 0) {
                        sb.append(" ");
                        rest--;
                    }
                }
                sb.append(words[right - 1]);
            }
            rs.add(sb.toString());
            left = right;
        }
        return rs;
    }

    public static void main(String[] args) {
        System.out.println(new Solution68().fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"}, 16));
    }
}
