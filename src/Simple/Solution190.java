package Simple;

public class Solution190 {
    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        int sum = 0;
        for(int i=0;i<32;i++){
            int t = n;
            t = t >>> i;
            t = t & 1;
            t = t << (31-i);
            sum = sum + t;
        }
        return sum;
    }
    public static void main(String[] args){
        System.out.println(reverseBits(747474));
        System.out.println(Integer.toBinaryString(747474));
        System.out.println(Integer.toBinaryString(reverseBits(747474)));
    }
}
