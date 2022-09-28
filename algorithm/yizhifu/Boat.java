package yizhifu;

import java.util.Scanner;

public class Boat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), a = sc.nextInt(), b = sc.nextInt();
        int ans;
        if (n <= 2)
            ans = Math.min(a, b);
        else {
            if (n % 2 == 0)
                ans = a * n / 2;
            else {
                ans = a * (n / 2 + 1);
                ans = Math.min(ans, a * (n / 2 - 1) + b);
            }
            if (n % 3 == 0)
                ans = Math.min(ans, b * n / 3);
            else {
                ans = Math.min(ans, b * (n / 3 + 1));
                if (n % 3 == 1)
                    ans = Math.min(ans, b * (n / 3 - 1) + a * 2);
                else
                    ans = Math.min(ans, b * n / 3 + a);
            }
        }
        System.out.println(ans);
    }

}
