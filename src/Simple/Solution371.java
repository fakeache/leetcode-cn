package Simple;

public class Solution371 {
    public static int getSum(int a, int b) {
        int rs = 0;
        while (b != 0) {
            rs = a ^ b;
            b = (a & b) << 1;
            a = rs;
        }
        return rs;
    }

    public static void main(String[] args){
        int a = 2125555;
        int b = 1210000;
        System.out.println(getSum(a, b));
    }
}