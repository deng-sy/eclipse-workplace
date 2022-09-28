package zhousai;

public class isStrictlyPalindromic {
    public boolean isStrictlyPalindromic(int n) {
        for (int k = 2; k <= n - 2; k++) {
            if (!check(n, k))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new isStrictlyPalindromic().isStrictlyPalindromic(9));
    }

    private boolean check(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }
        System.out.println(sb);
        boolean ans=sb.toString().equals(sb.reverse().toString());
        System.out.println(ans);
        return ans;
    }

}
