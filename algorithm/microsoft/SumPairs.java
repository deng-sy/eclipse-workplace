package microsoft;

import java.util.*;

class Fraction {
    private int x, y;

    public Fraction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return x == fraction.x && y == fraction.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

public class SumPairs {

    public int solution(int[] X, int[] Y) {
        int mod = 1000000007;
        int ans = 0;
        int n = X.length;
        for (int i = 0; i < n; i++) {
            int gcd = getGCD(X[i], Y[i]);
            X[i] /= gcd;
            Y[i] /= gcd;
        }
        HashMap<Fraction, Integer> cnt_map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Fraction fraction = new Fraction(X[i], Y[i]);
            cnt_map.put(fraction, cnt_map.getOrDefault(fraction, 0) + 1);
        }
        Set<Fraction> vis = new HashSet<>();
        vis.addAll(cnt_map.keySet());
        for (Map.Entry<Fraction, Integer> entry : cnt_map.entrySet()) {
            Fraction fraction = entry.getKey();
            if (!vis.contains(fraction))
                continue;
            int cnt = entry.getValue();
            int x = fraction.getX(), y = fraction.getY();
            Fraction new_f = new Fraction(y - x, y);
            if (y - x == x) {
                ans = (ans + cnt * (cnt - 1) / 2) % mod;
            } else if (cnt_map.containsKey(new_f)) {
                int new_cnt = cnt_map.get(new_f);
                ans = (ans + cnt * new_cnt) % mod;
                vis.remove(new_f);
            }
            vis.remove(fraction);
        }
        return ans;
    }

    private int getGCD(int x, int y) {
        if (x < y) {
            int tmp = x;
            x = y;
            y = tmp;
        }
        int ans = 1;
        while (y > 0) {
            ans = y;
            y = x % y;
            x = y;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] X = {1, 2, 2, 1, 1, 1, 2}, Y = {3, 3, 3, 3, 3, 3, 6};
        System.out.println(new SumPairs().solution(X, Y));
    }
}
