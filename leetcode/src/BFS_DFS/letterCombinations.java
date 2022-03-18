package BFS_DFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按任意顺
//序返回。给出数字到字母的映射如下（与电话按键相同）。注意1不对应任何字母。
public class letterCombinations {

//    广度优先解决（bfs)
    public static List<String>letterCombinations_BFS(String digits){
        LinkedList<String>res=new LinkedList<>();
        if(digits==null||digits.isEmpty())
            return res;
        char[][] tab = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
                {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
        res.add("");
        while(res.peek().length()!=digits.length()){
            String remove=res.poll();
//            System.out.println(remove.length())-'2');
            char[]chars=tab[digits.charAt(remove.length())-'2'];
            System.out.println(Arrays.toString(chars));
            for(int i=0;i<chars.length;i++)
                res.add(remove+chars[i]);
            System.out.println(res);
        }
        return res;
    }

//    深度优先解决（dfs)
    public static List<String>letterCombinations_DFS(String digits){
    LinkedList<String>res=new LinkedList<>();
    if(digits==null||digits.isEmpty())
        return res;
    char[][] tab = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
            {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

    dfs(res,0,digits,tab,"");
    return res;
}

    public static void dfs(List<String>res,int idx,String digits,char[][]tab,String path){
        if(path.length()==digits.length()){
            res.add(path);
            return;
        }
        char[]chars=tab[digits.charAt(idx)-'2'];
        for(int i=0;i<chars.length;i++)
            dfs(res,idx+1,digits,tab,path+chars[i]);
    }
    public static void main(String[] args) {
        String digits="23";
        System.out.println(letterCombinations_DFS(digits));
    }
}
