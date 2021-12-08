public class Gorilla extends Mammal {
    
    public void throwSomething() {
        this.energyLevel -= 5;
        System.out.printf("The gorilla threw something! Now has %s energy.\n", energyLevel);
    }
    public void eatBanana() {
        this.energyLevel +=10;
        System.out.printf("Gorilla ate a banana. Now has %s energy\n", energyLevel);
    }
    public void climb() {
        this.energyLevel -=10;
        System.out.printf("Gorilla climbed up a tree. Now has %s energy\n", energyLevel);
    }
}
