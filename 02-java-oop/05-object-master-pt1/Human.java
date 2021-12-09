public class Human {
    
    private int strength = 3;
    private int stealth = 3;
    private int intelligence = 3;
    private int health = 100;

    
    
    public void attack(Human human) {
        human.health -= this.strength;
    }

    public void displayHealth() {
        System.out.printf("Player has %d health\n", this.health);
    }
}
