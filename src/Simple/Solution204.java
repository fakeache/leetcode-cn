package Simple;

public class Solution204 {
    //筛法
    public static int countPrimes(int n) {
        boolean[] con = new boolean[n];
        int count = 0;
        for (int i = 2; i < n ;i++) {
            if (!con[i]) {
                count++;
                for (int j = i + i; j < n; j = j + i) {
                    con[j] = true;
                }
            }
        }
        return count;
    }

    public static void main(String[] args){
        int n = 19;
        System.out.println(countPrimes(n));
    }
}