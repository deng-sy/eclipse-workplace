package microsoft;

public class Rehabilitation {
    public int solution(int[] A, int X, int Y) {
        int n = A.length;
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < Y; i++) {
            int left = i, right = i;
            for (int idx = 0; right < n - (X - 1) * Y && idx < X; right += Y, idx++) {
                sum += A[right];
                ans = Math.min(ans, sum);
            }
            while (right + Y < n) {
                right += Y;
                sum = sum - A[left] + A[right];
                left += Y;
                ans = Math.min(ans, sum);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {4, 2, 3, 7};
        int X = 2, Y = 2;
        System.out.println(new Rehabilitation().solution(A, X, Y));
    }
}
