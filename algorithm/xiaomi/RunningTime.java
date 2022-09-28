package xiaomi;

import java.util.*;

public class RunningTime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<int[]> intervals = new ArrayList<>();
        String line = sc.nextLine();
        while (!Objects.equals(line, "")) {
            String[] nums = line.split(" ");
            int left = Integer.parseInt(nums[0]), right = Integer.parseInt(nums[1]);
            intervals.add(new int[]{left, right});
            line = sc.nextLine();
        }
        intervals.sort(Comparator.comparingInt(o -> o[0]));
        long ans = 0;
        int end = -1;
        for (int[] interval : intervals) {
            int left = interval[0], right = interval[1];
            if (right > end) {
                ans += right - Math.max(end, left);
                end = right;
            }
        }
        System.out.println(ans);
    }
}
