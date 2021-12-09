public class HumanTest {
    public static void main(String[] args) {
        // Human playerOne = new Human();
        // Human playerTwo = new Human();
        // playerOne.attack(playerTwo);
        // playerOne.attack(playerTwo);
        // playerTwo.attack(playerOne);
        // playerOne.displayHealth();
        // playerTwo.displayHealth();
        Wizard w1 = new Wizard();
        Ninja n1 = new Ninja();
        Samurai s1 = new Samurai();
        Samurai s2 = new Samurai();
        w1.displayInfo();
        System.out.println(Samurai.getSamurai() + " samurai");
        n1.displayInfo();
        n1.steal(s1);
        w1.fireball(n1);
        s1.deathBlow(s2);
        n1.displayInfo();
        w1.displayInfo();
        s2.displayInfo();



    }
}
