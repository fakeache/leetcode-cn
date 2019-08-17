package Simple;

public class Solution189 {
    //翻转是一个很好的办法
    //注意k可能大于n
    public void rotatePart(int[] nums, int x, int y){
        while(x<y){
            int temp = nums[x];
            nums[x] = nums[y];
            nums[y] = temp;
            x++;
            y--;
        }
    }

    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        int len = nums.length-1;
        rotatePart(nums, 0, len);
        rotatePart(nums, 0, k-1);
        rotatePart(nums, k, len);
    }
}
