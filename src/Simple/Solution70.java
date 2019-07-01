package Simple;

class Solution70 {
    public static int climbStairs(int n) {
        int low = 1;
        int high = 2;
        if(n==1){
            return low;
        }
        for(int i=3;i<=n;i++){
            int temp = low +high;
            low = high;
            high = temp;
        }
        return high;
    }

    public static void main(String[] args){
        int x = 11;
        System.out.println(climbStairs(x));
    }
}