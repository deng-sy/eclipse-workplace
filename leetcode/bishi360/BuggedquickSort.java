package bishi360;

import java.util.*;

public class BuggedquickSort {
    private static int binarySearch(int[] keys, int num) {
        int low = 0, high = keys.length;
        int ans = -1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (num == keys[mid])
                return -2;
            else if (num > keys[mid]) {
                ans = mid;
                low++;
            } else {
                high--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            int k = sc.nextInt();
            int[] keys = new int[k];
            for (int i = 0; i < k; i++) {
                keys[i] = sc.nextInt();
            }
            Arrays.sort(keys);
            ArrayList<Integer>[] lists = new ArrayList[k + 1];
            for (int i = 0; i < k + 1; i++) {
                lists[i] = new ArrayList<>();
                if (i > 0)
                    lists[i].add(keys[i - 1]);
            }
            for (int num : nums) {
                int pos = binarySearch(keys, num);
                if (pos == -2)
                    continue;
                lists[pos + 1].add(num);
            }
            for (ArrayList<Integer> list : lists) {
                for (int num : list) {
                    System.out.print(num + " ");
                }
            }


//            for (int key : keys) {
//                int[] small = new int[n];
//                int[] large = new int[n];
//                int sid = 0, lid = 0;
//                for (int i = 0; i < n; i++) {
//                    if (nums[i] < key)
//                        small[sid++] = nums[i];
//                    else if (nums[i] > key)
//                        large[lid++] = nums[i];
//                }
//                int idx = 0;
//                for (int i = 0; i < sid; i++) {
//                    nums[idx++] = small[i];
//                }
//                nums[idx++] = key;
//                for (int i = 0; i < lid; i++) {
//                    nums[idx++] = large[i];
//                }
//            }
//            for (int num : nums) {
//                System.out.print(num + " ");
//            }

        }
    }
}
