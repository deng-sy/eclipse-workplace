package jianzhi;

public class myPow {
//    ��һ���ݹ�
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }
    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

//    ����:����
    public double quickMul2(double x, long N) {
        double ans = 1.0;
        // ���׵ĳ�ʼֵΪ x
        double x_contribute = x;
        // �ڶ� N ���ж����Ʋ�ֵ�ͬʱ�����
        while (N > 0) {
            if (N % 2 == 1) {
                // ��� N �����Ʊ�ʾ�����λΪ 1����ô��Ҫ���빱��
                ans *= x_contribute;
            }
            // �����ײ��ϵ�ƽ��
            x_contribute *= x_contribute;
            // ���� N �����Ʊ�ʾ�����λ����������ÿ��ֻҪ�ж����λ����
            N /= 2;
        }
        return ans;
    }



}
