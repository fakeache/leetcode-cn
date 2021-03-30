package Middle;

class Solution275 {
    public int hIndex(int[] citations) {
        int h = 0, len = citations.length;
        int lo = 0, hi = len - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (citations[mid] >= len - mid &&
                    (mid == 0 || citations[mid - 1] <= len - mid)) {
                h = len - mid;
                return h;
            } else if (citations[mid] < len - mid) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return h;
    }
}
