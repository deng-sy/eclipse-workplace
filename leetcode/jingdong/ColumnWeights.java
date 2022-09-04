package jingdong;

import java.util.*;

public class ColumnWeights {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.next();
            int n = s.length();
            long ans = 0;
            List<Integer> lefts = new ArrayList<>(), rights = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '(') {
                    stack.push(i);
                } else {
                    if (!stack.isEmpty()) {
                        lefts.add(stack.pop());
                        rights.add(i);
                    }
                }
            }
            int size = lefts.size();
            for (int i = 0; i < size; i++) {
                int left = i == 0 ? 0 : lefts.get(i - 1) + 1;
                for (int j = i; j < size; j++) {
                    int right = j == size - 1 ? n - 1 : rights.get(j + 1) - 1;
                    ans += (right - rights.get(j) + 1) * (lefts.get(i) - left + 1) * (j - i + 1);
                }
            }
            System.out.println(ans * 2);
        }
    }
}
