package huawei;
import java.util.*;
//单词数组?words 的 有效编码 由任意助记字符串 s 和下标数组 indices 组成，且满足：
//
//words.length == indices.length
//助记字符串 s 以 '#' 字符结尾
//对于每个下标 indices[i] ，s 的一个从 indices[i] 开始、到下一个 '#' 字符结束（但不包括 '#'）的 子字符串 恰好与 words[i] 相等
//给你一个单词数组?words ，返回成功对 words 进行编码的最小助记字符串 s 的长度 。

public class minimumLengthEncoding {
//    法一：存储后缀
    public int minimumLengthEncoding1(String[] words) {
        Set<String>set=new HashSet<>(Arrays.asList(words));
        for(String word:words){
            for(int k=1;k<word.length();k++){
                set.remove(word.substring(k));
            }
        }
        int res=0;
        for(String word:set){
            res+=word.length()+1;
        }
        return res;
    }
//    法二：字典树
    public int minimumLengthEncoding2(String[] words) {
        TrieNode trie=new TrieNode();
        Map<TrieNode,Integer>nodes=new HashMap<>();
        for(int i=0;i<words.length;i++){
            String word=words[i];
            TrieNode cur=trie;
            for(int j=word.length()-1;j>=0;j--){
                cur=cur.get(word.charAt(j));
            }
            nodes.put(cur,i);
        }
        int res=0;
        for(TrieNode node:nodes.keySet()){
            if(node.cnt==0){
                res+=words[nodes.get(node)].length()+1;
            }
        }
        return res;
    }
}
class TrieNode{
    TrieNode[]children;
    int cnt;
    TrieNode(){
        children=new TrieNode[26];
        cnt=0;
    }
    public TrieNode get(char c){
        if(children[c-'a']==null){
            children[c-'a']=new TrieNode();
            cnt++;
        }
        return children[c-'a'];
    }
}
