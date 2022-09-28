package Nums_String;
//����һ������Ϊ n ����������?nums?��
//����?arrk?������?nums?˳ʱ����ת k ��λ�ú�����飬���Ƕ���?nums?�� ��ת����??F?Ϊ��
//F(k) = 0 * arrk[0] + 1 * arrk[1] + ... + (n - 1) * arrk[n - 1]
//����?F(0), F(1), ..., F(n-1)�е����ֵ?

import java.util.Arrays;

//���õ���
public class maxRotateFunction {
    public static int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        int f = 0;
        for (int i = 0; i < n; i++) {
            f += i * nums[i];
        }
        int res = f;
        for (int i = 0; i < n; i++) {
            f += sum - n * nums[n - i - 1];
            res = Math.max(res, f);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 6};
        System.out.print(maxRotateFunction(nums));
    }
}
