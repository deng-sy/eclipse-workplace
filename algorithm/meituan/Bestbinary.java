package meituan;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

//小团有一个由N个节点组成的二叉树，每个节点有一个权值。定义二叉树每条边的开销为其两端节点权值的乘积，二叉树的总开销即每条边的开销之和。小团按照二叉树的中序遍历依次记录下每个节点的权值，
// 即他记录下了N个数，第i个数表示位于中序遍历第i个位置的节点的权值。之后由于某种原因，小团遗忘了二叉树的具体结构。在所有可能的二叉树中，总开销最小的二叉树被称为最优二叉树。现在，小团请
// 小美求出最优二叉树的总开销。
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
