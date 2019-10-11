package Simple;

public class Solution292 {
    public static boolean canWinNim(int n) {
        if (n <= 0) {
            return false;
        }
        return (n % 4 == 0) ? false : true;
    }
    public static void main(String[] args){
        int n =16;
        System.out.println(canWinNim(n));
    }
}
