package Simple;

public class Solution191 {
    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        int sum = 0;
        int t = n;
        while(t!=0){
            sum++;
            t = t & (t-1);
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(hammingWeight(-585));

    }
}