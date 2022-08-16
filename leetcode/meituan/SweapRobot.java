package meituan;

import java.util.Scanner;

public class SweapRobot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
            String str = sc.next();
            boolean[][] vis = new boolean[n][m];
            vis[0][0] = true;
            int x = 0, y = 0;
            boolean isClean = false;
            int left = n * m - 1;
            int order = 0;
            for (int i = 0; i < k; i++) {
                char ch = str.charAt(i);
                switch (ch) {
                    case 'W':
                        y--;
                        break;
                    case 'A':
                        x--;
                        break;
                    case 'S':
                        y++;
                        break;
                    case 'D':
                        x++;
                        break;
                }
                if (!vis[x][y]) {
                    vis[x][y] = true;
                    left--;
                }
                if (left == 0) {
                    isClean = true;
                    order = i + 1;
                    break;
                }

            }
            if (isClean) {
                System.out.println("Yes");
                System.out.println(order);
            } else {
                System.out.println("No");
                System.out.println(left);
            }
        }
    }
}
