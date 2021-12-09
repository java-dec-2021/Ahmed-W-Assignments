public class Mammal {
    
    public int energyLevel = 100;

    public Mammal(){

    }
    public Mammal(int energyLevel){
        this.energyLevel = energyLevel;
    }



    public void displayEnergy() {
        System.out.printf("My energy level is: %s", energyLevel);
        
    }
}
