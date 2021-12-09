public class Bat extends Mammal {
    
    public Bat(int energyLevel){
        super(energyLevel);
    }

    public void fly() {
        this.energyLevel -= 50;
        System.out.println("WOOSH! The bat took off in flight");
    }
    public void eatHumans() {
        this.energyLevel += 25;
    }
    public void attackTown() {
        this.energyLevel -= 100;
        System.out.println("AAAARRGGH! The bat is attacking!");
    }
    
}
