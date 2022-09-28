package zhousai;

import java.util.Arrays;

public class edgeScore {
    public int edgeScore(int[] edges) {
        int n = edges.length;
        long[] scores = new long[n];
        long max = Long.MIN_VALUE;
        int node = 0;
        for (int i = 0; i < n; i++) {
            scores[edges[i]] += i;
            if ((max < scores[edges[i]]) || (max == scores[edges[i]] && node > edges[i])) {
                max = scores[edges[i]];
                node = edges[i];
            }
        }

        return node;
    }

    public static void main(String[] args) {
        int[] edges = {1, 0, 0, 0, 0, 7, 7, 5};
        System.out.println(new edgeScore().edgeScore(edges));
    }
}
