package honor;

import java.util.*;

public class PathFind {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = str.length();
        int idx = 0;
        int left = 0, right = 0;
        while (idx < n) {
            char ch = str.charAt(idx);
            if (ch == '{') {
                left = idx++;
            } else if (ch == '}') {
                right = idx++;
                break;
            } else
                idx++;
        }
        String L = str.substring(left + 1, right);
        while (idx < n) {
            char ch = str.charAt(idx);
            if (ch == '{') {
                left = idx++;
            } else if (ch == '}') {
                right = idx;
                break;
            } else
                idx++;
        }
        String Q = str.substring(left + 1, right);
        String P = str.substring(right + 4, n);
        String[] Lnums = L.split("\\|");
        List<int[]> Llist = new ArrayList<>();
        for (String Lnum : Lnums) {
            String[] nums = Lnum.split(",");
            int[] points = new int[4];
            for (int i = 0; i < 4; i++) {
                points[i] = Integer.parseInt(nums[i]);
            }
            Llist.add(points);
        }
        String[] Qnums = Q.split("\\|");
        List<int[]> Qlist = new ArrayList<>();
        for (String Qnum : Qnums) {
            String[] nums = Qnum.split(",");
            int[] points = new int[2];
            for (int i = 0; i < 2; i++) {
                points[i] = Integer.parseInt(nums[i]);
            }
            Qlist.add(points);
        }
        String[] nums = P.split(",");
        int[] p = {Integer.parseInt(nums[0]), Integer.parseInt(nums[1])};
        int px = p[0], py = p[1];
        for (int[] q : Qlist) {
            int qx = q[0], qy = q[1];
            boolean flag = true;
            for (int[] l : Llist) {
                int lax = l[0], lay = l[1], lbx = l[2], lby = l[3];
                if (!check(px, py, qx, qy, lax, lay, lbx, lby)) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                System.out.print("(" + qx + "," + qy + ")");
        }
    }

    static boolean check(int px, int py, int qx, int qy, int lax, int lay, int lbx, int lby) {
        if ((Math.max(px, qx) < Math.min(lax, lbx) || Math.max(lax, lbx) < Math.min(px, qx)) &&
                (Math.max(py, qy) < Math.min(lay, lby) || Math.max(lay, lby) < Math.min(py, qy)))
            return true;
        return (Xproduct(lbx - px, lby - py, qx - px, qy - py) * Xproduct(lax - px, lay - py, qx - px, qy - py) > 0 ||
                Xproduct(px - lax, py - lay, lbx - lax, lby - lay) * Xproduct(qx - lax, qy - lay, lbx - lax, lby - lay) > 0);

    }

    static int Xproduct(int x1, int y1, int x2, int y2) {
        return x1 * y2 - x2 * y1;
    }
}
