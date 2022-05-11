package huawei;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Set<Integer>set=new TreeSet<>();
        set.add(1);
        set.add(0);
        set.add(0);
        for(Iterator it=set.iterator();it.hasNext();){
            System.out.println(it.next());
        }
    }
}
