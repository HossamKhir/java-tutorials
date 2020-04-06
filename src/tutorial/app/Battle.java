package tutorial.app;

//Battle is a utility class so
//it contains only static methods

//Static methods and fields should
//be used when it doesn't make sense
//for a real world object to be able 
//to perform and action, or when values 
//should be shared by all objects
/**
 * @author hossam
 *
 */
public class Battle {

	// Receive warrior objects
	/**
	 * @param w1
	 * @param w2
	 * @throws InterruptedException
	 */
	public static void startFight(Warrior w1, Warrior w2) throws InterruptedException {
		// Loop giving each a chance to attack
		// and block
		while (true) {
			if (getAttackResult(w1, w2).equals("Game Over")) {
				System.out.println("Game Over");
				break;
			}
			if (getAttackResult(w2, w1).equals("Game Over")) {
				System.out.println("Game Over");
				break;
			}
		}
	}

	// Accept 2 warriors
	/**
	 * @param wA
	 * @param wB
	 * @return
	 * @throws InterruptedException
	 */
	public static String getAttackResult(Warrior wA, Warrior wB) throws InterruptedException {
		// Get warriors attack and block
		int wAAttkAmt = wA.attack();
		int wBBlockAmt = wB.block();

		// Subtract block from attack
		int dmg2WarB = wAAttkAmt - wBBlockAmt;

		// If damaged subtract damage from health
		if (dmg2WarB > 0) {
			wB.health = wB.health - dmg2WarB;
		} else
			dmg2WarB = 0;

		// Print out a damage report
		// printf is for formatted output
		// %s : Strings
		// %d : Integers
		// %f : Floats / Doubles
		// %.2f : To limit to 2 decimals
		// %c : Characters
		// %e : Scientific Notation
		// %t : Dates
		// %b : Booleans
		System.out.printf("%s Attacks %s and deals " + "%d Damage\n", wA.getName(), wB.getName(), dmg2WarB);

		// Output health changes
		System.out.printf("%s Has %d Health\n\n", wB.getName(), wB.health);

		// Pauses execution for 1500 milliseconds
		Thread.sleep(1500);

		// Check if health fell below 0
		if (wB.health <= 0) {
			System.out.printf("%s has Died and %s is " + "Victorious\n", wB.getName(), wA.getName());
			return "Game Over";
		} else
			return "Fight Again";
	}
}