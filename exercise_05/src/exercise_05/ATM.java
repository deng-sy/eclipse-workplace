package exercise_05;
import java.util.Scanner;
 
public class ATM 
{
	public static void main(String args[]) throws Exception

	{

		Account[] atm = new Account[10];

		for(int i = 0; i< atm.length ; i++)

		{
			atm[i] = new Account(i,100);
		}

		int id = 0;
		int index = 0;
		Scanner input = new Scanner(System.in);
		while(true)
		{
			System.out.println("Enter an id:");
			id = input.nextInt();

			while(!((id >= 0) && (id <= 9)))

			{
				
				System.out.print("Plese enter a right ID:");
				System.out.println();
				id = input.nextInt();

			}
			boolean quit=false; 
			while(!quit) {
				System.out.println("Main menu\r\n1:check balance");

				System.out.println("2:withdraw");

				System.out.println("3:deposite");

				System.out.println("4:exit");

				index = input.nextInt();
				switch(index){
				case 1:
					System.out.println("Balance:" + atm[id].getBalance());
					break;
				case 2:
					System.out.println("Enter the money you want to withdraw");
					atm[id].withDraw(input.nextDouble());
					break;
				case 3:
					System.out.println("Enter the money you want to deposite");
					atm[id].deposit(input.nextDouble());
					break;
				case 4:
					quit=true;
					break;
				default:
					System.out.println("Please enter the right choice.");
					break;
					
				}
			}

		}

	}

	


}
