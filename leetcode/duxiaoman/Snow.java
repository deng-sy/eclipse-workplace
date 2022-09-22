package duxiaoman;

import java.util.*;

public class Snow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt(), h = sc.nextInt();
            int[] path = new int[100005];
            for (int i = 0; i < n; i++) {
                int l = sc.nextInt();
                int r = sc.nextInt();
                path[l]++;
                path[r]--;
            }
            int ans = path[0] >= h ? 1 : 0;
            for (int i = 1; i < path.length; i++) {
                path[i] += path[i - 1];
                if (path[i] >= h)
                    ans++;
            }
            System.out.println(ans);
        }
    }

}
