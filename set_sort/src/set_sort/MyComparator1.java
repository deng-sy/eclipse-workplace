package set_sort;

import java.util.Comparator;

public class MyComparator1 implements Comparator<Symp> {
	
	@Override
	public int compare(Symp o1,Symp o2) {
		//return o2.getId()-o1.getId();
		return o1.getScore()-o2.getScore()<=0?1:-1;
		}

}
