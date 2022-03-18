package exercise_02;

import java.util.Scanner;

public class E5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String str;
		str=sc.next();
		StringBuffer sb=new StringBuffer(str);
		sb.reverse();
		
		int count = 0;  
		   for (int i = 0; i < str.length(); i++) {  
		       if (str.charAt(i) == sb.charAt(i)) {  
		            count++;  
		       }  
		   }  
		   if (count == str.length()) {  
		          
		       System.out.println("此字符串是一个回文字符串");  
		    } else {  
		       System.out.println("此字符串不是一个回文字符串");  
		    }  
	
		

	}

}
