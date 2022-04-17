package dyn_pro;
import java.util.*;
//给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
//注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。

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
