package Middle;

class Solution151 {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        while (i >= 0) {
            if (arr[i] == ' ') {
                i--;
                continue;
            }
            StringBuilder sbs = new StringBuilder();
            while (i >= 0 && arr[i] != ' ') {
                sbs.insert(0, String.valueOf(arr[i]));
                i--;
            }
            sbs.append(" ");
            sb.append(sbs.toString());
        }
        String temp = sb.toString();
        if (temp.length() == 0) {
            return temp;
        } else {
            return temp.substring(0, temp.length() - 1);
        }
    }
}
