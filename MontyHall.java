import java.util.Scanner;

public class MontyHall
{
	// Declare things here, make them fields.  They are accessible everywhere.
	public static Scanner kb = new Scanner(System.in);

	public static void main(String[] args)
	{
		// model doors as ints

		int carDoor = (int)(Math.random() * 3 + 1); //random door between 1 and 3 inclusive

		int userDoor = getUserDoor();

		System.out.println("There is a goat behind door " + revealDoor(carDoor, userDoor));

		// Ask whether the user wants to swap doors
		boolean swap = getUserSwap();

		/**
		#TODO finsh this
		*/
		//if (swap = )

		/**
		#TODO Tell whether they win!
		*/
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
			return true;
		else
			return false;
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
		while (reveal == invalid1 || reveal == invalid2);
		{
			reveal = (int) (Math.random() * 3 +1);
		}
		return reveal;
	}

	public static int getUserDoor()
	{
		System.out.print("Choose a door from 1-3.");

		String answer = kb.nextLine();

		return Integer.parseInt(answer);


	}
}