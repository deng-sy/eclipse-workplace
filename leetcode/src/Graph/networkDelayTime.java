package Graph;
import java.util.*;
//�� n ������ڵ㣬���Ϊ?1?�� n��
//����һ���б�?times����ʾ�źž��� ���� �ߵĴ���ʱ�䡣?times[i] = (ui, vi, wi)������?ui?��Դ�ڵ㣬vi?��Ŀ��ڵ㣬 wi?��һ���źŴ�Դ�ڵ㴫�ݵ�Ŀ��ڵ��ʱ�䡣
//���ڣ���ĳ���ڵ�?K?����һ���źš���Ҫ��ò���ʹ���нڵ㶼�յ��źţ��������ʹ���нڵ��յ��źţ�����?-1 ��

public class networkDelayTime {
    public static int networkDelayTime(int[][] times, int n, int k) {
        final int INF = Integer.MAX_VALUE / 2;
        int[][] g = new int[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(g[i], INF);
        }
        for (int[] t : times) {
            int x = t[0] - 1, y = t[1] - 1;
            g[x][y] = t[2];
        }

        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[k - 1] = 0;
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; ++i) {
            int x = -1;
            for (int y = 0; y < n; ++y) {
                if (!used[y] && (x == -1 || dist[y] < dist[x])) {
                    x = y;
                }
            }
            used[x] = true;
            for (int y = 0; y < n; ++y) {
                dist[y] = Math.min(dist[y], dist[x] + g[x][y]);
                System.out.print(dist[y]+" ");
            }
            System.out.println();
        }

        int ans = Arrays.stream(dist).max().getAsInt();
        return ans == INF ? -1 : ans;
    }

    public static void main(String[] args) {
        int[][]time={{2,1,1},{2,3,1},{3,4,1}};
        int n=4;
        int k=2;
        System.out.println(networkDelayTime(time,n,k));
    }

}
