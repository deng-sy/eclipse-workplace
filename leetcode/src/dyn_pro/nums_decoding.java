package dyn_pro;

import java.util.Arrays;

public class nums_decoding {
    //    �����ַ���������


//    �ⷨһ���ݹ�
    public static int nums_decoding1(String s){
//        ���ö�������������һ�β�һ����������һ�β�����
        int[] map=new int[s.length()];//�洢��������ظ�����
        Arrays.fill(map,-1);
        return binaryTreeTraversal(s.toCharArray(),s.length(),map,0);
    }

    private static int binaryTreeTraversal(char[] chars,int length,int[] map,int index){
        if(index>=length)
            return 1;
        if(map[index]!=-1)
            return map[index];
        if(chars[index]=='0')
            return 0;
        int res=binaryTreeTraversal(chars,length,map,index+1);
        if(index<length-1&&(chars[index]=='1'||(chars[index]=='2'&&chars[index+1]<='6')))
            res+=binaryTreeTraversal(chars,length,map,index+2);
        map[index]=res;
        return res;
    }

//    �ⷨ��������
//    �ο�쳲���������
    public static int nums_decoding2(String s){
        int length=s.length();
        char[] chars=s.toCharArray();
//        int[]dp=new int[length+1];
//        dp[0]=1;
        int lastLast=0,last=1;
        for(int i=0;i<length;i++){
            int cur=0;
            if(chars[i]!='0')
//                dp[i]+=dp[i-1];
                cur=last;
            if(i>0&&(chars[i-1]=='1'||(chars[i-1]=='2'&&chars[i-1]<='6')))
//                dp[i]+=dp[i-2];
                cur+=lastLast;
            lastLast=last;
            last=cur;

//            System.out.println(lastLast+" "+last+" "+cur);
        }
//        return dp[s.length()];
        return last;
    }

    public static void main(String[] arg3) {
        String s="162";
        System.out.println(nums_decoding2(s));

    }
}
