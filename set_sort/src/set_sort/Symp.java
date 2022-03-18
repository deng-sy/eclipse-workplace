package set_sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Symp implements Comparable<Symp> {
	 private double score;
	 private String name;

	
	public Symp(double score, String name) {
		super();
		this.score = score;
		this.name = name;
	}


	public double getScore() {
		return score;
	}


	public void setScore(double score) {
		this.score = score;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	 public boolean equals(Object o) {
		 if(this==o) {
			 return true;
		 }
		 if(!(o instanceof Symp)) {
			 return false;
		 }
			 Symp p=(Symp) o;
			 return this.name.equals(p.name);
			  
	 }



	 @Override
	    public int compareTo(Symp o) {
		 if(o.name.equals(this.name)) {
			 return 0;
		 }
	        return o.score-this.score>=0?1:-1;    //∞¥ƒÍ¡‰≈≈–Ú

		 }
	    

	
	public static void main(String[] args) {
//	    Set<Symp> SympSet=new TreeSet<>(new MyComparator1());
		Set<Symp> SympSet=new TreeSet<Symp>();
		Symp Symp1=new Symp(2.0,"a");
		Symp Symp2=new Symp(1.0,"bb");
		Symp Symp3=new Symp(3.0,"ccc");
		Symp Symp4=new Symp(3.0,"a");
	//	System.out.println(Symp1.compareTo(Symp4));
//		
//		SympSet.add(Symp1);
//		SympSet.add(Symp2);
//		SympSet.add(Symp3);
//		SympSet.add(Symp4);
//		SympSet.add(new Symp(5.0,"e"));
		
	
		
		List<Symp> sympList=new ArrayList<Symp>();

		sympList.add(Symp1);
		sympList.add(Symp2);
		sympList.add(Symp3);
		sympList.add(Symp4);

		
		Comparator<Symp> comparator = new Comparator<Symp>() {
			@Override
			public int compare(Symp o1,Symp o2) {
				return o1.getScore()-o2.getScore()<=0?1:-1;
				}
			
		};
		
		Collections.sort(sympList,comparator);
		for(int i=0;i<sympList.size();i++) {
			SympSet.add(sympList.get(i));
			//System.out.println(sympList.get(i).getScore());
		}
		



		Iterator<Symp> it=SympSet.iterator();
		while(it.hasNext()) {
			Symp std=(Symp)it.next();
			System.out.println(std.name+" "+std.score);
		}
		
		

	


			


	}

}
