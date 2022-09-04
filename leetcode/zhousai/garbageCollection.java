package zhousai;

import java.util.ArrayList;
import java.util.Arrays;

//����һ���±�� 0 ��ʼ���ַ������� garbage ������ garbage[i] ��ʾ�� i �����ӵ��������ϡ�garbage[i] ֻ�����ַ� 'M' ��'P' �� 'G' �������ܰ��������ͬ�ַ���ÿ���ַ��ֱ��ʾһ��λ�Ľ�����ֽ�Ͳ�������������ʰ һ ��λ���κ�һ����������Ҫ���� 1 ���ӡ�
//
//ͬʱ����һ���±�� 0 ��ʼ���������� travel ������ travel[i] ���������ӷ��� i ��ʻ������ i + 1 ��Ҫ�ķ�������
//
//�������ܹ����������������ֱ���ʰ����������ÿ�����������ӷ��� 0 ��������˳�� ����ÿһ�����ӡ������� ���Ǳ��� �������еķ��ӡ�
//
//�κ�ʱ��ֻ�� һ�� ����������ʹ��״̬����һ������������ʻ������ʰ������ʱ������������ ���� ���κ����顣
//
//���㷵����ʰ������������Ҫ���ѵ� ���� �ܷ�������
public class garbageCollection {
    public int garbageCollection(String[] garbage, int[] travel) {
        int n = garbage.length;
        int[] M = new int[n], P = new int[n], G = new int[n];
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (char ch : garbage[i].toCharArray()) {
                switch (ch) {
                    case 'M':
                        M[i]++;
                        break;
                    case 'P':
                        P[i]++;
                        break;
                    case 'G':
                        G[i]++;
                        break;
                }
            }

            ans += M[i];
            ans += P[i];
            ans += G[i];

        }
        int[] preSum = new int[n - 1];
        preSum[0] = travel[0];
        for (int i = 1; i < n - 1; i++) {
            preSum[i] = preSum[i - 1] + travel[i];
        }

        for (int i = n - 1; i > 0; i--) {
            if (M[i] > 0) {
                ans += preSum[i - 1];
                break;
            }
        }

        for (int i = n - 1; i > 0; i--) {
            if (P[i] > 0) {
                ans += preSum[i - 1];
                break;
            }
        }

        for (int i = n - 1; i > 0; i--) {
            if (G[i] > 0) {
                ans += preSum[i - 1];
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] garbage = {"G", "P", "GP", "GG"};
        int[] travel = {2, 4, 3};
        System.out.print(new garbageCollection().garbageCollection(garbage, travel));
    }
}
