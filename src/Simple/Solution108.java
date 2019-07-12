package Simple;

public class Solution108 {

    public TreeNode sortArray(int[] nums, int begin, int end){
        if(begin>end){
            return null;
        }
        int x = (end-begin) % 2;
        if(x==0){
            TreeNode node = new TreeNode(nums[(end+begin)/2]);
            node.left = sortArray(nums, begin, (end+begin)/2-1);
            node.right = sortArray(nums, (end+begin)/2+1, end);
            return node;
        }
        else{
            TreeNode node = new TreeNode(nums[(end+begin)/2+1]);
            node.left = sortArray(nums, begin, (end+begin)/2);
            node.right = sortArray(nums, (end+begin)/2+2, end);
            return node;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null || nums.length==0){
            return null;
        }
        return sortArray(nums, 0, nums.length-1);
    }
}