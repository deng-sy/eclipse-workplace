package Nums_String;

import java.util.Scanner;

public class ChangeToPalindorm {
    private static boolean check(String str, int i, int j, boolean flag) {
        return i >= j || (str.charAt(i) == str.charAt(j) && check(str, i + 1, j - 1, flag)) || !flag && (check(str, i + 1, j, true) || check(str, i, j - 1, true));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(check(str, 0, str.length() - 1, false) ? "Yes" : "No");
    }
}
