package huawei;
import java.util.*;

// We have imported the necessary tool classes.
// If you need to import additional packages or classes, please import here.

public class NameMatch {
    static String[]words;
    public static void main(String[] args) {
        System.out.println(isValid("zhan san aei","zhsae"));
//        Scanner sc=new Scanner(System.in);
//        String str=sc.nextLine();
//        String[]names=str.split(",");
//        String match=sc.next();
//        List<String>list=new ArrayList();
//        for(String name:names){
//            String[]words=name.split(" ");
//            if(isValid(words,match)){
//                list.add(name);
//            }
//        }
//        for(int i=0;i<list.size();i++){
//            System.out.print(list.get(i));
//            if(i!=list.size()-1)
//                System.out.print(",");
//        }
    }
    public static boolean isValid(String name,String match){
        words=name.split(" ");
        List<List<String>>res=new ArrayList<>();
        return backtrack(match,0,words.length,new ArrayList<>());

    }
    private static boolean backtrack(String match, int idx, int n, List<String>list){
        if(idx==match.length()){
            if(list.size()==n)
                for(int i=0;i<words.length;i++){
                    if(!isMatch(words[i],list.get(i)))
                        break;
                    if(i==words.length-1)
                        return true;
                }
            return false;
        }
        StringBuilder sb=new StringBuilder();
        for(int j=idx;j<match.length();j++){
            sb.append(match.charAt(j));
            list.add(sb.toString());
            if(backtrack(match,j+1,n,list))
                return true;
            list.remove(list.size()-1);
        }
        return false;
    }
    private static boolean isMatch(String name,String match){
        if(name.length()<match.length())
            return false;
        for(int i=0;i<match.length();i++){
            if(name.charAt(i)==match.charAt(i))
                continue;
            else
                return false;
        }
        return true;
    }
}

