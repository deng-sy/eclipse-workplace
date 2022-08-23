package meituan;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

//С����һ����N���ڵ���ɵĶ�������ÿ���ڵ���һ��Ȩֵ�����������ÿ���ߵĿ���Ϊ�����˽ڵ�Ȩֵ�ĳ˻������������ܿ�����ÿ���ߵĿ���֮�͡�С�Ű��ն�����������������μ�¼��ÿ���ڵ��Ȩֵ��
// ������¼����N��������i������ʾλ�����������i��λ�õĽڵ��Ȩֵ��֮������ĳ��ԭ��С�������˶������ľ���ṹ�������п��ܵĶ������У��ܿ�����С�Ķ���������Ϊ���Ŷ����������ڣ�С����
// С��������Ŷ��������ܿ�����
public class Bestbinary {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 2];
        int[][] ldp = new int[n + 2][n + 2];
        int[][] rdp = new int[n + 2][n + 2];
        for (int i = 1; i <= n; i++)
            arr[i] = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n - i; j++)
                helper(ldp, rdp, arr, j, j + i);
        }
//        System.out.println(Arrays.toString(arr));
        System.out.println(ldp[1][n]);
//        System.out.println(Arrays.deepToString(ldp));

    }

    private static void helper(int[][] ldp, int[][] rdp, int[] arr, int start, int end) {
        ldp[start][end] = rdp[start][end] = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            ldp[start][end] = Math.min(ldp[start][end], ldp[start][i - 1] + arr[i] * arr[end + 1] + rdp[i + 1][end]);
            rdp[start][end] = Math.min(rdp[start][end], ldp[start][i - 1] + arr[i] * arr[start - 1] + rdp[i + 1][end]);
        }
    }
}
