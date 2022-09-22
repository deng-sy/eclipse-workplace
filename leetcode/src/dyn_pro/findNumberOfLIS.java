package dyn_pro;

import java.util.*;

//��ϸ���������еĸ���
public class findNumberOfLIS {
    public static int findNumberOfLIS(int[] nums) {
//        dp[i]��ʾ���г���Ϊi+1�ĵ������е�ĩβֵ
        List<List<Integer>> dp = new ArrayList<>();
//        cnt[i][j+1]��ʾ��d[i][j]Ϊ��β������������еĸ���
        List<List<Integer>> cnt = new ArrayList<>();
        for (int num : nums) {
            int i = binarySearch1(dp.size(), dp, num);
            int c = 1;
            if (i > 0) {
                int k = binarySearch2(dp.get(i - 1).size(), dp.get(i - 1), num);
                c = cnt.get(i - 1).get(cnt.get(i - 1).size() - 1) - cnt.get(i - 1).get(k);
            }
            if (i == dp.size()) {
                List<Integer> dList = new ArrayList<>();
                dList.add(num);
                dp.add(dList);
                List<Integer> cntList = new ArrayList<>();
                cntList.add(0);
                cntList.add(c);
                cnt.add(cntList);
            } else {
                dp.get(i).add(num);
                int cntSize = cnt.get(i).size();
                cnt.get(i).add(cnt.get(i).get(cntSize - 1) + c);
            }
        }
        System.out.println(dp);
        System.out.println(cnt);
        int size1 = cnt.size(), size2 = cnt.get(size1 - 1).size();
        return cnt.get(size1 - 1).get(size2 - 1);
    }

    public static int binarySearch1(int n, List<List<Integer>> d, int target) {
//        ����С��target�����Ԫ�ص�idx
        int l = 0, r = n;
        while (l < r) {
            int mid = (l + r) / 2;
            List<Integer> list = d.get(mid);
            if (list.get(list.size() - 1) >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static int binarySearch2(int n, List<Integer> list, int target) {
//        ���ش��ڵ���target����СԪ�ص�idx
        int l = 0, r = n;
        while (l < r) {
            int mid = (l + r) / 2;
            if (list.get(mid) < target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 6, 4, 5};
        System.out.println(findNumberOfLIS(nums));
    }
}
