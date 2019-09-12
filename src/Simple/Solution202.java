package Simple;

public class Solution202 {

    public static int calSum(int n) {
        int sum = 0;
        while (n != 0){
            int temp = n % 10;
            sum += temp * temp;
            n = n / 10;
        }
        return sum;
    }
    public static boolean isHappy(int n) {
        int slow = calSum(n);
        int fast = calSum(slow);
        while (true){
            if (slow == 1 || fast == 1) {
                return true;
            }
            slow = calSum(slow);
            fast = calSum(calSum(fast));
            if (slow == fast) {
                return false;
            }
        }
    }
    public static void main(String[] args){
        int n = 19;
        System.out.println(isHappy(n));
    }
}