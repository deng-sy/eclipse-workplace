package hard;
import java.util.*;
//在字典（单词列表）?wordList 中，从单词 beginWord?和 endWord 的 转换序列 是一个按下述规格形成的序列：
//序列中第一个单词是 beginWord 。
//序列中最后一个单词是 endWord 。
//每次转换只能改变一个字母。
//转换过程中的中间单词必须是字典?wordList 中的单词。
//给定两个长度相同但内容不同的单词 beginWord?和 endWord 和一个字典 wordList ，找到从?beginWord 到?endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0。

public class ladderLength {
    List<List<Integer>>edges=new ArrayList<>();
    Map<String,Integer>ids=new HashMap<>();
    int num=0;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        for(String word:wordList){
            addEdge(word);
        }
        addEdge(beginWord);
        if(!ids.containsKey(endWord))
            return 0;
        int[]distBegin=new int[num],distEnd=new int[num];
        Arrays.fill(distBegin,Integer.MAX_VALUE);
        Arrays.fill(distEnd,Integer.MAX_VALUE);
        int begin=ids.get(beginWord),end=ids.get(endWord);
        distBegin[begin]=0;
        distEnd[end]=0;

        Queue<Integer>queueBegin=new LinkedList<>(),queueEnd=new LinkedList<>();
        queueBegin.offer(begin);
        queueEnd.offer(end);
        while(!queueBegin.isEmpty()&&!queueEnd.isEmpty()){
            int beginSize=queueBegin.size();
            for(int i=0;i<beginSize;i++){
                int x=queueBegin.poll();
                if(distEnd[x]!=Integer.MAX_VALUE){
                    return (distEnd[x]+distBegin[x])/2+1;
                }
                for(int id: edges.get(x)){
                    if(distBegin[id]==Integer.MAX_VALUE){
                        distBegin[id]=distBegin[x]+1;
                        queueBegin.offer(id);
                    }
                }
            }
            int endSize=queueEnd.size();
            for(int i=0;i<endSize;i++){
                int y=queueEnd.poll();
                if(distBegin[y]!=Integer.MAX_VALUE){
                    return (distEnd[y]+distBegin[y])/2+1;
                }
                for(int id: edges.get(y)){
                    if(distEnd[id]==Integer.MAX_VALUE){
                        distEnd[id]=distEnd[y]+1;
                        queueEnd.offer(id);
                    }
                }
            }

        }
        return 0;
    }
    private void addWord(String word){
        if(!ids.containsKey(word)){
            ids.put(word,num++);
            edges.add(new ArrayList<>());
        }
    }
    private void addEdge(String word){
//       添加虚拟节点
        addWord(word);
        int id1=ids.get(word);
        char[]arr=word.toCharArray();
        for(int i=0;i<arr.length;i++){
            char tmp=arr[i];
            arr[i]='*';
            String newWord=new String(arr);
            addWord(newWord);
            int id2=ids.get(newWord);
            edges.get(id1).add(id2);
            edges.get(id2).add(id1);
            arr[i]=tmp;
        }
    }
}
