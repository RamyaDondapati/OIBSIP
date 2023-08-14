import java.util.*;
class Guess
{
	public void prepare()
	{
		Random random=new Random();
		Scanner s1=new Scanner(System.in);
		int val=random.nextInt(30);
		System.out.println("A Random Number is generated");
		System.out.println("Enter the number of guesses you want to try.Guesses must be < 9");
		int ch=s1.nextInt();
		while(ch>9)
		{
			System.out.println("Your chances exceeds. *Please Enter number < 9 *");
			ch=s1.nextInt();
		}
		System.out.println("You have"+ch+"Chances");
		int score=100,q=0;
		for(q=0;q<ch;q++)
		{
			
			System.out.println("Enter the number you guessed.Chance no"+(q+1));
			int num=s1.nextInt();
			if(num==val)
			{
				System.out.println("That's Amazing ...You won the Game");
				System.out.println("Your score is "+score);
				break;
			}
			else if(num>val)
			{
				System.out.println("Your number is greater than the original number");
			}
			else
			{
				System.out.println("Your number is less than the original number");
			}
			score-=10;
		} 
		if(q>=ch)
		{
		    System.out.println("Alas!,You Lost the game");
			System.out.println("The number is "+val);
			System.out.println("Your score is: 0");
		}
	}
}
class Room
{
public static void main(String args[])
{
	System.out.println("Java developer Task-2");
	Scanner s1=new Scanner(System.in);
	Guess f=new Guess();
	System.out.println("Shall we start the game ? : Yes/No");
	String str=s1.nextLine();
	while(str.equalsIgnoreCase("Yes")||str.equalsIgnoreCase("y"))
	{
		f.prepare();
		System.out.println("Do you want to proceed ? Yes/No");
		str=s1.nextLine();
	}
	System.out.println("Game closed!!!");
}
}