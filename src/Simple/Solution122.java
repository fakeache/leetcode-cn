package Simple;

public class Solution122 {
    public static int maxProfit(int[] prices) {
        if(prices==null || prices.length==0){
            return 0;
        }
        int low = prices[0];
        int high = prices[0];
        int profit = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]<=high){
                profit+=high-low;
                low = prices[i];
                high = prices[i];
            }
            else{
                high = prices[i];
            }
        }
        return profit+high-low;
    }
    public static void main(String[] args){
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
