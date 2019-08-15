package Simple;

public class Solution172 {
    public static int trailingZeroes(int n) {
        int num = 0;
        while(n>0){
            num = num + n/5;
            n = n/5;
        }
        return num;
    }
    public static void main(String[] args){
        System.out.println(trailingZeroes(1840));
    }
}