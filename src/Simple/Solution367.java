package Simple;

public class Solution367 {
    //数学公式求平方数： 1+3+5+7+...(2N−1)=n^2
    public static boolean isPerfectSquare(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }
    //牛顿法求平方数
    public static boolean isPerfectSquare1(int num) {
        if (num == 1) {
            return true;
        }
        int x = 2;
        int y = num / x;
        while (y > num / y) {
            y = (y + num / y) / 2;
        }
        return y * y == num;
    }

    public static void main(String[] args){
        int n = 1210000;
        System.out.println(isPerfectSquare(n));
        System.out.println(isPerfectSquare1(n));
    }
}
