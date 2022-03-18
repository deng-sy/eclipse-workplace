package exercise_08;

import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class WriteRead {

	public static void main(String[] args) throws IOException {
		Random r=new Random();
		int[] array=new int[100];
		for(int i=0;i<100;i++) {
			array[i]=r.nextInt(500);
		}
		
		String filename="D:/Exercise12_15.txt";
		File file=new File(filename);
		FileWriter fw=null;
		
		try {
			if(!file.exists()) {
				file.createNewFile();
			}
			fw=new FileWriter(file);
			BufferedWriter bfw=new BufferedWriter(fw);
			for(int i=0;i<array.length;i++) {
				bfw.write(array[i]+" ");
			}
			bfw.close();
			fw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
		Scanner sc=new Scanner(file);
		int[] array1=new int[100];
		int i=0;
		while(sc.hasNext()) {
			array1[i++]=sc.nextInt();
		}
		sc.close();
		Arrays.sort(array1);
		
		for(int j=0;j<100;j++) {
			System.out.print(array1[j]+" ");
		}
		

	}

}
