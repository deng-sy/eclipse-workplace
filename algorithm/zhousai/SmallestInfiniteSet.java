package zhousai;

import java.util.*;

class SmallestInfiniteSet{
    Set<Integer> set;

    public SmallestInfiniteSet() {
        set=new TreeSet<>();
    }

    public int popSmallest() {
        for(int i=1;;i++){
            if(set.contains(i))
                continue;
            set.add(i);
            return i;
        }
    }

    public void addBack(int num) {
        if(set.contains(num))
            set.remove(num);

    }
}
