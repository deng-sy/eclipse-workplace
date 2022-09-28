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
            HashSet<Integer> set = new HashSet<>();      // �������е��������
            for(int i = 0; i < m; i++) {
                weight[i] = Integer.parseInt(params[i]);
                set.add(weight[i]);
            }
            Arrays.sort(weight);
            // ��֤a<b
            if(a > b){
                int temp = a;
                a = b;
                b = temp;
            }
            if(weight[0] < a || weight[m - 1] > b){
                // ���е����У�������С��С��a�����Ĵ���b���϶���ɲ�������
                System.out.println("NO");
            }else{
                if(set.contains(a) && set.contains(b))   // ������е������Ѿ�������a��b����û����
                    System.out.println("YES");
                else{
                    if(set.contains(a) || set.contains(b)){
                        // ���ֻ����a��b�����һ��n-m�Ƿ���ڵ���1��������һ��������Ҫ�ֿ�
                        System.out.println(n - m >= 1 && weight[m - 1] <= b? "YES": "NO");
                    }else{
                        // ������Ҫ���n-m�Ƿ���ڵ���2����������������Ҫ�ֿ�
                        System.out.println(n - m >= 2? "YES": "NO");
                    }
                }
            }
        }
    }
}