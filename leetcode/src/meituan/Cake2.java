package meituan;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

public class Cake2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        String[] params;
        while((line = br.readLine()) != null) {
            params = line.trim().split(" ");
            int n = Integer.parseInt(params[0]);
            int m = Integer.parseInt(params[1]);
            int a = Integer.parseInt(params[2]);
            int b = Integer.parseInt(params[3]);
            params = br.readLine().trim().split(" ");
            int[] weight = new int[m];
            HashSet<Integer> set = new HashSet<>();      // 保存现有蛋糕的重量
            for(int i = 0; i < m; i++) {
                weight[i] = Integer.parseInt(params[i]);
                set.add(weight[i]);
            }
            Arrays.sort(weight);
            // 保证a<b
            if(a > b){
                int temp = a;
                a = b;
                b = temp;
            }
            if(weight[0] < a || weight[m - 1] > b){
                // 现有蛋糕中，重量最小的小于a，最大的大于b，肯定完成不了需求
                System.out.println("NO");
            }else{
                if(set.contains(a) && set.contains(b))   // 如果现有蛋糕中已经包含了a和b，就没问题
                    System.out.println("YES");
                else{
                    if(set.contains(a) || set.contains(b)){
                        // 如果只包含a或b，检查一下n-m是否大于等于1，即还有一个重量需要现烤
                        System.out.println(n - m >= 1 && weight[m - 1] <= b? "YES": "NO");
                    }else{
                        // 否则需要检查n-m是否大于等于2，即两个重量都需要现烤
                        System.out.println(n - m >= 2? "YES": "NO");
                    }
                }
            }
        }
    }
}