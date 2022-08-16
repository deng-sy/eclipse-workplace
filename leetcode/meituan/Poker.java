package meituan;

import java.util.*;

public class Poker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] points = new int[n];
            for (int i = 0; i < n; i++) {
                points[i] = sc.nextInt();
            }
            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = n - 1; i >= 0; i--) {
                deque.offerFirst(points[i]);
                if (deque.size() > 2) {
                    deque.offerFirst(deque.pollLast());
                    deque.offerFirst(deque.pollLast());
                }
            }
            while (!deque.isEmpty()) {
                System.out.print(deque.pollFirst() + " ");
            }
        }
    }
}
