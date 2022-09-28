package honor;

import java.util.*;

public class MaxNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        List<List<Integer>> obatacles = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            obatacles.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            int from = sc.nextInt(), to = sc.nextInt();
            obatacles.get(from).add(to);
        }
        int N = sc.nextInt();
        List<List<Integer>> paths = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            paths.add(new ArrayList<>());
        }
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] dirs = {{0, 0}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int[] dir : dirs) {
                    int ni = i + dir[0], nj = j + dir[1];
                    if (ni < 0 || ni >= 3 || nj < 0 || nj >= 3 || obatacles.get(matrix[i][j]).contains(matrix[ni][nj]))
                        continue;
                    paths.get(matrix[i][j]).add(matrix[ni][nj]);
                }
            }
        }
//        System.out.println(obatacles);
//        System.out.println(paths);
        long ans = 0l;
        int len = 0;
        for (int i = 2; i >= 0; i--) {
            for (int j = 2; j >= 0; j--) {
                Queue<StringBuilder> queue = new LinkedList<>();
                queue.offer(new StringBuilder().append(matrix[i][j]));
                int step = 0;
                while (!queue.isEmpty()) {
                    int size = queue.size();
                    while (size-- > 0) {
                        StringBuilder cur = queue.poll();
//                        System.out.println(cur);
                        if (len < cur.length()) {
                            ans = Long.parseLong(cur.toString());
                            len = cur.length();
                        } else if (len == cur.length()) {
                            ans = Math.max(ans, Long.parseLong(cur.toString()));
                        }
                        int from = cur.charAt(cur.length() - 1) - '0';
                        for (int to : paths.get(from)) {
                            StringBuilder next = new StringBuilder(cur);
                            queue.offer(new StringBuilder(next.append(to)));
                        }
                    }
                    step++;
                    if (step == N + 1) {
                        break;
                    }
                }
                if (step == N + 1)
                    break;
            }
        }
        System.out.println(ans);

    }
}
