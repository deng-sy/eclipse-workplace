package dyn_pro;
import java.util.*;
//����һ���ַ��� s ��һ���ַ����б� wordDict ��Ϊ�ֵ䡣�����ж��Ƿ���������ֵ��г��ֵĵ���ƴ�ӳ� s ��
//ע�⣺��Ҫ���ֵ��г��ֵĵ���ȫ����ʹ�ã������ֵ��еĵ��ʿ����ظ�ʹ�á�

public class wordBreak {
    public boolean wordBreak(String s, List<String> wordDict){
        Set<String>dictSet=new HashSet<>(wordDict);
        System.out.println(dictSet);
        boolean[]dp=new boolean[s.length()+1];
        dp[0]=true;
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(dp[j]&&dictSet.contains(s.substring(j,i))){
                    System.out.print(s.substring(j,i)+" ");
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        wordBreak wordBreak=new wordBreak();
        String s="leetcode";
        List<String>wordDict=new ArrayList<>();
        wordDict.add("leet") ;
        wordDict.add("code");
        System.out.println(wordBreak.wordBreak(s,wordDict));
    }
}
