package honor;

import java.util.*;

public class DataRead {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strs = str.split(" ");
        int n = strs.length;
        int start = sc.nextInt(), cnt = sc.nextInt();
        int row_cnt = 0;
        for (int i = 0; i < cnt; i++) {
            System.out.print(strs[start + i - 1]);
            row_cnt++;
            if (row_cnt == 20) {
                row_cnt = 0;
                System.out.println();
                continue;
            }
            if (start + i - 1 == n-1  || i == cnt - 1)
                break;
            System.out.print(";");
        }


    }
}
