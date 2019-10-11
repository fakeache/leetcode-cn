package Simple;

public class Solution299 {
    public static String getHint(String secret, String guess) {
        int a = 0;
        int b = 0;
        int[] x = new int[10];
        int[] y = new int[10];
        int len1 = secret.length();
        int len2 = secret.length();
        if (len1 > len2) {
            for (int i = len2; i < len1; i++) {
                char m = secret.charAt(i);
                x[m - '0']++;
            }
        } else if (len2 > len1) {
            for (int i = len1; i < len2; i++) {
                char n = guess.charAt(i);
                y[n - '0']++;
            }
        } else {
            for (int i = 0; i < len1; i++) {
                char m = secret.charAt(i);
                char n = guess.charAt(i);
                x[m - '0']++;
                y[n - '0']++;
                if (m == n) {
                    a++;
                }
            }
        }
        for (int i = 0; i <= 9; i++) {
            int min = Math.min(x[i], y[i]);
            b += min;
        }
        b -= a;
        return a + "A" + b + "B";
    }

    public static void main(String[] args){
        String secret = "9704";
        String guess = "9407";
        System.out.println(getHint(secret, guess));
    }
}