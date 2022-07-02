package jianzhi;
import java.util.*;
public class replaceWords {
    class TrieNode {
        boolean isWord;
        TrieNode[]children;
        public TrieNode(){
            isWord=false;
            children=new TrieNode[26];
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root=new TrieNode();
        for(String word:dictionary){
            TrieNode cur=root;
            for(int i=0;i<word.length();i++){
                char ch=word.charAt(i);
                if(cur.children[ch-'a']==null)
                    cur.children[ch-'a']=new TrieNode();
                cur=cur.children[ch-'a'];
            }
            cur.isWord=true;
        }
        String[]strs=sentence.split(" ");
        for(int i=0;i<strs.length;i++){
            String str=strs[i];
            TrieNode cur=root;
            int j=-1;
            while(++j<str.length()){
                char ch=str.charAt(j);
                if(cur.isWord||(cur.children[ch-'a'])==null)
                    break;
                cur=cur.children[ch-'a'];
            }
            if(cur.isWord)
                strs[i]=str.substring(0,j);
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<strs.length;i++){
            sb.append(strs[i]);
            if(i!=strs.length-1)
                sb.append(" ");
        }
        return sb.toString();
    }
}
