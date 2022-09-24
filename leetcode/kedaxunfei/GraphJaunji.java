package kedaxunfei;

import java.util.*;

public class GraphJaunji {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt(), k = sc.nextInt(), l = sc.nextInt();
        int[][] matrix = new int[m][n];
        int[][] kernel = new int[k][l];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < l; j++) {
                kernel[i][j] = sc.nextInt();
            }
        }
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int x = 0; x < k; x++) {
                    for (int y = 0; y < l; y++) {
                        int nx = i + x - k / 2, ny = j + y - l / 2;
                        if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                            ans[i][j] += matrix[nx][ny] * kernel[x][y];
                        }
                    }
                }
                ans[i][j] = Math.max(0, ans[i][j]);
                ans[i][j] = Math.min(255, ans[i][j]);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
