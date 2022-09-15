package fanruan;
// ������?�Ŀ�Ͱ汾�����ο� ������˵����
// ������� `ShowMeBug` �����Է�ִ?ʧ��

import java.util.*;

public class ShowMeBug {
    // �������Թ������ò�������
    // �������ĿҪ��ȷ������ֵ���ͺͲ����б�(����)
    int ans;

    public int solution(String matrix, int cols, String key) {
        // ����?д����
        ans = 0;
        int len = matrix.length();
        int rows = len / cols;
        char[][] chars = new char[rows][cols];
        int start = 0;
        for (int i = 0; i < rows; i++) {
            StringBuilder sb = new StringBuilder();
            int end = start + cols;
            while (start < end) {
                sb.append(matrix.charAt(start));
                start++;
            }
            if (i % 2 == 0) {
                chars[i] = sb.toString().toCharArray();
            } else {
                chars[i] = sb.reverse().toString().toCharArray();
            }
        }

        // System.out.println(Arrays.deepToString(chars));
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (chars[i][j] != key.charAt(0))
                    continue;
//                System.out.println(i + " " + j);
                boolean[][] vis = new boolean[rows][cols];
                vis[i][j] = true;
                dfs(chars, vis, i, j, 1, key, getPos(i, j, rows, cols));
            }
        }
        return ans == 0 ? -1 : ans;
    }

    public int getPos(int i, int j, int rows, int cols) {
        return i % 2 == 0 ? i * cols + j : (i + 1) * cols - j - 1;
    }

    public void dfs(char[][] chars, boolean[][] vis, int i, int j, int idx, String key, int sum) {
        int rows = chars.length, cols = chars[0].length, len = key.length();
        if (idx == len) {
            ans += sum;
            return;
        }
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : dirs) {
            int ni = i + dir[0], nj = j + dir[1];
            if (ni < 0 || ni >= rows || nj < 0 || nj >= cols || vis[ni][nj] || key.charAt(idx) != chars[ni][nj])
                continue;
            vis[ni][nj] = true;
            int pos = getPos(ni, nj, rows, cols);
            // System.out.println(ni + " " + nj + " " + chars[ni][nj]+" "+pos);
            dfs(chars, vis, ni, nj, idx + 1, key, sum + pos);
            vis[ni][nj] = false;
        }
    }

    public static void main(String[] args) {
        ShowMeBug showMeBug = new ShowMeBug();
        // �ɸ�����ĿҪ������������
        String matrix = "abcescfsadee";
        System.out.println("succeed to execute, your result is " + showMeBug.solution(matrix, 4, "bccfd"));
    }
}