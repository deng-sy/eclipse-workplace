package zhousai;

//�������� �� ���� startPos �� endPos ���������վ�� ���� ������λ�� startPos ������һ���ƶ��У������������������ƶ�һ��λ�á�
//
//����һ�������� k �����ش� startPos ������ǡ�� �ƶ� k �������� endPos �� ��ͬ ������Ŀ�����ڴ𰸿��ܻ�ܴ󣬷��ض� 109 + 7 ȡ�� �Ľ����
//
//�����ִ���ƶ���˳����ȫ��ͬ������Ϊ���ַ�����ͬ��
//
//ע�⣺���������������
public class numberOfWays {
    public int numberOfWays(int startPos, int endPos, int k) {
        int mod = 1000000007;
        int dist = endPos - startPos;
        if (k < Math.abs(dist) || ((k - dist) & 1) == 1) {
            return 0;
        }
        int cap = (k - Math.abs(dist)) >> 1;
        long[] dp = new long[cap + 1];
        dp[0] = 1;
        for (int i = 1; i <= k; i++) {
            for (int j = cap; j >= 0; j--) {
                if (j >= 1)
                    dp[j] = (dp[j] + dp[j - 1]) % mod;
            }
        }
        return (int) dp[cap];
    }

    public static void main(String[] args) {
        System.out.println(new numberOfWays().numberOfWays(1, 2, 3));
    }
}
