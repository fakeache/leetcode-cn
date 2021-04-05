package Middle;

class Solution319 {
    public int bulbSwitch(int n) {
        for (int i = 1; ;i++) {
            if (n / i < i) {
                return i - 1;
            }
        }
    }
}
