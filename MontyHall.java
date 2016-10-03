import java.util.Scanner;

/**
 * This program presents the famous Monty Hall problem using Java.
 * The problem is apparently "paradoxical", but instead of being truly paradoxical, is merely very counter-intuitive.
 * The user should always switch when prompted; it offers a 2/3 chance of choosing the car over the 1/3 when the user
 * does not switch.  Most people believe that switching vs not switching is simply 50/50.  The program uses a number of
 * obviously named variables with values 1-3 to keep track of the door with the car, the door the user picked, and a number
 * of other essential doors (valid switches, swapped door, etc.)
 *@param The arguments are passed in.
 *@author William Zhang
 */





public class MontyHall
{
	// Declare things here, make them fields.  They are accessible everywhere.
	public static Scanner kb = new Scanner(System.in);

	public static void main(String[] args)
	{
		System.out.println("WELCOME TO THE WILL ZHANG GAME SHOW! IF YOU \nPICK THE CORRECT DOOR, YOU WIN A FREE CAR!!!!!");
		// model doors as ints

		int carDoor = (int)(Math.random() * 3 + 1); //random door between 1 and 3 inclusive

		int userDoor = getUserDoor();  //Asks user to choose a door

		int intRevealDoor = revealDoor(carDoor, userDoor); // Reveals a door with a goat behind it.  Cannot be the car door or the user door.
		System.out.println("There is a goat behind door " + intRevealDoor + ".");

		// Ask whether the user wants to swap doors
		boolean swap = getUserSwap();

		int newUserDoor = wannaSwap(swap, userDoor, intRevealDoor); // Asks user if they want to swap.  In this case, program will pick the one that hasn't bene picked yet.

		System.out.println("You picked door " + newUserDoor + ", and.... \n");

		if (newUserDoor == carDoor)
		{
			System.out.println("CONGRATULATIONS!!!! YOU HAVE JUST WON A FREE CAR!  DID I SAY CAR? LOL I MEANT BAR! HERE IT IS: \n====================================================================================================================================================================== \nCONGRATS!!!!!");
		}
		else
		{
			System.out.println("YOU LOSE! But you still get a goat.");
		}
	}

	/**
	 * If the user wants to swap, the program picks the remaining door that isn't the original door or the revealed door.
	 * If the user doesn't want to swap, the program does nothing.
	 *
	 *@param swap The bool value if the user wants to swap or not
	 *@param userDoor The variable which represents the door the user picked
	 *@param intRevealDoor The variable which represents the door that was revealed
	 *@return Returns either the original userDoor if no swap, or the remaining door if swapped.
	 */
	public static int wannaSwap(boolean swap, int userDoor, int intRevealDoor)
	{
		int count = 1;
		if (swap == true)
		{
			while (count == userDoor || count == intRevealDoor)
				count = (int) (Math.random() * 3 + 1);

			return count;
		}
		else
		{
			return userDoor;
		}		
	}

	/**
	 *
	 *Method asks the user whether they want to swap their door or not.
	 *
	 *@return Returns a boolean whether the user want to swap. (true to swap false to stay)
	 *
	 */
	public static boolean getUserSwap()
	{
		System.out.println("Would you like to switch your door?");
		String swap = kb.nextLine();
		if (swap.equals("yes") || swap.equals("Yes"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}


	/**
	 * This method calculates a door for the host to reveal as not the
	 * grand prize door.
	 *
	 *@param invalid1 A door that the host cannot open
	 *@param invalid2 A door that the host cannot open (may be the same as invalid1)
	 *@return Returns an int of the number door with a goat
	 */

	public static int revealDoor(int invalid1, int invalid2)
	{
		int reveal = (int) (Math.random() * 3 + 1);
		while (reveal == invalid1 || reveal == invalid2)
		{
			reveal = (int) (Math.random() * 3 +1);
		}
		return reveal;
	}

	/**
	 * Asks the user what door they want to pick
	 * @return The door the user picked
	 */

	public static int getUserDoor()
	{
		System.out.print("Choose a door from 1-3.\n");

		String answer = kb.nextLine();

		return Integer.parseInt(answer);


	}
}



// Also, thanks for the sticker.  It looks dope as hell.

