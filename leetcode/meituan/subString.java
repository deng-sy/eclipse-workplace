package meituan;

import java.util.HashMap;
import java.util.Scanner;

//����һ��ֻ����Сд�ַ����ַ���s������԰�����˳����������ַ����е��ַ����������Ź�����ַ����У�������ж��ٸ���acbcca���Ӵ���
//
//���磬�ַ�����dacbccab���к�1����acbcca���Ӵ�����������ʽ���ź����Ҳֻ�ܰ���1����acbcca���Ӵ����ַ�����acbccaacccb���к�1����acbcca���Ӵ��������ųɡ�acbccacbcca�� �������2����acbcca���Ӵ���
public class subString {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String pattern="acbcca";
            String str=sc.next();
            char[]chars=str.toCharArray();
            HashMap<Character,Integer> map=new HashMap();
            for(char ch:chars){
                map.put(ch,map.getOrDefault(ch,0)+1);
            }
            int cnt=0;
            int num_a=map.get('a');
            int num_b=map.get('b');
            int num_c=map.get('c');
            while(num_a>=2&&num_b>=1&&num_c>=3){
                num_a-=1;
                num_b-=1;
                num_c-=3;
                cnt++;
            }
            System.out.println(cnt);



        }
    }
}
