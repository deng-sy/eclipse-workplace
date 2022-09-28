package zhousai;

import java.util.*;

public class Test {
    static class Shift {
        int begin, end, dir;

        public Shift(int begin, int end, int dir) {
            this.begin = begin;
            this.end = end;
            this.dir = dir;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Shift shift = (Shift) o;
            return begin == shift.begin &&
                    end == shift.end &&
                    dir == shift.dir;
        }

        @Override
        public int hashCode() {
            return Objects.hash(begin, end, dir);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        long[] ends = new long[n];
        ends[0] = 27;
        ends[1] = 15;
        ends[2] = 0;
        Room[] rooms = new Room[3];
        for (int i = 0; i < n; i++) {
            rooms[i] = new Room(ends[i], i);
        }
        for (Room room : rooms)
            System.out.println(room.id + " " + room.end);
    }
}
