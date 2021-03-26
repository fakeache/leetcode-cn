package Middle;

class Solution223 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int x = Math.max(0, Math.min(C, G) - Math.max(A, E));
        int y = Math.max(0, Math.min(D, H) - Math.max(B, F));
        return (C - A) * (D - B) + (G - E) * (H - F) - x * y;
    }
}
