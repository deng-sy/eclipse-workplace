package exercise_03;

import java.util.Scanner;

public class E1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String[] words = {"write","program","that"};
		
		char entrance = 'y';
		while(entrance == 'y') {
			int[] hashTable = new int[26];
			String answer = answer(words);
			int length = answer.length();
			for(int i = 0; i < length; i++) {
				hashTable[answer.charAt(i) - 'a'] ++;
			}
			
			int number = 0;
			int miss = 0;
			while(number != length) {
				System.out.print("(Guess) Enter a letter in word ");
				for(int i = 0; i < length; i++) {
					if(hashTable[answer.charAt(i) - 'a'] == -1)
						System.out.printf("%c", answer.charAt(i));
					else
						System.out.printf("*");
				}
				System.out.printf(">");
				String guess_string = input.next();
				char guess = guess_string.charAt(0);
				
				if(hashTable[guess - 'a'] == 0) {
					System.out.printf("	%c is not in the word\n", guess);
					miss++;
				}
				else if(hashTable[guess - 'a'] > 0) {
					number+=hashTable[guess - 'a'];
					hashTable[guess - 'a'] = -1;
					
				}
				else
					System.out.printf("	%c is already in the word\n", guess);
			}
			System.out.printf("The word is %s. You missed %d time(s)\n", answer, miss);
			System.out.print("Do you want to guess another word? Enter y or n>");
			String entrance_string = input.next();
			entrance = entrance_string.charAt(0);
		};
		System.out.println("Bye!");
	}
	
	public static String answer(String[] words) {
		int length=words.length;
		int index = (int)(Math.random() * length);
		return words[index];
	}
}

