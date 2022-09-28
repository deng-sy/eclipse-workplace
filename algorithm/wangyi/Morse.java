package wangyi;

import java.util.Scanner;

//��֪Ħ��˹������ַ�ӳ���ϵ���£�
//A -> 0
//B -> 1
//C -> 10
//D -> 11
//E -> 100
//F -> 101
//G -> 110
//H -> 111
//��ǰ���ǻ�ȡ����һ��01�����ַ�������Ҫ����Ħ��˹������룬���ʹ��ж����ֽ��뷽����
public class Morse {
    public static int Morse(String str){
        char[]nums=str.toCharArray();
        int lastLastLast=0,lastLast=0,last=1;
        for(int i=0;i<nums.length;i++){
            int cur=last;
            if(i>0&&nums[i-1]=='1')
                cur+=lastLast;
            if(i>1&&nums[i-2]=='1')
                cur+=lastLastLast;
            lastLastLast=lastLast;
            lastLast=last;
            last=cur;

        }
        return last;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String str=sc.nextLine();
            System.out.println(Morse(str));
        }

    }
}
