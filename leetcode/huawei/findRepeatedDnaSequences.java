package huawei;
import java.util.*;
public class findRepeatedDnaSequences {
    final int L=10;
    Map<Character,Integer>bin=new HashMap<>(){{put('A',0);put('C',1);put('G',2);put('T',3);}};
    public List<String>findRepeatedDnaSequences(String s){
        List<String>res=new ArrayList<>();
        int n=s.length();
        if(n<=L)
            return res;
        int x=0;
        for(int i=0;i<L-1;i++){
            x=(x<<2)|bin.get(s.charAt(i));
        }
        System.out.println(x);
        Map<Integer,Integer>cnt=new HashMap<>();
        for(int i=0;i<=n-L;i++){
            x=((x<<2)|bin.get(s.charAt(i+L-1)))&((1<<(L*2))-1);
            System.out.println(x);
            cnt.put(x,cnt.getOrDefault(x,0)+1);
            if(cnt.get(x)==2)
                res.add(s.substring(i,i+L));
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(new findRepeatedDnaSequences().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
}
