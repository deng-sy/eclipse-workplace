package mayi;

import java.util.*;

public class Matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[][] ans = new int[n][n];
            int odd_num = (n * n + 1) / 2, even_num = n * n - odd_num;
            int[] odds = new int[odd_num], evens = new int[even_num];
            int m = 0, t = 0;
            boolean find = false;
            for (int k = 1; k <= n * n; k++) {
                if (k % 2 == 0) {
                    evens[t++] = k;
                } else {
                    odds[m++] = k;
                }
            }
            if (n % 2 == 0) {
                if ((odd_num - (n / 2) * (n / 2)) % n == 0) {
                    find = true;
                    int p = 0;
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            if (p == odd_num)
                                break;
                            if (i % 2 == 1 || j % 2 == 0) {
                                ans[i][j] = odds[p++];
                            }

                        }
                    }
                }
            } else {
                if ((odd_num - (n / 2 + 1) * (n / 2 + 1)) % n == 0) {
                    find = true;
                    int p = 0;
                    for (int i = 0; i < n; i++) {
                        if (p == odd_num)
                            break;
                        for (int j = 0; j < n; j++) {
                            if (i % 2 == 1 || j % 2 == 0) {
                                ans[i][j] = odds[p++];
                            }

                        }
                    }
                } else if ((odd_num - (n / 2) * (n / 2 + 1)) % n == 0) {
                    find = true;
                    int p = 0;
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            if (p == odd_num)
                                break;
                            if (i % 2 == 0 || j % 2 == 0) {
                                ans[i][j] = odds[p++];
                            }

                        }
                    }
                } else if ((odd_num - (n / 2) * (n / 2)) % n == 0) {
                    find = true;
                    int p = 0;
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            if (p == odd_num)
                                break;
                            if (i % 2 == 0 || j % 2 == 1) {
                                ans[i][j] = odds[p++];
                            }

                        }
                    }
                }
            }
            if (find) {
                int q = 0;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (ans[i][j] == 0) {
                            ans[i][j] = evens[q++];
                        }
                        System.out.print(ans[i][j] + " ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println(-1);
            }
        }


    }
}
