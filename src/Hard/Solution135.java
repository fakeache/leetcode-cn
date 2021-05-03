package Hard;

public class Solution135 {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] candy = new int[len];
        candy[0] = 1;
        for (int i = 1; i < len; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                candy[i] = ratings[i - 1] == ratings[i] ? 1 : 1 + candy[i - 1];
            } else {
                candy[i] = 1;
                int j = i;
                while (j > 0 && ratings[j - 1] > ratings[j] && candy[j - 1] <= candy[j]) {
                    candy[j - 1] = 1 + candy[j];
                    j--;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += candy[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        new Solution135().candy(new int[]{2,2,1});
    }
}
