package app;

import java.util.Random;

/**
 * @author hossam
 *
 */
public class DodgeWarrior extends Warrior {
	double dodgePercent;
	Random rand = new Random();

	/**
	 * @param name
	 * @param health
	 * @param attkMax
	 * @param blockMax
	 * @param dodgePercent
	 */
	public DodgeWarrior(String name, int health, int attkMax, int blockMax, double dodgePercent) {

		// Initialise with Warriors constructor
		super(name, health, attkMax, blockMax);
		this.dodgePercent = dodgePercent;

		// ---- INTERFACE ADD ON ----
		// We can define teleport ability with
		// one line of code
		teleportType = new CanTeleport();
	}

	@Override
	public int block() {

		double chance = rand.nextDouble();
		if (chance <= dodgePercent) {
			System.out.printf("%s Dodged the Attack\n\n", this.getName());
			return 10000;
		} else {
			return 1 + (int) (Math.random() * ((blockMax - 1) + 1));
		}
	}
}