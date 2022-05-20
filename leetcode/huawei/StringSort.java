package huawei;

import java.util.*;
public class StringSort {
    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String input=sc.nextLine();
            int n=input.length();
            char[]chars=new char[n];
            char[]output=input.toCharArray();
            int len_letter=0;
            for(int i=0;i<n;i++){
                char ch=input.charAt(i);
                if(Character.isLetter(ch))
                    chars[len_letter++]=ch;
            }
            halfSort(chars,len_letter);
            int idx=0;
            for(int i=0;i<n;i++){
                if(Character.isLetter(output[i]))
                    output[i]=chars[idx++];
            }
            System.out.println(String.valueOf(output));
        }
    }
    public static void halfSort(char array[],int len_letter){
        for(int i=1;i<len_letter;i++){
            int last=i-1;
            if(isBiggerChar(array[last],array[i])){
                char key=array[i];
                int low=0;
                int high=last;
                while(low<=high){
                    int mid=(low+high)>>1;
                    if(isBiggerChar(array[mid],key)){
                        high=mid-1;
                    }else{
                        low=mid+1;
                    }
                }
                for(int j=i;j>low;j--){
                    array[j]=array[j-1];
                }
                array[low]=key;
            }
        }
    }
    public static boolean isBiggerChar(char ch1,char ch2){
        ch1=Character.toLowerCase(ch1);
        ch2=Character.toLowerCase(ch2);
        return ch1>ch2;


    }


}
