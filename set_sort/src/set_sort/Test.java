package set_sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Test {
	
	public static void main(String[] args) {
		List<Symp> sympList=new ArrayList<Symp>();
		List<Symp> test=new ArrayList<Symp>();
		Symp Symp1=new Symp(2.0,"a");
		Symp Symp2=new Symp(5.0,"bb");
		Symp Symp3=new Symp(1.0,"ccc");
		Symp Symp4=new Symp(1.0,"a");
		
		sympList.add(Symp1);
		sympList.add(Symp2);
		sympList.add(Symp3);
		sympList.add(Symp4);
		
//		Comparator<Symp> comparator = new MyComparator1();
//		Collections.sort(sympList,comparator);
		Iterator<Symp> it=sympList.iterator();
		while(it.hasNext()) {
			Symp tmp=it.next();
			if(tmp.getScore()==1.0) {
				it.remove();
			}
		}
		
		//sympList.remove(1);
		for(int i=0;i<sympList.size();i++) {
			System.out.println(sympList.get(i).getName()+" "+sympList.get(i).getScore());
			
		}

	

	}

}
