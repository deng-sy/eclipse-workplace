package huawei;
import java.util.*;
//��������?words �� ��Ч���� �����������ַ��� s ���±����� indices ��ɣ������㣺
//
//words.length == indices.length
//�����ַ��� s �� '#' �ַ���β
//����ÿ���±� indices[i] ��s ��һ���� indices[i] ��ʼ������һ�� '#' �ַ��������������� '#'���� ���ַ��� ǡ���� words[i] ���
//����һ����������?words �����سɹ��� words ���б������С�����ַ��� s �ĳ��� ��

public class minimumLengthEncoding {
//    ��һ���洢��׺
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
//    �������ֵ���
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
