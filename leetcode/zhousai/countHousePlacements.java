package zhousai;

import java.util.Arrays;

//һ���ֵ��Ϲ��� n * 2 �� �ؿ� ���ֵ���������� n ���ؿ顣ÿһ�ߵĵؿ鶼���� 1 �� n ��š�ÿ���ؿ��϶����Է���һ�����ӡ�
//
//��Ҫ��ֵ�ͬһ�಻�ܴ��������������ڵ������������㲢���ط��÷��ݵķ�ʽ��Ŀ�����ڴ𰸿��ܴܺ���Ҫ�� 109 + 7 ȡ����ٷ��ء�
//
//ע�⣬���һ�����ӷ�����������ĳһ���ϵĵ� i ���ؿ飬��Ӱ������һ��ĵ� i ���ؿ���÷��ӡ�
public class countHousePlacements {
    public static int countHousePlacements(int n) {
        int mod = 1000000007;
        long[] num = new long[4];
        Arrays.fill(num, 1);
        while (--n > 0) {
            long[] tmp = new long[4];
            tmp[0] = (num[0] + num[1] + num[2] + num[3]) % mod;
            tmp[1] = (num[0] + num[2]) % mod;
            tmp[2] = (num[0] + num[1]) % mod;
            tmp[3] = num[0] % mod;
            num = tmp;
        }
        long ans = 0;
        for (int i = 0; i < 4; i++) {
            ans = (ans + num[i]) % mod;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(countHousePlacements(3));
    }
}
