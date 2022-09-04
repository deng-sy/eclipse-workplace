package zhousai;

import Graph.calcEquation;

import java.util.*;

class Room {
    long end;
    int id;

    public Room(long end, int id) {
        this.end = end;
        this.id = id;

    }
}

public class mostBooked {
    public int mostBooked(int n, int[][] meetings) {
        PriorityQueue<Room> using = new PriorityQueue<>((o1, o2) -> o1.end != o2.end ? (int) (o1.end - o2.end) : o1.id - o2.id);
        PriorityQueue<Integer> idle = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        int[] cnts = new int[n];
        for (int i = 0; i < n; i++)
            idle.offer(i);
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];
            while (!using.isEmpty() && using.peek().end <= start) {
                idle.offer(using.poll().id);
            }
            int id;
            if (idle.isEmpty()) {
                Room empty = using.poll();
                id = empty.id;
                end += empty.end - start;
            } else
                id = idle.poll();
            cnts[id]++;
            using.offer(new Room(end, id));
        }
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (cnts[i] > cnts[ans]) {
                ans = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] meeting = {{1, 27}, {29, 49}, {47, 49}, {41, 43}, {15, 36}, {11, 15}};
        System.out.println(new mostBooked().mostBooked(n, meeting));
    }
}
