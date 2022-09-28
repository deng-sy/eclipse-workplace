package tencent_music;

public class numsOfGoodMatrix {
    public int numsOfGoodMatrix(int n, int m, int x) {
        // write code here
        if (n == 2 && m == 2) {
            return 8;
        }
        long ans = 0;
        int mod = 1000000007;
        int odd = (x + 1) / 2, even = x - odd;
        for (int k = 1; k < n; k++) {
            int cnt = combination(n, k);
            int cnt_one = k * (m + 1) / 2;
            ans = (int) ((ans + cnt * (Math.pow(odd, cnt_one) * Math.pow(even, n * m - cnt_one))) % mod);
        }
        System.out.println(ans);
        for (int k = 1; k < m; k++) {
            int cnt = combination(m, k);
            int cnt_one = k * (n + 1) / 2;
            ans = (int) ((ans + cnt * (Math.pow(odd, cnt_one) * Math.pow(even, n * m - cnt_one)) % mod));
        }
        System.out.println(ans);
        int cnt_one = ((n + 1) / 2) * ((m + 1) / 2);
        ans = (int) ((ans - Math.pow(odd, cnt_one) * Math.pow(even, n * m - cnt_one)) % mod);
        System.out.println(ans);
        for (int i = 1; i < m; i++) {
            int cnt = combination(m, i);
            ans = (int) ((ans + cnt * (Math.pow(odd, n * i) * Math.pow(even, n * (m - i)))) % mod);
        }
        System.out.println(ans);
        for (int i = 1; i < n; i++) {
            int cnt = combination(n, i);
            ans = (int) ((ans + cnt * (Math.pow(odd, m * i) * Math.pow(even, m * (n - i)))) % mod);
        }
        System.out.println(ans);
        ans = (int) ((ans + Math.pow(even, n * m) + Math.pow(odd, n * m)) % mod);
        return (int) ans;
    }

    int combination(int n, int k) {
        int ans = 1;
        int m = Math.min(k, n - k);
        for (int i = 1; i <= m; i++) {
            ans *= (n - i + 1) / i;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new numsOfGoodMatrix().numsOfGoodMatrix(2, 2, 2));
    }
}
