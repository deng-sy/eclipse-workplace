package exercise_05;

import java.util.Arrays;

public class E2 {
	public static String[] split(String s, String regex) {
			 
		String str="";
		int i=0;
		while(i<s.length())
		{
			if(s.substring(i, i+1).matches(regex)==true)
			{
				if(i!=0)
				{
				str=str+s.substring(0,i)+",";
				}
				str=str+s.substring(i,i+1)+",";
				s=s.substring(i+1, s.length());
			}
			else
			{
				i++;
			}
		}
		str+=s;
		String[] sub=str.split(",");
		return sub;
		
	}

	public static void main(String[] args) {
		String[] str1=split("ab#12#453","#");
		System.out.println(Arrays.toString(str1));
		String[] str2=split("a?b?gf#e","[?#]");
		System.out.println(Arrays.toString(str2));
		 
		

	}

}





	

