package jingdong;

import java.util.*;

public class Fake {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            HashMap<Integer, Integer> map = new HashMap<>();
            int maxnum = 0;
            for (int i = 0; i < n; i++) {
                int num = sc.nextInt();
                map.put(num, map.getOrDefault(num, 0) + 1);
                if (num > maxnum) {
                    maxnum = num;
                }
            }
            System.out.println(n - map.get(maxnum));

        }
    }
}
