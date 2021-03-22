package Middle;

class Solution201 {
    public int rangeBitwiseAnd(int left, int right) {
        int flag = 0;
        while (left != right) {
            left = left >> 1;
            right = right >> 1;
            flag++;
        }
        return left << flag;
    }
}