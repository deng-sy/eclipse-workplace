package microsoft;

import java.util.Arrays;

public class StablePeriod {
    public int solution(int[] A) {
        int n = A.length;
        int minus = A[1] - A[0];
        int cnt = 0;
        int ans = 0;
        int max = 1000000000;
        for (int i = 2; i < n; i++) {
            if (A[i] - A[i - 1] == minus) {
                cnt++;
                ans += cnt;
                if (ans > max)
                    return -1;
            } else {
                cnt = 0;
                minus = A[i] - A[i - 1];
            }
        }
        return ans;

    }

    public static void main(String[] args) {
//        int[] A = {-1, 1, 3, 3, 3, 2, 3, 2, 1, 0};
        int[] A = new int[10000];
        Arrays.fill(A, 2);
        System.out.println(new StablePeriod().solution(A));
    }
}
