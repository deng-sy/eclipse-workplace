package exercise_06;

import java.util.ArrayList;
import java.util.Scanner;

public class E2 {

	public static void main(String[] args) {
		System.out.println("Enter the number of objects:");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		System.out.println("Enter the weights of the objects:");
		int[] weight=new int[n];
		
		boolean isValued=false;
		while(!isValued) {
			for(int i=0;i<n;i++) 
				weight[i]=sc.nextInt();
			for(int i=0;i<n;i++) {
				if(weight[i]>10) {
					System.out.println("Error! The weight should be no more than 10.");
					isValued=false;
					continue;
				}
				else
					isValued=true;
			}
						
		}
		
		ArrayList<Bin> list=new ArrayList<>();
		
		Bin bin=new Bin();
		list.add(bin);
		for (int i = 0; i <n; i++) {
	        boolean added=false;    
	        for(Bin tmp: list){ 
	            if(tmp.addItem(weight[i])){
	                added=true;         
	                break;
	            }
	        }
	        if(!added){
	            Bin tmp=new Bin();
	            tmp.addItem(weight[i]);
	            list.add(tmp);
	        }
	    }
		
		
	

	
	for (int i = 0; i < list.size(); i++) {
        System.out.println("Container " + (i + 1)
                + " contains objects with weight " + list.get(i));
    }
	

}
}


 class Bin {
    private ArrayList<Double> objects = new ArrayList<>();
    private int totalWeight = 0;
    public Bin() {
    }

    
    public boolean addItem(double weight) {
        if ((totalWeight+weight) <= 10) {
            objects.add(weight);
            totalWeight += weight;
            return true;
        }
        else {
            return false;
        }
    }

    public String toString() {
        return objects.toString();
    }
}