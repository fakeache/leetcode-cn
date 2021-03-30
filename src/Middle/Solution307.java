package Middle;

class Solution307 {

    int[] tree;
    int n;

    public Solution307(int[] nums) {
        if (nums.length > 0) {
            n = nums.length;
            tree = new int[2 * n];
            buildTree(nums);
        }
    }

    public void buildTree(int[] nums) {
        for (int i = 0, j = n; j < 2 * n; i++, j++) {
            tree[j] = nums[i];
        }
        for (int i = n - 1; i > 0; i--) {
            tree[i] = tree[2 * i] + tree[2 * i + 1];
        }
    }

    public void update(int index, int val) {
        int pos = n + index;
        int old = tree[pos];
        while (pos > 0) {
            tree[pos] = tree[pos] - old + val;
            pos /= 2;
        }
    }

    public int sumRange(int left, int right) {
        left = n + left;
        right = n + right;
        int sum = 0;
        while (left <= right) {
            if ((left % 2) == 1) {
                sum += tree[left];
                left++;
            }
            if ((right % 2) == 0) {
                sum += tree[right];
                right--;
            }
            left /= 2;
            right /= 2;
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
