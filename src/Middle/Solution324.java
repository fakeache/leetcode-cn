package Middle;

public class Solution324 {
    public void wiggleSort(int[] nums) {
        int len = nums.length;
        int m = (len - 1) / 2;
        quickSelect(nums, m);
        //三分法
        int mid = nums[m];
        int i = 0, j = 0, n = len - 1;
        while (j < n) {
            if (nums[j] < mid) {
                swap(nums, i , j);
                i++;
                j++;
            } else if (nums[j] == mid) {
                j++;
            } else {
                swap(nums, j, n);
                n--;
            }
        }
        int[] back = nums.clone();
        int in = (nums.length + 1) / 2;
        for (i = 0; i < in; i++) {
            nums[2 * i] = back[in - 1 - i];
        }
        for (i = len - 1; i >= in; i--) {
            nums[(len - 1 - i) * 2 + 1] = back[i];
        }
    }

    //快速选择算法，o(n)
    public void quickSelect(int[] nums, int index) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (true) {
            int pos = partition(nums, left, right);
            if (index == pos) {
                return;
            } else if (index > pos){
                left = pos + 1;
            } else {
                right = pos - 1;
            }
        }
    }

    public int partition(int[] nums, int left, int right) {
        int j = left;
        int pivot = nums[left];
        for (int i = left + 1; i < nums.length; i++) {
            if (nums[i] < pivot) {
                j++;
                swap(nums, i, j);
            }
        }
        swap(nums, j, left);
        return j;
    }

    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {
        new Solution324().wiggleSort(new int[]{1,5,1,1,6,4});
    }
}
