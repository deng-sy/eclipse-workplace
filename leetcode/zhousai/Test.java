package zhousai;

import java.util.HashSet;
import java.util.Objects;

public class Test {
    static class Shift {
        int begin,end,dir;
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
        System.out.println(-29%26);
    }
}
