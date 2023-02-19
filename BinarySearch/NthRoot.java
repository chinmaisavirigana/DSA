public class NthRoot {
    public static double findNthRoot(double num, int n) {
        double left = 0.0, right = num, mid;
        double eps = 1e-6; // Set the precision of the answer
        while (right - left > eps) {
            mid = (left + right) / 2.0;
            double p = 1.0;
            for (int i = 1; i <= n; i++) {
                p *= mid;
            }
            if (p > num) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        double num = 256.0;
        int n = 4;
        double nthRoot = findNthRoot(num, n);
        System.out.printf("The %dth root of %.2f is %.6f\n", n, num, nthRoot);
    }
}
