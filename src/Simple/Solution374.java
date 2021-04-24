package Simple;

public class Solution374 {
    public int guessNumber(int n) {
        int low = 1, high = n;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int guessMid = guess(mid);
            if (guessMid == 0) {
                return mid;
            } else if (guessMid == 1) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public int guess(int mid) {
        return -1;
    }
}
