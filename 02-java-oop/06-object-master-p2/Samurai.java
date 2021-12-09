public class Samurai extends Human {
    
    private int health = 200;
    private static int numSamurai = 0;

    public Samurai(){
        super(200);
        numSamurai++;
    }

    public void deathBlow(Human human) {
        human.health = 0;
        this.health -= (this.health/2);
    }

    public void meditate(){
        this.health += (this.health/2);
    }

    public static int getSamurai(){
        return numSamurai;
    }
}
