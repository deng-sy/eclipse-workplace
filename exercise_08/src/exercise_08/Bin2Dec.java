package exercise_08;

import java.util.Scanner;
public class Bin2Dec {
	public static int bin2Dec(String binString) throws BinaryFormatException{
		int len=binString.length();
		char ch;
		int dec=0;
		for(int i=len-1;i>=0;i--) {
			ch=binString.charAt(i);
			if(ch!='0'&&ch!='1') {
				throw new BinaryFormatException(binString);
			}
			if(ch=='1') {
				dec=(int) (dec+Math.pow(2,len-1-i));
			}
		}
		return dec;
	}
	
	public static void main(String[] args) throws BinaryFormatException  {
		System.out.println("输入一个二进制字符串:");
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		System.out.println(str+" 对应的十进制数是 "+bin2Dec(str));
	}

}
