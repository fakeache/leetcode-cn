package Simple;

public class Solution121 {
    public static int maxProfit(int[] prices) {
        if(prices==null || prices.length==0){
            return 0;
        }
        int low=prices[0];
        int high=prices[0];
        int profit = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]<=low){
                low = prices[i];
                high = prices[i];
            }
            else if(prices[i]<=high){
                continue;
            }
            else{
                high = prices[i];
                profit = high-low>profit?high-low:profit;
            }
        }
        return profit;
    }

    public static void main(String[] args){
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
