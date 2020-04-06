package tutorial.app;

public class WarriorGame {

	public static void main(String[] args) throws InterruptedException {
		Warrior thor = new Warrior("Thor", 800, 130, 40);
		// Warrior loki = new Warrior("Loki", 800, 85, 40);

		Warrior loki = new DodgeWarrior("Loki", 800, 85, 40, .25);

		Battle.startFight(thor, loki);

		// ---- INTERFACE ADD ON ----
		// Test if Loki can teleport
		System.out.println("Loki " + loki.teleport());

		// Change ability
		loki.setTeleportAbility(new CantTeleport());
		System.out.println("Loki " + loki.teleport());
	}

}