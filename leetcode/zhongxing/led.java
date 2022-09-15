package zhongxing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class led {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<String> res = new ArrayList();
        List<List<String>> hour2min = new ArrayList<>();
        for (int j = 0; j < 12; j++) {
            hour2min.add(new ArrayList<>());
        }
        for (int i = 0; i <= n; i++) {
            if (i > 4 || n - i > 6)
                continue;
            TreeSet<Integer> hours = new TreeSet();
            TreeSet<Integer> minutes = new TreeSet();

            dfs(i, 4, 11, hours, 0, new boolean[4], 0, 0);
            dfs(n - i, 6, 59, minutes, 0, new boolean[6], 0, 0);
            for (int hour : hours) {
                for (int minute : minutes) {
                    hour2min.get(hour).add(val2minute(minute));
//                    res.add(hour + ":" + val2minute(minute));
                }
            }
        }
//         System.out.print("[");
//         for(int i=0;i<res.size();i++){
//             System.out.print(res.get(i));
//             if(i!=res.size()-1){
//                 System.out.print(",");
//             }
//         }
//         System.out.print("]");
        for (int i = 0; i < 12; i++) {
            List<String> list = hour2min.get(i);
            for (String min : list) {
                res.add(i + ":" + min);
            }
        }
        System.out.println(res);


    }

    // 11--1011
    // 59--111011
    private static void dfs(int n, int maxBit, int max, TreeSet<Integer> res, int val, boolean[] vis, int cnt, int idx) {
        if (val > max)
            return;
        if (cnt == n) {
            res.add(val);
            return;
        }
        for (int i = idx; i < maxBit; i++) {
            if (vis[i])
                continue;
            vis[i] = true;
            dfs(n, maxBit, max, res, val + (1 << i), vis, cnt + 1, i + 1);
            vis[i] = false;

        }

    }

    private static String val2minute(int n) {
        String res = String.valueOf(n);
        if (res.length() == 1) {
            res = "0" + res;
        }
        return res;
    }

}

//4--0100   20--010100
