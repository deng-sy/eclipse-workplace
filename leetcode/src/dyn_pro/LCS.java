package dyn_pro;

//给定两个字符串s tr1和s tr2,输出两个字符串的最长公共子串。题目保证str1和str2的最长公共子串存在且唯一。
public class LCS {
    public static String LCS(String s1,String s2){
        int maxLength=0,maxLast=0;//分别为最长公共字符串长度及其最后一个元素在s1中的位置
        int[]dp=new int[s2.length()+1];
        for(int i=0;i<s1.length();i++){
            for(int j=s2.length()-1;j>=0;j--){
                if(s1.charAt(i)==s2.charAt(j)){
                    dp[j+1]=dp[j]+1;
                    if(dp[j+1]>maxLength){
                        maxLength=dp[j+1];
                        maxLast=i;
                    }
                }else
                    dp[j+1]=0;

            }
        }
        return s1.substring(maxLast-maxLength+1,maxLast+1);
    }

    public static void main(String[] args) {
        String s1="AB2345CD",s2="12345EF";
        System.out.println(LCS(s1,s2));
    }
}
