package Simple;

public class Solution278 {
    public boolean isBadVersion(int n) { //为了不报错加的无用函数
        return true;
    }
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}