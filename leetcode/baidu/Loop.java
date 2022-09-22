package baidu;

import java.util.*;

public class Loop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long ans = 0;
        long loop = 0;
        boolean flag = false;
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            if (str.contains("Main")) {
                flag = true;
            }
            if (str.contains("for")) {
                loop++;
                ans = Math.max(ans, loop);
            } else if (str.contains("{")) {
                loop++;
            } else if (str.contains("}")) {
                loop--;
            }
            System.out.println(str);
            if (flag && loop == 0)
                break;
        }
        System.out.println(ans - 2);
    }
}
