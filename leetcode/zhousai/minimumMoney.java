package zhousai;

import java.util.Arrays;
import java.util.Comparator;

//6187. ������н��׵ĳ�ʼ����Ǯ��
public class minimumMoney {
    public long minimumMoney(int[][] transactions) {
        long sum = 0;
        for (int[] transaction : transactions) {
            int cost = transaction[0], cashback = transaction[1];
            if (cost > cashback)
                sum += cost - cashback;
        }
        long ans = 0;
        for (int[] transaction : transactions) {
            long cur = sum;
            int cost = transaction[0], cashback = transaction[1];
            if (cost > cashback)
                cur -= cost - cashback;
            ans = Math.max(ans, cur + cost);
        }
        return ans;
    }
}
