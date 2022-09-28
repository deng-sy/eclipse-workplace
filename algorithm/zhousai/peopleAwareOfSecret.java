package zhousai;


public class peopleAwareOfSecret {
    public static int peopleAwareOfSecret(int n, int delay, int forget) {
        int mod = 1000000007;
        if (delay > n)
            return 1;
        int[] dp = new int[forget];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = forget - 1; j >= 1; j--) {
                dp[j] = dp[j - 1];
            }
            dp[0] = 0;
            for (int j = delay; j < forget; j++) {
                dp[0] = (dp[0] + dp[j]) % mod;
            }
        }
        long ans = 0;
        for (int i = 0; i < forget; i++) {
            ans = (ans + dp[i]) % mod;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(peopleAwareOfSecret(4, 1, 3));
    }
}
