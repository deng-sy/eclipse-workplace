package Nums_String;

import java.lang.reflect.Array;
import java.util.Arrays;

class strStr {
    public static int strStr(String hh, String nn) {
    	
//    	KMP算法
        if(nn.isEmpty())
            return 0;
        int h=hh.length();
        int n=nn.length();
        hh=" "+hh;
        nn=" "+nn;
        char[] haystack=hh.toCharArray();
        char[] needle=nn.toCharArray();


        int[] next=new int[n+1];
        
//        构建next数组
        for(int i=2,j=0;i<=n;i++){
            while(j>0&&needle[i]!=needle[j+1]){
                j=next[j];
            }

           
            if(needle[i]==needle[j+1]){
                j++;
            }
            next[i]=j;
           
        }




        System.out.println(Arrays.toString(next));
//        for(int i=0;i<next.length;i++) {
//        	System.out.print(next[i]);
//        }

        for(int i=1,j=0;i<=h;i++){
            while(j>0&&haystack[i]!=needle[j+1]){
                j=next[j];
            }
            if(haystack[i]==needle[j+1]){
                j++;
            }
            if(j==n){
                return i-n;
            }
        }
        return -1;

    }
    
    public static void main(String[] args) {
    	int result=strStr("abcababcabc", "babbabbabbabbab");
		System.out.println(result);
	}
}
