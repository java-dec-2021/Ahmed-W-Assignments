public class Human {
    
    public int strength = 3;
    public int stealth = 3;
    public int intelligence = 3;
    public int health = 100;

    public Human(){

    }

    public Human(int health, int intelligence){
        this.health = health;
        this.intelligence = intelligence;
    }

    public Human(int health){
        this.health = health;
    }

    public Human(int strength, int stealth, int health){
        this.stealth = stealth;
        this.strength = strength;
        this.health = health;
    }

    // public Human(int stealth){
    //     this.stealth = stealth;
    // }
    
    // public void attack(Human human) {
    //     human.health -= this.strength;
    // }

    public void displayInfo() {
        System.out.printf("%s has: %d health | %d intelligence | %d stealth | %d strength \n", this.getClass().getName() ,this.health, this.intelligence, this.stealth, this.strength);
    }
}
