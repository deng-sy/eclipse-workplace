package yuanfudao;

import java.util.HashMap;
import java.util.Scanner;

public class CollectPrims {
    //    分解质因数
    private static HashMap<Integer, Integer> getPrims(int K) {
        HashMap<Integer, Integer> res = new HashMap<>();
        int i = 2;
        while (i <= K) {
            if (i == K) {
                res.put(i, res.getOrDefault(i, 0) + 1);
                break;
            } else if (K % i == 0) {
                res.put(i, res.getOrDefault(i, 0) + 1);
                K /= i;
            } else
                i++;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
//            int K = sc.nextInt();
//            System.out.println(getPrims(K));

            int M = sc.nextInt();
            while (M-- > 0) {
                int K = sc.nextInt();
                int N = sc.nextInt();
                int[] nums = new int[N];
                for (int i = 0; i < N; i++) {
                    nums[i] = sc.nextInt();
                }
                HashMap<Integer, Integer> target = getPrims(K);
                HashMap<Integer, Integer> current = getPrims(K);
                int left = -1;
                int ans = 0;
                for (int right = 0; right < N; right++) {
                    if (target.containsKey(nums[right])) {
                        current.put(nums[right],current.getOrDefault(nums[right],0)+1);
                    }
                    if(current.equals(target)){}
                }
                System.out.println(ans);

            }


        }
    }
}
