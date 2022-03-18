package exercise_08;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DeleteString {

	    public static void main(String[] args) throws FileNotFoundException {
	        File filesource=new File("d://test.txt");
	        Scanner input=new Scanner(filesource);
	        StringBuffer temp=new StringBuffer();
	        while(input.hasNext())
	        {
	            String tem=input.nextLine();
	            temp.append(tem.replace("John", "")+"\r\n");
	        }
	        PrintWriter output=new PrintWriter(filesource);
	        output.print(temp);
	        input.close();
	        output.close();
	    }

}
