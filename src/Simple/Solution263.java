package Simple;

public class Solution263 {
    public static boolean isUgly(int num) {
        if (num < 1) {
            return false;
        }
        int t = num;
        while (t % 2 == 0) {
            t = t / 2;
        }
        while (t % 3 == 0) {
            t = t / 3;
        }
        while (t % 5 == 0) {
            t = t / 5;
        }
        return t == 1;
    }

    public static void main(String[] args){
        int n = 150;
        System.out.println(isUgly(n));
    }
}