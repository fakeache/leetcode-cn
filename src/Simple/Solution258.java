package Simple;

public class Solution258 {
    public static int addDigits(int num) {
        if (num == 0) {
            return 0;
        }
        int s = num % 9;
        if (s == 0) {
            return 9;
        }
        return s;
    }

    public static void main(String[] args){
        int n = 38;
        System.out.println(addDigits(n));
    }
}
